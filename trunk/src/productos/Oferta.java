package productos;

public abstract class Oferta implements Articulo {
	
	private double descuento;

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public abstract double calcularPrecio();

}
