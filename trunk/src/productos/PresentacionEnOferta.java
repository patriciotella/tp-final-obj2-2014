package productos;

public class PresentacionEnOferta extends Oferta {
	
	private Presentacion presentacion;

	public Presentacion getPresentacion() {
		return presentacion;
	}

	public float calcularPrecio()
	{
		return this.presentacion.getPrecioUnitarioVenta()*getDescuento();
	}

	@Override
	public float getPrecio() {
		return this.presentacion.getPrecioUnitarioVenta()*getDescuento();
	}

	@Override
	public float getPrecioCompra() {
		return this.presentacion.getPrecioCompra();
	}
	 
}
