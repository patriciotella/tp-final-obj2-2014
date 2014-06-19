package productos;

import java.util.List;

public class PaqueteDeOferta extends Oferta {
	
	private List<Oferta> ofertas;

	@Override
	public float calcularPrecio() {
		float resultado = 0f;
		for (Oferta oferta : ofertas) {
			resultado += oferta.calcularPrecio();
			
		}
		return (resultado*this.getDescuento());
	}

	@Override
	public float getPrecio() {
		float resultado = 0f;
		for (Oferta oferta : ofertas) {
			resultado += oferta.calcularPrecio();
			
		}
		return (resultado*this.getDescuento());
	}

	@Override
	public float getPrecioCompra() {
		float precioCompra = 0f;
		for(Oferta oferta : ofertas)
			precioCompra += oferta.getPrecioCompra();
		return precioCompra;
	}

}
