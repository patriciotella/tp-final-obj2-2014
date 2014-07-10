package sistema;

import java.util.LinkedList;
import java.util.List;

import productos.Articulo;
import productos.Presentacion;
import productos.Stock;
import productos.Ubicacion;
import ventas.Venta;

/**
 * Clase que representa una sucursal dentro de nuestro sistema de ventas. Cuenta
 * con una lista del Stock y otra de las Ventas realizadas dentro de la Tienda.
 */
public class Tienda {

	private List<Stock> stock;
	private List<Venta> ventas;
	private ConfiguracionDeDevolucionDeDinero formaDevolucionDeDinero;

	/**
	 * Constructor de Clase Tienda
	 * 
	 * @param stk
	 * @param vta
	 */
	public Tienda(List<Stock> stk, List<Venta> vta) {
		this.stock = stk;
		this.ventas = vta;
	}

	/**
	 * Crea una instancia de Tienda, sin ventas ni stock.
	 */
	public Tienda() {
		this.stock = new LinkedList<Stock>();
		this.ventas = new LinkedList<Venta>();
	}

	/**
	 * Registra una venta realizada en la tienda.
	 * 
	 * @param unaVenta
	 */
	public void registrarVenta(Venta unaVenta) {
		this.ventas.add(unaVenta);
	}

	/**
	 * Retorna las ventas realizadas en la tienda.
	 * 
	 * @return List<Venta>
	 */
	public List<Venta> getVentasRealizadas() {
		return this.ventas;
	}

	/**
	 * Retorna una lista con los stocks de los art�culos de la tienda.
	 * 
	 * @return List<Stock>
	 */
	public List<Stock> getStock() {
		return this.stock;
	}

	/**
	 * Retorna las presentaciones que tienen stock m�nimo.
	 * 
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
	 * 
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

	/**
	 * Retorna la cantidad de plata que lleva gastada un cliente en la tienda.
	 * 
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
	 * 
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
	 * Busca y retorna la presentaci�n en la tienda, si no la encuentra levanta
	 * una PresentacionNotFoundException.
	 * 
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

	/**
	 * Retorna la ganancia que tiene la tienda.
	 * 
	 * @return float
	 */
	public float getGanancia() {
		float gananciaTotal = 0f;
		for (Venta venta : this.ventas)
			gananciaTotal += venta.getGanancia();
		return gananciaTotal;
	}

	/**
	 * Se devuelve la venta entera, esto quiere decir, los articulos vuelven a
	 * estar en stock, la venta queda cancelada (se borra) y se devuelve parcial
	 * o totalmente el dinero al cliente, dependiendo de cómo esté configurado.
	 * 
	 * @param unaVenta
	 *            Si la venta no fue realizada en la tienda:
	 * @throws VentaNoEncontradaException
	 */
	public void devolver(Venta unaVenta) throws VentaNoEncontradaException {
		if (this.ventas.contains(unaVenta)) {
			unaVenta.cancelarCompraDeArticulos();
			this.formaDevolucionDeDinero.devolverDineroACliente(unaVenta);
			this.ventas.remove(unaVenta);
		} else
			throw new VentaNoEncontradaException();
	}

	/**
	 * En el caso de los cambios, el cliente entrega un producto comprado y
	 * lleva otro abonando la diferencia,o si el saldo es a su favor, se le
	 * genera una nota de crédito o se devuelve la diferencia al cliente. El 
	 * artículo que cambia vuelve a estar en stock.
	 * La acción a tomar es responsabilidad del vendedor (depende de la configura-
	 * ción de devolución de dinero.
	 * @param unArticulo
	 * @param unaVenta
	 */
	public void cambiarArticulo(Articulo unArticulo, Venta unaVenta) {
		// TODO
	}

	/**
	 * Setea la forma en que se devuelve al cliente el dinero en un cambio o en
	 * una devolución.
	 * @param unaConfiguracion
	 */
	public void setConfiguracionDeDevolucionDeDinero(
			ConfiguracionDeDevolucionDeDinero unaConfiguracion) {
		this.formaDevolucionDeDinero = unaConfiguracion;
	}

	/**
	 * Retorna true si hay stock suficiente en la tienda para realizar la venta
	 * de una presentación. Quiere decir, si la cantidad disponible en la tienda
	 * alcanza para satisfacer la compra.
	 * @param unaPresentacion
	 * @param cantidadDeUnidadesDeLaPresentacion
	 * @return boolean
	 * @throws PresentacionNotFoundException
	 */
	public boolean hayStockSuficienteParaRealizarVentaDe(
			Presentacion unaPresentacion, int cantidadDeUnidadesDeLaPresentacion)
			throws PresentacionNotFoundException {
		return buscarStockDePresentacion(unaPresentacion)
				.hayStockSuficienteParaRealizarVenta(
						cantidadDeUnidadesDeLaPresentacion);
	}

	/**
	 * Busca el stock de una presentación en la tienda, si no lo encuentra
	 * levanta una exception.
	 * @param unaPresentacion
	 * @return stock
	 * @throws PresentacionNotFoundException
	 */
	public Stock buscarStockDePresentacion(Presentacion unaPresentacion)
			throws PresentacionNotFoundException {
		for (Stock stock : this.stock) {
			if (stock.esStockDePresentacion(unaPresentacion))
				return stock;
		}
		throw new PresentacionNotFoundException(
				"No se encontro el stock de la presentacion.");
	}
}
