package Research.Exceptions;

public class ResearchProjectJoinException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResearchProjectJoinException() {
		super("User can not join a project");
	}

	public ResearchProjectJoinException(String message) {
        super(message);
    }
}
