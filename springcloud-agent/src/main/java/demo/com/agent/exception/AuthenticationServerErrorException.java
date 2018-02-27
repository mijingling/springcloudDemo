package demo.com.agent.exception;

public class AuthenticationServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 6493117017126877748L;

	public AuthenticationServerErrorException(String message) {
        super(message);
    }
}
