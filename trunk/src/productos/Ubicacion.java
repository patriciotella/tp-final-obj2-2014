package productos;

import sistema.Tienda;

/**
 * Clase que representa la ubicacion fisica de una Presentacion dentro de una Tienda.
 * Indica pasillo y estante de la tienda donde se encuentra.
 */
public class Ubicacion {
	
	private int pasillo;
	private int estante;
	private Tienda tienda;
	
	public Ubicacion(Tienda unaTienda, int unPasillo, int unEstante){
		pasillo = unPasillo;
		estante = unEstante;
		tienda = unaTienda;
	}
	
	/**
	 * Retorna el pasillo dentro de la Tienda donde se encuentra la Presentacion.
	 * @return int
	 */
	public int getPasillo() {
		return pasillo;
	}
	
	/**
	 * Establece el pasillo dentro de la Tienda donde se encontrara la Presentacion.
	 * @param pasillo
	 */
	public void setPasillo(int pasillo) {
		this.pasillo = pasillo;
	}
	
	/**
	 * Retorna el estante dentro de la Tienda donde se encuentra la Presentacion.
	 * @return int
	 */
	public int getEstante() {
		return estante;
	}
	
	/**
	 * Establece el estante dentro de la Tienda donde se encontrara la Presentacion.
	 * @param estante
	 */
	public void setEstante(int estante) {
		this.estante = estante;
	}
	
	/**
	 * Retorna la Tienda (sucursal) donde se encuentra la Presentacion.
	 * @return Tienda
	 */
	public Tienda getTienda() {
		return this.tienda;
	}
	
	/**
	 * Establece la Tienda (sucursal) donde se encontrara la Presentacion.
	 * @param unaTienda
	 */
	public void setTienda(Tienda unaTienda) {
		this.tienda = unaTienda;
	}

}
