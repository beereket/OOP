package Research.Exceptions;

public class ResearchSupervisorException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResearchSupervisorException() {
		super("Researcher's h-index is less than 3!");
	}

	public ResearchSupervisorException(String message) {
        super(message);
    }
}
