package productos;

public abstract class Oferta implements Articulo {
	
	private float descuento;

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	public abstract float calcularPrecio();
	
	public abstract float getPrecio();
	
	public abstract float getPrecioCompra();

}
