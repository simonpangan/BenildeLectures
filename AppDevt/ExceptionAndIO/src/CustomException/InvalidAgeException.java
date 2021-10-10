package CustomException;

public class InvalidAgeException extends Exception{

	private String message;
	
	
	public InvalidAgeException(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
