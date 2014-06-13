package productos;

import java.util.List;

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
	 
	 public String getCodigoDeBarra(){
		 return this.codigoBarras;
	 }
	 public int getStockMinimo(){
		 return this.stockMinimo;
	 }
	 public int getStockCritico(){
		 return this.stockCritico;
	 }
	 public float getPrecioUnitarioCompra(){
		 return this.precioUnitarioCompra;
	 }
	 public float getPrecioUnitarioVenta(){
		 return this.precioUnitarioVenta;
	 }
	 public List<Float> getListaDePrecios(){
		 return this.listaPrecios;
	 }
	 
	 public String getNombre(){
		 return this.producto.getNombre();
	 }
	 public String getMarca(){
		 return this.producto.getMarca();
	 }
	 public List<Presentacion> getPresentaciones(){
		 return this.producto.getPresentaciones();
	 }
	 public String getDescripcion(){
		 return this.producto.getDescripcion();
	 }
	 public String getTipo(){
		 return this.producto.getTipo();
	 }
	 public Ubicacion getUbicacion(){
		 return this.ubicacion;
	 }
	 public String getUnidadDeMedida(){
		 return this.unidadeDeMedida;
	 }
	 
	 public void setStockMinimo(int s){
		 this.stockMinimo=s;
	 }
	 public void setStockCritico(int s){
		 this.stockCritico=s;
	 }
	 public void setPrecioUnitarioCompra(float p){
		 this.precioUnitarioCompra=p;
	 }
	 public void setPrecioUnitarioVenta(float p){
		 this.precioUnitarioVenta=p;
	 }
	@Override
	public Double getPrecio() {
		return (double)this.precioUnitarioVenta;
	}
}
