package sistema;

import java.util.List;
import java.util.Observable;

import productos.Oferta;

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
