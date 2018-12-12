package hu.me.iit.exception;

public class DtoConversionException extends RuntimeException {

    public DtoConversionException(String message) {
        super(message);
    }

    public DtoConversionException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
