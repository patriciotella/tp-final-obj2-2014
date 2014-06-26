package productos;

import java.util.List;

/**
 * Esta clase representa un paquete de ofertas, es decir un conjunto de productos u otras ofertas a su vez.
 * Cada paquete de ofertas tiene una lista de ofertas conteniendo todos los productos ofertados.
 */
public class PaqueteDeOferta extends Oferta {
	
	private List<Oferta> ofertas;

	public PaqueteDeOferta(List<Oferta> unaListaDeOfertas, float unDescuento) {
		super(unDescuento);
		this.ofertas = unaListaDeOfertas;
	}
	
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
			resultado += oferta.getPrecio();
			
		}
		return (resultado/this.getDescuento());
	}

	@Override
	public float getPrecioCompra() {
		float precioCompra = 0f;
		for(Oferta oferta : ofertas)
			precioCompra += oferta.getPrecioCompra();
		return precioCompra;
	}
	
	public void agregarOferta(Oferta unaOferta) {
		this.ofertas.add(unaOferta);
	}

	public List<Oferta> getOfertas() {
		return this.ofertas;
	}
}
