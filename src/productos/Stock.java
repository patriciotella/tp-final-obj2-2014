package productos;

public class Stock {
	
	private int cantidad;
	private Presentacion presentacion;

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
	
	

}
