package productosTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Articulo;
import productos.ArticuloSinStockException;
import productos.PaqueteDeOferta;
import productos.Presentacion;
import productos.PresentacionEnOferta;

public class PaqueteDeOfertaTest {

	PaqueteDeOferta unPaquete;
	Presentacion caramelo;
	PresentacionEnOferta chicle;
	PresentacionEnOferta tetra;
	List<Articulo> articulos;
	
	@Before
	public void setUp() {
		caramelo = Mockito.mock(Presentacion.class);
		chicle = Mockito.mock(PresentacionEnOferta.class);
		tetra = Mockito.mock(PresentacionEnOferta.class);
		articulos = new LinkedList<Articulo>();
		articulos.add(caramelo);
		articulos.add(chicle);
		articulos.add(tetra);
		unPaquete = new PaqueteDeOferta(articulos, 1.1f);
	}

	@Test
	public void testGetPrecio() {
		Mockito.when(caramelo.getPrecio()).thenReturn(2f);
		Mockito.when(chicle.getPrecio()).thenReturn(3f);
		Mockito.when(tetra.getPrecio()).thenReturn(5f);
		assertEquals(unPaquete.getPrecio(), 9f, 0.1f);
		Mockito.verify(caramelo).getPrecio();
		Mockito.verify(chicle).getPrecio();
		Mockito.verify(tetra).getPrecio();
	}

	@Test
	public void testGetDescuento() {
		assertEquals(unPaquete.getDescuento(), 1.1f, 0f);
	}
	
	@Test
	public void testSetDescuento() {
		unPaquete.setDescuento(2f);
		assertEquals(unPaquete.getDescuento(), 2f, 0f);
	}
	
	@Test
	public void testGetOfertas() {
		assertEquals(unPaquete.getOfertas(), articulos);
	}
	
	@Test
	public void testAgregarOferta() {
		PresentacionEnOferta pizza = Mockito.mock(PresentacionEnOferta.class);
		unPaquete.agregarOferta(pizza);
		assertTrue(unPaquete.getOfertas().contains(pizza));
	}
	
	@Test
	public void testGetPrecioCompra(){
		Mockito.when(caramelo.getPrecioDeCompra()).thenReturn(2f);
		Mockito.when(chicle.getPrecioDeCompra()).thenReturn(3f);
		Mockito.when(tetra.getPrecioDeCompra()).thenReturn(5f);
		assertEquals(unPaquete.getPrecioDeCompra(), 10f, 0f);
		Mockito.verify(caramelo).getPrecioDeCompra();
		Mockito.verify(chicle).getPrecioDeCompra();
		Mockito.verify(tetra).getPrecioDeCompra();
	}
	
	@Test
	public void testDescontarStockDeVenta() throws ArticuloSinStockException {
		unPaquete.descontarStockDeVenta(2);
		Mockito.verify(caramelo).descontarStockDeVenta(2);
		Mockito.verify(chicle).descontarStockDeVenta(2);
		Mockito.verify(tetra).descontarStockDeVenta(2);
	}
	
	@Test
	public void testCancelarCompraDeArticulos() {
		unPaquete.cancelarCompraDeArticulo();
		Mockito.verify(caramelo).cancelarCompraDeArticulo();
		Mockito.verify(chicle).cancelarCompraDeArticulo();
		Mockito.verify(tetra).cancelarCompraDeArticulo();
	}
	
	@Test
	public void testGetGanancia() {
		Mockito.when(caramelo.getGanancia()).thenReturn(0.2f);
		Mockito.when(chicle.getGanancia()).thenReturn(0.5f);
		Mockito.when(tetra.getGanancia()).thenReturn(10f);
		assertEquals(unPaquete.getGanancia(), 10.7f, 0f);
		Mockito.verify(caramelo).getGanancia();
		Mockito.verify(chicle).getGanancia();
		Mockito.verify(tetra).getGanancia();
	}
}
