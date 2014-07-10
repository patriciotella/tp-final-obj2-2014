package productos;

/**
 * Esta clase representa una presentacion en oferta, es decir un solo producto
 * con descuento.
 */
public class PresentacionEnOferta extends Oferta {

	private Presentacion presentacion;
	
	public PresentacionEnOferta(Presentacion unaPresentacion,
			float unDescuento) {
		super(unDescuento);
		this.presentacion = unaPresentacion;
	}


	/**
	 * Retorna la presentacion dentro de la oferta.
	 * 
	 * @return Presentacion
	 */
	public Presentacion getPresentacion() {
		return presentacion;
	}

	/*@Override
	public float calcularPrecio() {
		return this.presentacion.getPrecioUnitarioVenta() * getDescuento();
	}*/

	@Override
	public float getPrecio() {
		return this.presentacion.getPrecio()/getDescuento();
	}

	@Override
	public float getPrecioCompra() {
		return this.presentacion.getPrecioCompra();
	}


	@Override
	public void descontarStockDeVenta(int unaCantidadDeArticulos) throws ArticuloSinStockException {
		this.presentacion.descontarStockDeVenta(unaCantidadDeArticulos);
	}


	@Override
	public void cancelarCompraDeArticulo() {
		this.presentacion.cancelarCompraDeArticulo();
	}


	@Override
	public float getGanancia() {
		return this.presentacion.getGanancia();
	}

}
