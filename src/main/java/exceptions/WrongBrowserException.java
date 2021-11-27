package exceptions;

public class WrongBrowserException extends IllegalStateException {
    public WrongBrowserException(String str) {
        super(str);
    }
}
