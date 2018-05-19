package exception;

/**
 * Created by Piotr on 19.05.2018.
 */
public class XmlValidationException extends Exception{
    public XmlValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
