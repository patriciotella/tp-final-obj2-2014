package productos;

public class Stock {
	
	private int cantidad;
	private Presentacion presentacion;//Ver si puede ser una Oferta también.

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean esStockMinimo() {
		return presentacion.getStockMinimo() == cantidad;
	}

	public boolean esStockCritico() {
		return presentacion.getStockCritico() == cantidad;
	}
	
	public Presentacion getPresentacion() {
		return this.presentacion;
	}

	public boolean esStockDePresentacion(Presentacion unaPresentacion) {
		return this.presentacion.equals(unaPresentacion);
	}
	
	

}
