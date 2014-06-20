package sistema;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import productos.Oferta;
import ventas.Venta;

public class SistemaVentas extends Observable {
	
	private List<Tienda> sucursales;
	private List<Cliente> clientes;
	private List<Oferta> ofertas;
	
	public void agregarOferta(Oferta unaOferta){
		ofertas.add(unaOferta);
		notificar(unaOferta);
	}
	
	private void notificar(Oferta unaOferta){
		setChanged();
		notifyObservers(unaOferta);
	}

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
