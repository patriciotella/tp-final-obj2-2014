package sistema;

import java.util.LinkedList;
import java.util.List;

import productos.Articulo;
import productos.Presentacion;
import productos.Stock;
import productos.Ubicacion;
import ventas.Venta;

/**
 * Clase que representa una sucursal dentro de nuestro sistema de ventas.
 * Cuenta con una lista del Stock y otra de las Ventas realizadas dentro de la Tienda.
 */
public class Tienda {

	private List<Stock> stock;
	private List<Venta> ventas;// Lo mismo con las ventas, para devoluci�n y
	private ConfiguracionDeDevolucionDeDinero formaDevolucionDeDinero;
								// cambio hay
								// que buscar la venta y cancelarla.
	/**
	 * Constructor de Clase Tienda
	 * @param stk
	 * @param vta
	 */
	public Tienda(List<Stock> stk, List<Venta> vta){
		this.stock=stk;
		this.ventas=vta;
	}
	
	/**
	 * Crea una instancia de Tienda, sin ventas ni stock.
	 */
	public Tienda(){
		this.stock = new LinkedList<Stock>();
		this.ventas = new LinkedList<Venta>();
	}
	
	/**
	 * Registra una venta realizada en la tienda.
	 * @param unaVenta
	 */
	public void registrarVenta(Venta unaVenta) {
		this.ventas.add(unaVenta);
	}

	/**
	 * Retorna las ventas realizadas en la tienda.
	 * @return List<Venta>
	 */
	public List<Venta> getVentasRealizadas() {
		return this.ventas;
	}

	/**
	 * Retorna una lista con los stocks de los art�culos de la tienda.
	 * @return List<Stock>
	 */
	public List<Stock> getStock() {
		return this.stock;
	}

	/**
	 * Retorna las presentaciones que tienen stock m�nimo.
	 * @return List<Stock>
	 */
	public List<Stock> getPresentacionesConStockMinimo() {
		List<Stock> stocksMinimos = new LinkedList<Stock>();
		for (Stock stockPresentacion : this.stock) {
			if (stockPresentacion.esStockMinimo())
				stocksMinimos.add(stockPresentacion);
		}
		return stocksMinimos;
	}

	/**
	 * Retorna las presentaciones que tienen stock cr�tico.
	 * @return List<Stock>
	 */
	public List<Stock> getPresentacionesConStockCritico() {
		List<Stock> stocksCriticos = new LinkedList<Stock>();
		for (Stock stockPresentacion : stock) {
			if (stockPresentacion.esStockCritico())
				stocksCriticos.add(stockPresentacion);
		}
		return stocksCriticos;
	}

	//A PARTIR DE AC� HAY UN PAR REPETIDAS Y NO S� POR QU�.
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

	/**
	 * Retorna la cantidad de plata que lleva gastada un cliente en la tienda.
	 * @param unCliente
	 * @return float
	 */
	public float montoCompradoPor(Cliente unCliente) {
		float montoTotal = 0f;
		for (Venta venta : this.ventas) {
			if (venta.fueCompradaPor(unCliente))
				montoTotal += venta.getMonto();
		}
		return montoTotal;
	}

	/**
	 * Ubica una presentaci�n en la tienda (en un pasillo y un estante).
	 * @param unaPresentacion
	 * @param unaUbicacion
	 * @throws PresentacionNotFoundException
	 */
	public void ubicarPresentacion(Presentacion unaPresentacion,
			Ubicacion unaUbicacion) throws PresentacionNotFoundException {
		this.buscarPresentacionEnTienda(unaPresentacion).setUbicacion(
				unaUbicacion);
	}

	/**
	 * Busca y retorna la presentaci�n en la tienda, si no la encuentra
	 * levanta una PresentacionNotFoundException.
	 * @param unaPresentacion
	 * @return
	 * @throws PresentacionNotFoundException
	 */
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
	
	/**
	 * Retorna la ganancia que tiene la tienda.
	 * @return float
	 */
	public float getGanancia(){
		float gananciaTotal = 0f;
		for(Venta venta : this.ventas)
			gananciaTotal += venta.getGanancia();
		return gananciaTotal;
	}
	
	public void devolver(Venta unaVenta) throws VentaNoEncontradaException {
		if(this.ventas.contains(unaVenta)){
			unaVenta.cancelarCompraDeArticulos();
			this.formaDevolucionDeDinero.devolverDineroACliente(unaVenta);
			this.ventas.remove(unaVenta);
		}else
			throw new VentaNoEncontradaException();
	}
	
	public void cambiarArticulo(Articulo unArticulo, Venta unaVenta) {
		//TODO
	}
}
