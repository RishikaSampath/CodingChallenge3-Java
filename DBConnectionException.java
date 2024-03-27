package exception;

import java.io.Serializable;

public class DBConnectionException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public DBConnectionException(String message) {
        super(message);
    }
}
