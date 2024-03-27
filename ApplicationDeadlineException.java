package exception;

import java.io.Serializable;

public class ApplicationDeadlineException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public ApplicationDeadlineException(String message) {
        super(message);
    }
}
