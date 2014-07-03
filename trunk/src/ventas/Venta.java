package ventas;

import java.util.List;

import org.joda.time.LocalDate;

import productos.Articulo;
import sistema.Cliente;

public abstract class Venta {
	
	private List<Articulo> articulos;
	private Cliente cliente;
	private LocalDate fecha;
	
	/**
	 * Crea una instancia de venta.
	 * @param unaListaDeArticulos: una lista de objetos que implementen la interfaz
	 *        Articulo.
	 * @param unCliente: una instancia de Cliente.
	 */
	protected Venta(List<Articulo> unaListaDeArticulos, Cliente unCliente, LocalDate unaFecha){
		articulos = unaListaDeArticulos;
		cliente = unCliente;
		fecha = unaFecha;
		descontarStockDeVenta(unaListaDeArticulos);
	}
	
	/**
	 * Descuenta del stock de cada artículo una unidad, producto de la venta.
	 * @param unaListaDeArticulos
	 */
	private void descontarStockDeVenta(List<Articulo> unaListaDeArticulos) {
		for(Articulo articulo : unaListaDeArticulos){
			articulo.descontarStockDeVenta();
		}
	}

	/**
	 * Retorna la suma de los precios de los art�culos de la venta.
	 * @return Double.
	 */
	public Float getMonto(){
		Float montoFinal = 0f;
		for(Articulo articulo : articulos){
			montoFinal += articulo.getPrecio();
		}
		return montoFinal;
	}
	
	/**
	 * Retorna la ganancia producto de las ventas concretadas.
	 * El precio total de la venta - el precio de costo.
	 * @return
	 */
	public float getGanancia(){
		Float montoFinal = 0f;
		for(Articulo articulo : articulos)
			montoFinal += (articulo.getPrecio()-articulo.getPrecioCompra());
		return montoFinal;
	}
	/**
	 * Retorna el cliente que hizo la compra.
	 * @return Cliente.
	 */
	public Cliente getCliente(){
		return cliente;
	}
	
	/**
	 * Retorna la lista de art�culos comprados.
	 * @return List<Articulo>.
	 */
	public List<Articulo> getDetalle(){
		return articulos;
	}

	/**
	 * Retorna si esta venta fue realizada por el Cliente unCliente
	 * @param unCliente
	 * @return boolean
	 */
	public boolean fueCompradaPor(Cliente unCliente) {
		return unCliente.equals(this.cliente);
	}

	/**
	 * Retorna la fecha en que se cre� la venta.
	 * @return LocalDate
	 */
	public LocalDate getFecha(){
		return fecha;
	}

	public boolean incluyeArticulo(Articulo unArticulo) {
		return this.articulos.contains(unArticulo);
	}
	
	public void cancelarCompraDeArticulos() {
		for(Articulo articulo : this.getDetalle())
			articulo.cancelarCompraDeArticulo();
	}
}
