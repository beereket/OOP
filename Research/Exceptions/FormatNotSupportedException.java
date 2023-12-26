package Research.Exceptions;

public class FormatNotSupportedException extends Exception {
	private static final long serialVersionUID = 1L;

    public FormatNotSupportedException() {
        super("This format is not supported. Try Plain Text or Bibtex");
    }
	
    public FormatNotSupportedException(String message) {
        super(message);
    }


}
