package productos;

/**
 * LAS INTERFACES SE COMENTAN ?
 */
public interface Articulo {

	/**
	 * Retorna el precio de venta unitario de un Articulo.
	 * @return float
	 */
	public float getPrecio();

	/**
	 * Retorna el precio por el cual se compro un Articulo.
	 * @return float
	 */
	public float getPrecioCompra();

	public float getGanancia();
	
	public void descontarStockDeVenta() throws ArticuloSinStockException;

	public void cancelarCompraDeArticulo();
	
}
