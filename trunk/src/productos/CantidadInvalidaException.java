package productos;

public class CantidadInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CantidadInvalidaException(String unMensaje) {
		super(unMensaje);
	}
	
	public CantidadInvalidaException() {
		super();
	}
}
