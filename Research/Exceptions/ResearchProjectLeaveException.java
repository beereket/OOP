package Research.Exceptions;

/**
 * Exception thrown when a researcher cannot leave a research project.
 * This may happen if the researcher is not allowed to leave the project.
 */
public class ResearchProjectLeaveException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ResearchProjectLeaveException with a default message.
     */
    public ResearchProjectLeaveException() {
        super("Researcher cannot leave from this project!");
    }

    /**
     * Constructs a new ResearchProjectLeaveException with a custom message.
     *
     * @param message The custom exception message.
     */
    public ResearchProjectLeaveException(String message) {
        super(message);
    }
}

