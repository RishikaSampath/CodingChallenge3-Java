package exception;

import java.io.Serializable;

public class InvalidEmailFormatException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public InvalidEmailFormatException(String message) {
        super(message);
    }
}
