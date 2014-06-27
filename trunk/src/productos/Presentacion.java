package productos;

import java.util.List;

/**
 * Clase que representa las presentaciones de los productos en la tienda, indicando todos los datos que se conocen del producto.
 * Una Presentacion tiene un codigo de barras, stock minimo y critico, precio unitario de compra y venta, lista de los precios por
 * los que fue pasando la presentacion del producto en el trascurso del tiempo, una ubicacion fisica dentro de la tienda y una 
 * unidad de medida que indica el peso de la presentacion
 */
public class Presentacion implements Articulo{
	 
	private String codigoBarras;
	 private int stockMinimo;
	 private int stockCritico;
	 private float precioUnitarioCompra;
	 private float precioUnitarioVenta;
	 private List<Float> listaPrecios;
	 private Producto producto;
	 private Ubicacion ubicacion;
	 private String unidadeDeMedida;
	 
	 /**
	  * Constructor de clase
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
	 public Presentacion(String cod,int smin,int scrit,float puc, float puv,List<Float> list,Producto p,Ubicacion ub,String med){
		 this.codigoBarras=cod;
		 this.stockMinimo=smin;
		 this.stockCritico=scrit;
		 this.precioUnitarioCompra=puc;
		 this.precioUnitarioVenta=puv;
		 this.listaPrecios=list;
		 this.producto=p;
		 this.ubicacion=ub;
		 this.unidadeDeMedida=med;
	 }
	 /**
	  * Retorna el codigo de barras de la presentacion.
	  * @return String
	  */
	 public String getCodigoDeBarra(){
		 return this.codigoBarras;
	 }
	 
	 /**
	  * Retorna el stock minimo que debe tener la presentacion.
	  * @return int
	  */
	 public int getStockMinimo(){
		 return this.stockMinimo;
	 }
	 
	 /**
	  * Retorna el stock critico que debe tener la presentacion.
	  * @return int
	  */
	 public int getStockCritico(){
		 return this.stockCritico;
	 }
	 
	 /**
	  * Retorn el precio unitario con el que se compro al producto.
	  * @return float
	  */
	 public float getPrecioUnitarioCompra(){
		 return this.precioUnitarioCompra;
	 }
	 
	 /**
	  * Retorna el precio unitario con el que se vendera al producto.
	  * @return float
	  */
	 public float getPrecioUnitarioVenta(){
		 return this.precioUnitarioVenta;
	 }
	 
	 /**
	  * Retorna la lista de precios por los cuales fue pasando la presentacion.
	  * a lo largo del transcurso del tiempo.
	  * @return List<Float>
	  */
	 public List<Float> getListaDePrecios(){
		 return this.listaPrecios;
	 }
	 
	 /**
	  * Retorna el nombre del producto que posee la presentacion.
	  * @return String
	  */
	 public String getNombre(){
		 return this.producto.getNombre();
	 }
	 
	 /**
	  * Retorna la marca del producto que posee la presentacion.
	  * @return String
	  */
	 public String getMarca(){
		 return this.producto.getMarca();
	 }
	 
	 // ESTE METODO CREO QUE NO DEBERIA SER PROPIO DE LA PRESENTACION SINO DEL PRODUCTO
	 // UNA PRESENTACION NO TIENE PORQUE SABER LAS OTRAS PRESENTACIONES CON LAS QUE VIENE EL PRODUCTO. NOSIERTO?
	 public List<Presentacion> getPresentaciones(){
		 return this.producto.getPresentaciones();
	 }
	 
	 /**
	  * Retorna la descripcion del producto que posee la presentacion.
	  * @return String
	  */
	 public String getDescripcion(){
		 return this.producto.getDescripcion();
	 }
	 
	 /**
	  * Retorna el tipo del producto que posee la presentacion.
	  * @return String
	  */
	 public String getTipo(){
		 return this.producto.getTipo();
	 }
	 
	 /**
	  * Retorna la ubicacion dentro de la tienda de la presentacion.
	  * @return Ubicacion
	  */
	 public Ubicacion getUbicacion(){
		 return this.ubicacion;
	 }
	 
	 /**
	  * Retorna la medida en la que viene la presentacion.
	  * @return String
	  */
	 public String getUnidadDeMedida(){
		 return this.unidadeDeMedida;
	 }
	 
	 /**
	  * Establece el stock minimo que deberia tener la presentacion de un producto.
	  * @param int unaCantidad
	  */
	 public void setStockMinimo(int unaCantidad){
		 this.stockMinimo = unaCantidad;
	 }
	 
	 /**
	  * Establece el stock critico que deberia tener la presentacion de un producto.
	  * @param int unaCantidad
	  */
	 public void setStockCritico(int unaCantidad){
		 this.stockCritico = unaCantidad;
	 }
	 
	 /**
	  * Establece el precio unitario por el que se compro la presentacion de un producto.
	  * @param float precioCompra
	  */
	 public void setPrecioUnitarioCompra(float precioCompra){
		 this.precioUnitarioCompra = precioCompra;
	 }
	 
	 /**
	  * Establece el precio unitario por el que se vendera la presentacion de un producto.
	  * @param float precioVenta
	  */
	 public void setPrecioUnitarioVenta(float precioVenta){
		 this.precioUnitarioVenta = precioVenta;
	 }
	 
	 /**
	  * Establece la ubicacion fisica de la presentacion dentro de una tienda.
	  * @param Ubicacion unaUbicacion
	  */
	 public void setUbicacion(Ubicacion unaUbicacion) {
		 this.ubicacion = unaUbicacion;
	 }

	 @Override
	 public float getPrecio() {
		 return this.precioUnitarioVenta;
	 }

	 @Override
	 public float getPrecioCompra() {
		 return this.precioUnitarioCompra;
	 }
}
