package Research.Exceptions;

/**
 * Exception thrown when a user cannot become a researcher.
 * This can happen if the user is not eligible to be a researcher.
 */
public class CannotBecomeResearcherException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new CannotBecomeResearcherException with a default message.
     */
    public CannotBecomeResearcherException() {
        super("This User cannot be a Researcher!");
    }

    /**
     * Constructs a new CannotBecomeResearcherException with a custom message.
     *
     * @param message The custom exception message.
     */
    public CannotBecomeResearcherException(String message) {
        super(message);
    }
}

