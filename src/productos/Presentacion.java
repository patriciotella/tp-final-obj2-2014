package productos;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase que representa las presentaciones de los productos en la tienda,
 * indicando todos los datos que se conocen del producto. Una Presentacion tiene
 * un codigo de barras, stock minimo y critico, precio unitario de compra y
 * venta, lista de los precios por los que fue pasando la presentacion del
 * producto en el trascurso del tiempo, una ubicacion fisica dentro de la tienda
 * y una unidad de medida que indica el peso de la presentacion
 */
public class Presentacion implements Articulo {

	private String codigoBarras;
	private int stockMinimo;
	private int stockCritico;
	private float precioUnitarioCompra;
	private float precioUnitarioVenta;
	private List<Float> listaDePrecios;
	private Producto producto;
	private Ubicacion ubicacion;
	private String unidadeDeMedida;
	private Stock stock;

	/**
	 * Constructor de clase
	 * 
	 * @param cod
	 * @param smin
	 * @param scrit
	 * @param puc
	 * @param puv
	 * @param list
	 * @param p
	 * @param ub
	 * @param med
	 */
	public Presentacion(String codigoDeBarra, int stockMinimo, int stockCritico,
			float precioUnitarioCompra, float precioUnitarioVenta,
			Producto producto, Ubicacion ubicacion, String unidadDeMedida) {
		this.codigoBarras = codigoDeBarra;
		this.stockMinimo = stockMinimo;
		this.stockCritico = stockCritico;
		this.precioUnitarioCompra = precioUnitarioCompra;
		this.precioUnitarioVenta = precioUnitarioVenta;
		this.listaDePrecios = new LinkedList<Float>();
		this.listaDePrecios.add(this.precioUnitarioVenta);
		this.producto = producto;
		this.ubicacion = ubicacion;
		this.unidadeDeMedida = unidadDeMedida;
	}

	/**
	 * Retorna el codigo de barras de la presentacion.
	 * 
	 * @return String
	 */
	public String getCodigoDeBarra() {
		return this.codigoBarras;
	}

	/**
	 * Retorna el stock minimo que debe tener la presentacion.
	 * 
	 * @return int
	 */
	public int getStockMinimo() {
		return this.stockMinimo;
	}

	/**
	 * Retorna el stock critico que debe tener la presentacion.
	 * 
	 * @return int
	 */
	public int getStockCritico() {
		return this.stockCritico;
	}

	/**
	 * Retorna la lista de precios por los cuales fue pasando la presentacion. a
	 * lo largo del transcurso del tiempo.
	 * 
	 * @return List<Float>
	 */
	public List<Float> getListaDePrecios() {
		return this.listaDePrecios;
	}

	/**
	 * Retorna el nombre del producto que posee la presentacion.
	 * 
	 * @return String
	 */
	public String getNombre() {
		return this.producto.getNombre();
	}

	/**
	 * Retorna la marca del producto que posee la presentacion.
	 * 
	 * @return String
	 */
	public String getMarca() {
		return this.producto.getMarca();
	}

	/**
	 * Actualiza el precio de venta al público. El nuevo precio se agrega a la lista
	 * de precios de la presentación.
	 * @param precioDeVentaNuevo
	 */
	public void modificarPrecioDeVenta(float precioDeVentaNuevo) {
		this.precioUnitarioVenta = precioDeVentaNuevo;
		this.listaDePrecios.add(precioDeVentaNuevo);
	}

	/**
	 * Retorna la descripcion del producto que posee la presentacion.
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return this.producto.getDescripcion();
	}

	/**
	 * Retorna el tipo del producto que posee la presentacion.
	 * 
	 * @return String
	 */
	public String getTipo() {
		return this.producto.getTipo();
	}

	/**
	 * Retorna la ubicacion dentro de la tienda de la presentacion.
	 * 
	 * @return Ubicacion
	 */
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	/**
	 * Retorna la medida en la que viene la presentacion.
	 * 
	 * @return String
	 */
	public String getUnidadDeMedida() {
		return this.unidadeDeMedida;
	}

	/**
	 * Establece el stock minimo que deberia tener la presentacion de un
	 * producto.
	 * 
	 * @param int unaCantidad
	 */
	public void setStockMinimo(int unaCantidad) {
		this.stockMinimo = unaCantidad;
	}

	/**
	 * Establece el stock critico que deberia tener la presentacion de un
	 * producto.
	 * 
	 * @param int unaCantidad
	 */
	public void setStockCritico(int unaCantidad) {
		this.stockCritico = unaCantidad;
	}

	/**
	 * Establece el precio unitario por el que se compro la presentacion de un
	 * producto.
	 * 
	 * @param float precioCompra
	 */
	public void setPrecioUnitarioCompra(float precioCompra) {
		this.precioUnitarioCompra = precioCompra;
	}

	/**
	 * Establece el precio unitario por el que se vendera la presentacion de un
	 * producto.
	 * 
	 * @param float precioVenta
	 */
	public void setPrecioUnitarioVenta(float precioVenta) {
		this.precioUnitarioVenta = precioVenta;
	}

	/**
	 * Establece la ubicacion fisica de la presentacion dentro de una tienda.
	 * 
	 * @param Ubicacion
	 *            unaUbicacion
	 */
	public void setUbicacion(Ubicacion unaUbicacion) {
		this.ubicacion = unaUbicacion;
	}

	/**
	 * Retorna el precio unitario con el que se vendera al producto.
	 * @return float
	 */
	@Override
	public float getPrecio() {
		return this.precioUnitarioVenta;
	}

	/**
	 * Retorn el precio unitario con el que se compro al producto.
	 * 
	 * @return float
	 */
	@Override
	public float getPrecioDeCompra() {
		return this.precioUnitarioCompra;
	}

	/**
	 * Descuenta del stock que hay de la presentación en la tienda la cantidad de 
	 * unidades vendidas en una venta.
	 */
	@Override
	public void descontarStockDeVenta(int unaCantidadDeArticulos)
			throws ArticuloSinStockException {
		this.stock.restarCantidad(unaCantidadDeArticulos);
	}

	/**
	 * Settea el stock de la presentación en la tienda.
	 * @param unStock
	 */
	public void setStock(Stock unStock) {
		this.stock = unStock;
	}

	/**
	 * Retorna el stock de la presentación en una tienda.
	 * @return
	 */
	public Stock getStock() {
		return this.stock;
	}

	/**
	 * Cancela la compra de una presentación, esto quiere decir, sumarle una unidad a
	 * su stock.
	 */
	@Override
	public void cancelarCompraDeArticulo() {
		this.stock.sumarCantidad(1);
	}

	/**
	 * Retorna la ganancia que produce la venta de la presentación.
	 */
	@Override
	public float getGanancia() {
		return this.precioUnitarioVenta - this.precioUnitarioCompra;
	}
}
