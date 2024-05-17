import Exceptions.ConversionErrorException;
import Models.OMDBTitle;
import Models.Title;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;


public class Request {
    public static void main (String[] args) throws IOException, InterruptedException{
        Scanner read = new Scanner(System.in);
        String search = "";
        List<Title> titles = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!search.equalsIgnoreCase("exit")) {
            System.out.println();
            System.out.printf("Type a movie to search: ");
            search = read.nextLine();
            if(search.equalsIgnoreCase("exit")){
                System.out.println();
                System.out.println(titles);
                break;
            }
            String address = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=a294459";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                //System.out.println(json);
                OMDBTitle myOMDBtitle = gson.fromJson(json, OMDBTitle.class);
                //System.out.println(myOMDBtitle);
                //try {
                Title mytitle = new Title(myOMDBtitle);
                //System.out.println("Converted title");
                System.out.println(mytitle);
                titles.add(mytitle);
                System.out.println("Your film has been added to films list!");
            } catch (ConversionErrorException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Argument error: ");
                System.out.println(e.getMessage());
            }catch (NullPointerException e) {
                System.out.println("It was not possible to convert the year because year is null");
                System.out.println(e.getMessage());
            }
        }
        FileWriter write = new FileWriter("films.json");
        write.write(gson.toJson(titles));
        write.close();
        System.out.println();
        System.out.println("The system finished correctly");
    }
}
