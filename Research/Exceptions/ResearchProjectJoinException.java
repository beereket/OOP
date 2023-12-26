package Research.Exceptions;

/**
 * Exception thrown when a user cannot join a research project.
 * This may happen if the user is already a participant in the project.
 */
public class ResearchProjectJoinException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new ResearchProjectJoinException with a default message.
	 */
	public ResearchProjectJoinException() {
		super("User cannot join the project");
	}

	/**
	 * Constructs a new ResearchProjectJoinException with a custom message.
	 *
	 * @param message The custom exception message.
	 */
	public ResearchProjectJoinException(String message) {
		super(message);
	}
}