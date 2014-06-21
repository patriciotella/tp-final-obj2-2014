package sistema;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import productos.Oferta;
import ventas.Venta;

/**
 * Clase que representa al sistema de ventas de nuestra cadena de tiendas
 * Cuenta con una lista de tiendas que representa las sucursales, 
 * una lista de los clientes que se han creado una cuenta y una lista de 
 * ofertas.
 */
public class SistemaVentas extends Observable {
	
	private List<Tienda> sucursales;
	private List<Cliente> clientes;
	private List<Oferta> ofertas;
	
	/**
	 * Agrega una oferta a la lista de ofertas.
	 * @param Oferta unaOferta
	 */
	public void agregarOferta(Oferta unaOferta){
		ofertas.add(unaOferta);
		notificar(unaOferta);
	}
	
	/**
	 * Notifica a los clientes interesados que hay una nueva oferta.
	 * @param Oferta unaOferta
	 */
	private void notificar(Oferta unaOferta){
		setChanged();
		notifyObservers(unaOferta);
	}

	/** 
	 * Retorna todas las ventas realizadas en todas las sucursales de la cadena de tiendas.
	 * @return List<Venta>
	 */
	public List<Venta> getVentas() {
		List<Venta> ventasDeTiendas = new LinkedList<Venta>();
		for(Tienda tienda : sucursales)
			ventasDeTiendas.addAll(tienda.getVentasRealizadas());
		return ventasDeTiendas;
	}
	
	/*
	 ubicarProducto(Sucursal,Producto)
 +agregarOferta(Oferta)
+ filtrarVentas(FiltroDeVentas): List<Venta>
+ filtrarProductos(FiltroDeProductos): List<Presentacion>
+ filtrarEnvios(FiltroDeEnvios): List<Envio>
+ filtrarMontos(FiltroDeMonto): List<Integer>
+ filtrarCuentaCorriente(FiltroDeCTACTE): List<CuentaCorriente>
	 */

}
