package productos;

public abstract class Oferta {
	
	private double descuento;

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public abstract double calcularPrecio();

}
