package productos;

import java.util.List;

public class PaqueteDeOferta extends Oferta {
	
	private List<Oferta> ofertas;

	@Override
	public double calcularPrecio() {
		double resultado=0;
		for (Oferta oferta : ofertas) {
			resultado += oferta.calcularPrecio();
			
		}
		return (resultado*this.getDescuento());
	}

}
