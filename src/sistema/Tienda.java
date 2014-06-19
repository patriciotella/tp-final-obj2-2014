package sistema;

import java.util.LinkedList;
import java.util.List;

import productos.Presentacion;
import productos.Stock;
import productos.Ubicacion;
import ventas.Venta;

public class Tienda {

	private List<Stock> stock;
	private List<Venta> ventas;// Lo mismo con las ventas, para devolución y
								// cambio hay
								// que buscar la venta y cancelarla.

	public void registrarVenta(Venta unaVenta) {
		this.ventas.add(unaVenta);
	}

	public List<Venta> getVentasRealizadas() {
		return this.ventas;
	}

	public List<Stock> getStock() {
		return this.stock;
	}

	public List<Stock> getPresentacionesConStockMinimo() {
		List<Stock> stocksMinimos = new LinkedList<Stock>();
		for (Stock stockPresentacion : this.stock) {
			if (stockPresentacion.esStockMinimo())
				stocksMinimos.add(stockPresentacion);
		}
		return stocksMinimos;
	}

	public List<Stock> getPresentacionesConStockCritico() {
		List<Stock> stocksCriticos = new LinkedList<Stock>();
		for (Stock stockPresentacion : stock) {
			if (stockPresentacion.esStockCritico())
				stocksCriticos.add(stockPresentacion);
		}
		return stocksCriticos;
	}

	public List<Venta> ventasRealizadas() {
		return this.ventas;
	}

	public List<Presentacion> presentacionesConStockMinimo() {

		List<Presentacion> retorno = new LinkedList<Presentacion>();

		for (Stock stock : this.stock) {
			if (stock.esStockMinimo())
				retorno.add(stock.getPresentacion());
		}

		return retorno;
	}

	public List<Presentacion> presentacionesConStockCritico() {

		List<Presentacion> retorno = new LinkedList<Presentacion>();

		for (Stock stock : this.stock) {
			if (stock.esStockCritico())
				retorno.add(stock.getPresentacion());
		}

		return retorno;
	}

	public float montoCompradoPor(Cliente unCliente) {

		float montoTotal = 0f;

		for (Venta venta : this.ventas) {
			if (venta.fueCompradaPor(unCliente))
				montoTotal += venta.getMonto();
		}

		return montoTotal;
	}

	public void ubicarPresentacion(Presentacion unaPresentacion,
			Ubicacion unaUbicacion) throws PresentacionNotFoundException {
		this.buscarPresentacionEnTienda(unaPresentacion).setUbicacion(
				unaUbicacion);
	}

	private Presentacion buscarPresentacionEnTienda(Presentacion unaPresentacion)
			throws PresentacionNotFoundException {
		for (Stock stock : this.stock) {
			if (stock.esStockDePresentacion(unaPresentacion))
				return stock.getPresentacion();
		}
		throw new PresentacionNotFoundException(
				"No se encontro la presentacion en la tienda");
	}
	
	public void cambiar(Presentacion unaPresentacion, Venta unaVenta) {
		
		
	}
	
	public float getGanancia(){
		float gananciaTotal = 0f;
		for(Venta venta : this.ventas)
			gananciaTotal += venta.getMonto();
		return gananciaTotal;
	}
	
}
