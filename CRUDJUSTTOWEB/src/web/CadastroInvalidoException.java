package web;

public class CadastroInvalidoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CadastroInvalidoException( String errorMessage ) {
		super(errorMessage);
	} 
		
}
