package productos;

import sistema.Tienda;

public class Ubicacion {
	
	private int pasillo;
	private int estante;
	private Tienda tienda;
	
	public Ubicacion(Tienda unaTienda, int unPasillo, int unEstante){
		pasillo = unPasillo;
		estante = unEstante;
		tienda = unaTienda;
	}
	
	public int getPasillo() {
		return pasillo;
	}
	public void setPasillo(int pasillo) {
		this.pasillo = pasillo;
	}
	public int getEstante() {
		return estante;
	}
	public void setEstante(int estante) {
		this.estante = estante;
	}

}
