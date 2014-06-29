package sistema;

public class NoTieneSaldoSuficienteParaRealizarOperacionException extends
		Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoTieneSaldoSuficienteParaRealizarOperacionException() {
		super();
	}

	public NoTieneSaldoSuficienteParaRealizarOperacionException(String unMensaje) {
		super(unMensaje);
	}

}
