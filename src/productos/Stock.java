package productos;

/**
 * Clase que indica la cantidad que hay en la Tienda de una Presentacion.
 * Contene una Presentacion de la cual se sabe la cantidad que hay en la Tienda
 * (indicado por el int).
 */
public class Stock {

	private int cantidad;
	private Presentacion presentacion;// Ver si puede ser una Oferta tambi�n.

	/**
	 * Constructor de clase Strock
	 * 
	 * @param cant
	 * @param p
	 */
	public Stock(int cantidad, Presentacion unaPresentacion) {
		this.cantidad = cantidad;
		this.presentacion = unaPresentacion;
	}

	/**
	 * Retorna la cantidad que hay en la tienda de la Presentacion.
	 * 
	 * @return int
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad que habra en la tienda de la Presentacion.
	 * 
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Indica si el Stock en la tienda es igual a la cantidad minima que debe
	 * tener la Presentacion
	 * 
	 * @return boolean
	 */
	public boolean esStockMinimo() {
		return presentacion.getStockMinimo() == cantidad;
	}

	/**
	 * Indica si el Stock en la tienda es igual a la cantidad critica que debe
	 * tener la Presentacion
	 * 
	 * @return boolean
	 */
	public boolean esStockCritico() {
		return presentacion.getStockCritico() == cantidad;
	}

	/**
	 * Retorna la Presentacion de la cual se tiene el Stock en la tienda
	 * 
	 * @return Presentacion
	 */
	public Presentacion getPresentacion() {
		return this.presentacion;
	}

	/**
	 * Indica si la Presentacion contenida en el Stock es la misma Presentacion
	 * pasada como parametro.
	 * 
	 * @param Presentacion
	 *            unaPresentacion
	 * @return boolean
	 */
	public boolean esStockDePresentacion(Presentacion unaPresentacion) {
		return this.presentacion.equals(unaPresentacion);
	}

	public void sumarCantidad(int unaCantidad) {
		this.cantidad += unaCantidad;
	}

	public void restarCantidad(int unaCantidad) {
		this.cantidad -= unaCantidad;
	}

}
