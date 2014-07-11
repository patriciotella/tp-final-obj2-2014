package productosTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.ArticuloSinStockException;
import productos.Presentacion;
import productos.PresentacionEnOferta;

public class PresentacionEnOfertaTest {

	PresentacionEnOferta carameloBarato;
	Presentacion caramelo;
	
	@Before
	public void setUp() {
		caramelo = Mockito.mock(Presentacion.class);
		carameloBarato = new PresentacionEnOferta(caramelo, 1.1f);
	}

	@Test
	public void testGetPresentacion() {
		assertEquals(carameloBarato.getPresentacion(), caramelo);
		Mockito.verifyZeroInteractions(caramelo);
	}
	
	@Test
	public void testGetPrecio() {
		Mockito.when(caramelo.getPrecio()).thenReturn(20f);
		assertEquals(carameloBarato.getPrecio(), 18.18f, 0.5f);
		Mockito.verify(caramelo).getPrecio();
		Mockito.verifyNoMoreInteractions(caramelo);
	}
	
	@Test
	public void testGetDescuento() {
		assertEquals(carameloBarato.getDescuento(), 1.1f, 0f);
	}
	
	@Test
	public void testSetDescuento() {
		carameloBarato.setDescuento(2f);
		assertEquals(carameloBarato.getDescuento(), 2f, 0f);
	}

	@Test
	public void testDescontarStockDeVenta() throws ArticuloSinStockException {
		carameloBarato.descontarStockDeVenta(20);
		Mockito.verify(caramelo).descontarStockDeVenta(20);
	}
	
	@Test(expected = ArticuloSinStockException.class)
	public void testDescontarStockDeVentaCuandoNoTieneStock() throws ArticuloSinStockException {
		Mockito.doThrow(ArticuloSinStockException.class).when(caramelo).descontarStockDeVenta(2);
		carameloBarato.descontarStockDeVenta(2);
		Mockito.verify(caramelo).descontarStockDeVenta(2);
		Mockito.verifyNoMoreInteractions(caramelo);
	}
	
	@Test
	public void testCancelarCompraDeArticulo() {
		carameloBarato.cancelarCompraDeArticulo();
		Mockito.verify(caramelo).cancelarCompraDeArticulo();
	}
	
	@Test
	public void testGetGanancia() {
		Mockito.when(caramelo.getGanancia()).thenReturn(0.5f);
		assertEquals(carameloBarato.getGanancia(), 0.5f, 0f);
		Mockito.verify(caramelo).getGanancia();
	}
}
