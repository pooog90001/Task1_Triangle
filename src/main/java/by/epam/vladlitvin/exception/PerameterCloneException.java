package by.epam.vladlitvin.exception;

/**
 * Created by vlad_ on 3/24/2017.
 */
public class PerameterCloneException extends Throwable {
    public PerameterCloneException() {
        super();
    }

    public PerameterCloneException(String message) {
        super(message);
    }

    public PerameterCloneException(String message, Throwable cause) {
        super(message, cause);
    }

    public PerameterCloneException(Throwable cause) {
        super(cause);
    }
}
