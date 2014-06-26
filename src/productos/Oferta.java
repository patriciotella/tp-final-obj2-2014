package productos;

/**
 * Esta clase abstracta representa un Articulo en oferta, es decir que tendra las mismas caracteristicas de 
 * un Articulo pero tiene un descuento para restarle al precio unitario de venta del mismo.
 */
public abstract class Oferta implements Articulo {
	
	private float descuento;

	protected Oferta(float unDescuento) {
		this.descuento = unDescuento;
	}
	
	/**
	 * Retorna el descuento que se le hara al Articulo.
	 * @return float
	 */
	public float getDescuento() {
		return descuento;
	}

	/**
	 * Establece el descuento que se le hara al Articulo.
	 * @param descuento
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public abstract float calcularPrecio();
	
	public abstract float getPrecio();
	
	public abstract float getPrecioCompra();

}
