package Research.Exceptions;

public class CannotBecomeResearcherException extends Exception {
    private static final long serialVersionUID = 1L;

    public CannotBecomeResearcherException() {
        super("This User cannot be a Researcher!");
    }

    public CannotBecomeResearcherException(String message) {
        super(message);
    }
}
