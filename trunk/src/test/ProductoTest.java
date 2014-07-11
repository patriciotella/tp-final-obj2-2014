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
	public void setUp() {
		unaListaDePresentaciones = new ArrayList<Presentacion>();
		unProducto = new Producto("Yerba", "unaDescripcion", "Taragüi",
				"unTipo", unaListaDePresentaciones);
		unaPresentacion = Mockito.mock(Presentacion.class);
	}

	@Test
	public void testGetNombre() {
		assertEquals(unProducto.getNombre(), "Yerba");
	}

	@Test
	public void testGetMarca() {
		assertEquals(unProducto.getMarca(), "Taragüi");
	}

	@Test
	public void testGetPresentaciones() {
		assertTrue(unProducto.getPresentaciones().isEmpty());
	}

	@Test
	public void testGetDescripcion() {
		assertEquals(unProducto.getDescripcion(), "unaDescripcion");
	}

	@Test
	public void testGetTipo() {
		assertEquals(unProducto.getTipo(), "unTipo");
	}

	@Test
	public void testSetNombre() {
		unProducto.setNombre("Fideos");
		assertEquals(unProducto.getNombre(), "Fideos");
	}

	@Test
	public void testSetMarca() {
		unProducto.setMarca("Rosamonte");
		assertEquals(unProducto.getMarca(), "Rosamonte");
	}

	@Test
	public void testAgregarPresentacion() {
		unProducto.agregarPresentacion(unaPresentacion);
		assertEquals(unProducto.getPresentaciones().size(), 1);
	}

	@Test
	public void testConstructorConListaDePresentacionesVacia() {
		Producto azucar = new Producto("Azucar", "Una Descripcion", "Ledesma", "Un tipo");
		assertEquals(azucar.getNombre(), "Azucar");
		assertEquals(azucar.getDescripcion(), "Una Descripcion");
		assertEquals(azucar.getMarca(), "Ledesma");
		assertEquals(azucar.getTipo(), "Un tipo");
		Presentacion azucarLedesma100gr = Mockito.mock(Presentacion.class); 
		azucar.agregarPresentacion(azucarLedesma100gr);
		assertTrue(azucar.getPresentaciones().contains(azucarLedesma100gr));
	}
}
