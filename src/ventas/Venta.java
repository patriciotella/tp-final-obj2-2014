package ventas;

import java.util.List;

import productos.Articulo;
import sistema.Cliente;

public abstract class Venta {
	
	private List<Articulo> articulos;
	private Cliente cliente;
	
	/**
	 * Crea una instancia de venta.
	 * @param unaListaDeArticulos: una lista de objetos que implementen la interfaz
	 *        Articulo.
	 * @param unCliente: una instancia de Cliente.
	 */
	protected Venta(List<Articulo> unaListaDeArticulos, Cliente unCliente){
		articulos = unaListaDeArticulos;
		cliente = unCliente;
	}
	
	/**
	 * Retorna la suma de los precios de los artículos de la venta.
	 * @return Double.
	 */
	public Double getMonto(){
		Double montoFinal = 0d;
		for(Articulo articulo : articulos){
			montoFinal += articulo.getPrecio();
		}
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
	 * Retorna la lista de artículos comprados.
	 * @return List<Articulo>.
	 */
	public List<Articulo> getDetalle(){
		return articulos;
	}

}
