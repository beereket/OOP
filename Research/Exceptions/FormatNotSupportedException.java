package Research.Exceptions;

/**
 * Exception thrown when a requested format is not supported.
 * Currently, only Plain Text and Bibtex formats are supported.
 */
public class FormatNotSupportedException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new FormatNotSupportedException with a default message.
     */
    public FormatNotSupportedException() {
        super("This format is not supported. Try Plain Text or Bibtex");
    }

    /**
     * Constructs a new FormatNotSupportedException with a custom message.
     *
     * @param message The custom exception message.
     */
    public FormatNotSupportedException(String message) {
        super(message);
    }
}

