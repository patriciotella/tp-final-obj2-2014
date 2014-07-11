package ventasTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Articulo;
import productos.ArticuloSinStockException;
import sistema.Cliente;
import ventas.VentaDirecta;

public class VentaDirectaTest {

	VentaDirecta unaVentaDirecta;
	Cliente unCliente;
	Articulo articulo1;
	Articulo articulo2;
	Articulo articulo3;
	List<Articulo> articulos;

	@Before
	public void setUp() {
		unCliente = Mockito.mock(Cliente.class);
		articulo1 = Mockito.mock(Articulo.class);
		articulo2 = Mockito.mock(Articulo.class);
		articulo3 = Mockito.mock(Articulo.class);
		articulos = new LinkedList<Articulo>();
		articulos.add(articulo1);
		articulos.add(articulo2);
		articulos.add(articulo3);
		unaVentaDirecta = new VentaDirecta(articulos, unCliente, null);
	}

	@Test
	public void testGetMonto() {
		Mockito.when(articulo1.getPrecio()).thenReturn(20f);
		Mockito.when(articulo2.getPrecio()).thenReturn(15f);
		Mockito.when(articulo3.getPrecio()).thenReturn(6f);
		assertEquals(unaVentaDirecta.getMonto(), 41f, 0f);
		Mockito.verify(articulo1).getPrecio();
		Mockito.verify(articulo2).getPrecio();
		Mockito.verify(articulo3).getPrecio();
	}

	@Test
	public void testGetCliente() {
		assertEquals(unaVentaDirecta.getCliente(), unCliente);
	}

	@Test
	public void testGetDetalle() {
		assertEquals(unaVentaDirecta.getDetalle(), articulos);
	}

	@Test
	public void testCancelarCompraDeArticulo() {
		unaVentaDirecta.cancelarCompraDeArticulo(articulo1);
		Mockito.verify(articulo1).cancelarCompraDeArticulo();
	}

	@Test
	public void testAgregarArticuloALaCompra() throws ArticuloSinStockException {
		unaVentaDirecta.agregarArticuloALaCompra(articulo2);
		Mockito.verify(articulo2, Mockito.times(2)).descontarStockDeVenta(1);
	}

	@Test
	public void testAgregarArticuloSinStockALaVenta()
			throws ArticuloSinStockException {
		Mockito.doThrow(ArticuloSinStockException.class).when(articulo3)
				.descontarStockDeVenta(1);
		unaVentaDirecta.agregarArticuloALaCompra(articulo3);
	}

}
