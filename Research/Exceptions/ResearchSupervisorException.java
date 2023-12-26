package Research.Exceptions;

/**
 * Exception thrown when a researcher's h-index is less than 3,
 * making them ineligible to be a supervisor for a research project.
 */
public class ResearchSupervisorException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new ResearchSupervisorException with a default message.
	 */
	public ResearchSupervisorException() {
		super("Researcher's h-index is less than 3!");
	}

	/**
	 * Constructs a new ResearchSupervisorException with a custom message.
	 *
	 * @param message The custom exception message.
	 */
	public ResearchSupervisorException(String message) {
		super(message);
	}
}

