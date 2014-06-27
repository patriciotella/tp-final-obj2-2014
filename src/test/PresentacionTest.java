package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Presentacion;
import productos.Producto;
import productos.Ubicacion;

public class PresentacionTest {

	Presentacion unaPresentacion;
	Producto unProducto;
	Ubicacion unaUbicacion;
	Ubicacion otraUbicacion;
	List<Float> unaListaDePrecios;
	
	@Before
	public void setUp(){
	
	unaListaDePrecios = new ArrayList<Float>();
	unProducto= Mockito.mock(Producto.class);
	unaUbicacion = Mockito.mock(Ubicacion.class);
	otraUbicacion = Mockito.mock(Ubicacion.class);
	unaPresentacion= new Presentacion("unCodigo",10,5,15f,25f,unaListaDePrecios,unProducto,unaUbicacion,"kg");
	Mockito.when(unProducto.getNombre()).thenReturn("Yerba");
	Mockito.when(unProducto.getMarca()).thenReturn("Taragüi");
	Mockito.when(unProducto.getDescripcion()).thenReturn("unaDescripcion");
	Mockito.when(unProducto.getTipo()).thenReturn("unTipo");
	}
	
	 @Test
	 public void getCodigoDeBarraTest(){
		 assertEquals(unaPresentacion.getCodigoDeBarra(),"unCodigo");
	 }
	 
	 @Test
	 public void getStockMinimoTest(){
		 assertEquals(unaPresentacion.getStockMinimo(),10);
	 }
	 
	 @Test
	 public void getStockCriticoTest(){
		 assertEquals(unaPresentacion.getStockCritico(),5);
	 }
	 
	 @Test
	 public void getPrecioUnitarioCompraTest(){
		 assertEquals(unaPresentacion.getPrecioUnitarioCompra(),15f,0f);
	 }
	 
	 @Test
	 public void getPrecioUnitarioVentaTest(){
		 assertEquals(unaPresentacion.getPrecioUnitarioVenta(),25f,0f);
	 }
	 
	 @Test
	 public void getListaDePreciosTest(){
		 assertTrue(unaPresentacion.getListaDePrecios().isEmpty());
	 }
	 
	 @Test
	 public void getNombreTest(){
		 assertEquals(unaPresentacion.getNombre(),"Yerba");
	 }
	 
	 @Test
	 public void getMarcaTest(){
		 assertEquals(unaPresentacion.getMarca(),"Taragüi");
	 }
	 
	@Test 
	public void getDescripcionTest(){
		 assertEquals(unaPresentacion.getDescripcion(),"unaDescripcion");
	 }
	 
	 @Test
	 public void getTipoTest(){
		 assertEquals(unaPresentacion.getTipo(),"unTipo");
	 }
	 
	 @Test
	 public void getUbicacionTest(){
		 assertEquals(unaPresentacion.getUbicacion(),unaUbicacion);
	 }
	 
	 @Test
	 public void getUnidadDeMedidaTest(){
		 assertEquals(unaPresentacion.getUnidadDeMedida(),"kg");
	 }
	 
	 @Test
	 public void setStockMinimoTest(){
		 unaPresentacion.setStockMinimo(1);
		 assertEquals(unaPresentacion.getStockMinimo(),1);
	 }
	 
	@Test
	 public void setStockCriticoTest(){
		 unaPresentacion.setStockCritico(1);
		 assertEquals(unaPresentacion.getStockCritico(),1);
	 }
	 
	 @Test
	 public void setPrecioUnitarioCompraTest(){
		 unaPresentacion.setPrecioUnitarioCompra(0f);
		 assertEquals(unaPresentacion.getPrecioUnitarioCompra(),0f,0f);
	 }
	 
	 @Test
	 public void setPrecioUnitarioVentaTest(){
		 unaPresentacion.setPrecioUnitarioVenta(0f);
		 assertEquals(unaPresentacion.getPrecioUnitarioVenta(),0f,0f);
	 }
	 
	 @Test
	 public void setUbicacionTest() {
		 unaPresentacion.setUbicacion(otraUbicacion);
		 assertEquals(unaPresentacion.getUbicacion(),otraUbicacion);
	 }

	 @Test
	 public void getPrecioTest() {
		 assertEquals(unaPresentacion.getPrecio(),25f,0f);
	 }

	 @Test
	 public void getPrecioCompraTest() {
		 assertEquals(unaPresentacion.getPrecioCompra(),15f,0f);
	 }
}
