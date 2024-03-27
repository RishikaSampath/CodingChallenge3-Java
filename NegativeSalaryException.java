package exception;

import java.io.Serializable;

public class NegativeSalaryException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public NegativeSalaryException(String message) {
        super(message);
    }
}
