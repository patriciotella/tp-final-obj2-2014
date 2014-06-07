package productos;

public class PresentacionEnOferta extends Oferta {
	
	private Presentacion presentacion;

	@Override
	public double calcularPrecio() {
		return this.presentacion.getPrecioUnitarioVenta();
	}

	public Presentacion getPresentacion() {
		return presentacion;
	}

}
