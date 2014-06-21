package productos;

/**
 * Esta clase representa una presentacion en oferta, es decir un solo producto con descuento.
 */
public class PresentacionEnOferta extends Oferta {
	
	private Presentacion presentacion;

	/**
	 * Retorna la presentacion dentro de la oferta.
	 * @return Presentacion
	 */
	public Presentacion getPresentacion() {
		return presentacion;
	}

	@Override
	public float calcularPrecio()
	{
		return this.presentacion.getPrecioUnitarioVenta()*getDescuento();
	}

	@Override
	public float getPrecio() {
		return this.presentacion.getPrecioUnitarioVenta()*getDescuento();
	}

	@Override
	public float getPrecioCompra() {
		return this.presentacion.getPrecioCompra();
	}
	 
}
