package ventas;

public class EnvioEnProcesoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnvioEnProcesoException() {
		super();
	}
	
	public EnvioEnProcesoException(String unMensaje) {
		super(unMensaje);
	}
}
