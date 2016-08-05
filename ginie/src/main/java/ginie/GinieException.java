package ginie;

/**
 * Created by dhruvr
 */
public class GinieException extends RuntimeException {

    public GinieException() {
        super();
    }

    public GinieException(String message) {
        super(message);
    }

    public GinieException(String message, Throwable cause) {
        super(message, cause);
    }

    public GinieException(Throwable cause) {
        super(cause);
    }
}
