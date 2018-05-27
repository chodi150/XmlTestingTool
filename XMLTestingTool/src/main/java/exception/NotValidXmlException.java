package exception;

/**
 * Created by Piotr on 19.05.2018.
 */
public class NotValidXmlException extends Exception {
    public NotValidXmlException(String message) {
        super(message);
    }

    public NotValidXmlException(String message, Throwable cause) {
        super(message, cause);
    }
}
