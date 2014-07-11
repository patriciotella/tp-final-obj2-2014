package ventas;

import java.util.List;

import org.joda.time.LocalDate;

import productos.Articulo;
import productos.ArticuloSinStockException;
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
		try{
			for(Articulo articulo : unaListaDeArticulos)
				articulo.descontarStockDeVenta(1);
		}catch (ArticuloSinStockException e){
			System.out.println("Compra imposible de realizar por falta de stock");
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
			montoFinal += articulo.getGanancia();
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
	
	/**
	 * Cancela la compra de un articulo en particular, devolviendolo al stock
	 * @param unArticulo
	 */
	public void cancelarCompraDeArticulo(Articulo unArticulo){
		articulos.remove(unArticulo);
		unArticulo.cancelarCompraDeArticulo();
	}
	/**
	 * cancela la compra de todos los articulos de la venta, notificando al stock
	 */
	public void cancelarCompraDeArticulos() {
		for(Articulo articulo : this.getDetalle())
			articulo.cancelarCompraDeArticulo();
	}
	
	/**
	 * Incluye un articulo a la venta, depende del stock del mismo
	 * @param unArticulo
	 */
	public void agregarArticuloALaCompra(Articulo unArticulo){
		try{
				articulos.add(unArticulo);
				unArticulo.descontarStockDeVenta(1);
		}catch (ArticuloSinStockException e){
			System.out.println("Compra imposible de realizar por falta de stock");
		}
	}

}
