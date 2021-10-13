package connection;

public class ConnectionError extends Exception {
    public ConnectionError(String ErrorMsg) {
        super (ErrorMsg);
    }
}
