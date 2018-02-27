package demo.com.agent.exception;

public class AuthenticationVerifyFailException extends RuntimeException {

	private static final long serialVersionUID = 3053894279272799962L;

	public AuthenticationVerifyFailException(String message) {
        super(message);
    }
}
