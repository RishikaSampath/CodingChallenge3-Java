package exception;

import java.io.Serializable;

public class FileUploadException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public FileUploadException(String message) {
        super(message);
    }
}
