package productos;

public class ArticuloSinStockException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArticuloSinStockException() {
		super();
	}
	
	public ArticuloSinStockException(String unMensaje) {
		super(unMensaje);
	}

}
