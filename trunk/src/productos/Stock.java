package productos;

import java.util.Observable;

/**
 * Clase que indica la cantidad que hay en la Tienda de una Presentacion.
 * Contene una Presentacion de la cual se sabe la cantidad que hay en la Tienda
 * (indicado por el int).
 */
public class Stock extends Observable {

	private int cantidad;
	private Presentacion presentacion;// Ver si puede ser una Oferta tambi�n.

	/**
	 * Constructor de clase Strock
	 * 
	 * @param cantidad
	 * @param unaPresentacion
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
	public void setCantidad(int cantidad) throws CantidadInvalidaException {
		if (cantidad < 0)
			throw new CantidadInvalidaException(
					"La cantidad de un stock debe ser mayor o igual a 0");
		this.cantidad = cantidad;
		notificar();
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

	/**
	 * Suma una cantidad a la cantidad actual que tiene el stock.
	 * @param unaCantidad
	 */
	public void sumarCantidad(int unaCantidad) {
		this.cantidad += unaCantidad;
		notificar();
	}

	/**
	 * Resta una cantidad a la cantidad actual del stock.
	 * @param unaCantidad
	 * @throws ArticuloSinStockException
	 */
	public void restarCantidad(int unaCantidad)
			throws ArticuloSinStockException {
		if (!this.hayStockSuficienteParaRealizarVenta(unaCantidad)) {
			throw new ArticuloSinStockException("El articulo "
					+ this.presentacion.getNombre() + " no tiene stock.");
		} else
			this.cantidad -= unaCantidad;
	}

	private void notificar() {
		setChanged();
		notifyObservers();
	}

	/**
	 * Retorna true si la cantidad del stock es suficiente para satisfacer la 
	 * compra, esto quiere decir si al realizar la venta el stock tendría una
	 * cantidad mayor o igual a 0.
	 * @param unaCantidad
	 * @return
	 */
	public boolean hayStockSuficienteParaRealizarVenta(int unaCantidad) {
		return this.cantidad - unaCantidad >= 0;
	}

	/**
	 * Descuenta una cantidad del stock de articulos producto de una venta.
	 * @param unaCantidadDeArticulosVendidos
	 */
	public void descontarVentaDeArticulo(int unaCantidadDeArticulosVendidos) {
		this.cantidad -= unaCantidadDeArticulosVendidos;
	}
}
