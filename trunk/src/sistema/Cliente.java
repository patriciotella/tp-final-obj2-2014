package sistema;

import java.util.Observable;
import java.util.Observer;

/**
 * Representa a un cliente dentro del sistema de ventas. Un cliente tiene
 * nombre, dni, direccion y una cuenta corriente
 */
public class Cliente implements Observer {

	private String nombre;
	private long dni;
	private String direccion;
	private CuentaCorriente ctacte;

	public Cliente(String n, long d, String dir,
			CuentaCorriente unaCuentaCorriente) {
		this.nombre = n;
		this.dni = d;
		this.direccion = dir;
		this.ctacte = unaCuentaCorriente;
	}

	/**
	 * Retorna el nombre de un cliente.
	 * 
	 * @return String
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Retorna el DNI de un cliente.
	 * 
	 * @return long
	 */
	public long getDNI() {
		return this.dni;
	}

	/**
	 * Retorna la direccion de un cliente.
	 * 
	 * @return String
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * Retorna la cuenta corriente del cliente
	 * 
	 * @return
	 */
	public CuentaCorriente getCuentaCorriente() {
		return this.ctacte; //<-Lo cambie, habia una recursion de la muerte.
	}

	/**
	 * Establece la direccion de un cliente
	 * 
	 * @param String
	 *            unaDireccion
	 */
	public void setDireccion(String unaDireccion) {
		this.direccion = unaDireccion;
	}

	/**
	 * Subscribe al cliente a la lista para recibir las ultimas ofertas de la
	 * tienda.
	 * 
	 * @param SistemaVentas
	 *            unSistemaDeVentas
	 */
	public void subscribirseALasOfertasDe(SistemaVentas unSistemaDeVentas) {
		unSistemaDeVentas.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	/*public void descontarCompraDeCuenta(Float unMonto) {
		this.ctacte.descontarSaldo(unMonto);
	}*/

}
