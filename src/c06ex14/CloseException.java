package c06ex14;

public class CloseException extends Exception {

	private static final long serialVersionUID = 1L;

	public CloseException(Throwable cause) {
		initCause(cause);
	}

	public CloseException(String message, Throwable cause) {
		super(message);
		initCause(cause);
	}
}
