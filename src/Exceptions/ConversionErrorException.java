package Exceptions;

public class ConversionErrorException extends RuntimeException {
    private String message;

    public ConversionErrorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
