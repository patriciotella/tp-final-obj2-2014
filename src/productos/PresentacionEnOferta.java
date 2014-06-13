package productos;

public class PresentacionEnOferta extends Oferta {
	
	private Presentacion presentacion;

	public Presentacion getPresentacion() {
		return presentacion;
	}

	public double calcularPrecio()
	{
		return this.presentacion.getPrecioUnitarioVenta()*getDescuento();
	}
	 
}
