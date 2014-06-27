package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Presentacion;
import productos.Producto;

public class ProductoTest {

	Producto unProducto;
	List<Presentacion> unaListaDePresentaciones;
	Presentacion unaPresentacion;
	
	@Before
	public void setUp(){
		unaListaDePresentaciones = new ArrayList<Presentacion>();
		unProducto = new Producto("Yerba","unaDescripcion","Taragüi","unTipo",unaListaDePresentaciones);		
		unaPresentacion = Mockito.mock(Presentacion.class);
	}

	@Test
	public void getNombreTest(){
		assertEquals(unProducto.getNombre(),"Yerba");
	}
	
	@Test
	public void getMarcaTest(){
		assertEquals(unProducto.getMarca(),"Taragüi");
	}
	
	@Test
	public void getPresentacionesTest(){
		assertTrue(unProducto.getPresentaciones().isEmpty());
	}
	
	@Test
	public void getDescripcionTest(){
		assertEquals(unProducto.getDescripcion(),"unaDescripcion");
	}
	
	@Test
	public void getTipoTest(){
		assertEquals(unProducto.getTipo(),"unTipo");
	}
	
	@Test
	public void setNombreTest(){
		unProducto.setNombre("Fideos");
		assertEquals(unProducto.getNombre(),"Fideos");
	}
	
	@Test
	public void setMarcaTest(){
		unProducto.setMarca("Rosamonte");
		assertEquals(unProducto.getMarca(),"Rosamonte");
	}
	
	@Test
	public void setPresentacionTest(){
		unProducto.setPresentacion(unaPresentacion);		
		assertEquals(unProducto.getPresentaciones().size(),1);
	}
}
