package ro.jtonic.handson.xml;

/**
 * Created by jtonic on 9/7/13.
 */
public class DiscoveryApiException extends RuntimeException {

    public DiscoveryApiException() {
    }

    public DiscoveryApiException(String message) {
        super(message);
    }

    public DiscoveryApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
