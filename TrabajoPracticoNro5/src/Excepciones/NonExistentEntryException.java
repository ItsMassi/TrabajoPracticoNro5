package Excepciones;

@SuppressWarnings("serial")
public class NonExistentEntryException extends Exception{
	
	public NonExistentEntryException(String msg) {
		super(msg);
	}
}
