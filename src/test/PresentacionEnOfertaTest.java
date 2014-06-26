package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
	}
	
	@Test
	public void testGetPrecio() {
		Mockito.when(caramelo.getPrecio()).thenReturn(20f);
		assertEquals(carameloBarato.getPrecio(), 18.18f, 0.5f);
		Mockito.verify(caramelo).getPrecio();
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

}
