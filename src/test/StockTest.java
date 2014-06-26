package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Presentacion;
import productos.Stock;

public class StockTest {

	Stock unStock;
	Presentacion unaPresentacion;
	
	@Before
	public void setUp() {
		unaPresentacion = Mockito.mock(Presentacion.class);
		unStock = new Stock(5, unaPresentacion);
	}

	@Test
	public void testGetCantidad() {
		assertEquals(unStock.getCantidad(), 5);
	}
	
	@Test
	public void testSetCantidad() {
		unStock.setCantidad(20);
		assertEquals(unStock.getCantidad(), 20);
	}
	
	@Test
	public void testSumarCantidad() {
		unStock.sumarCantidad(50);
		assertEquals(unStock.getCantidad(), 55);
	}
	
	@Test
	public void testRestasCantidad() {
		unStock.restarCantidad(4);
		assertEquals(unStock.getCantidad(), 1);
	}
	
	@Test
	public void testEsStockMinimo() {
		Mockito.when(unaPresentacion.getStockMinimo()).thenReturn(5);
		assertTrue(unStock.esStockMinimo());
		Mockito.verify(unaPresentacion).getStockMinimo();
	}
	
	@Test
	public void testEsStockCritico() {
		Mockito.when(unaPresentacion.getStockCritico()).thenReturn(1);
		unStock.restarCantidad(4);
		assertTrue(unStock.esStockCritico());
		Mockito.verify(unaPresentacion).getStockCritico();
	}

	@Test
	public void testGetPresentacion() {
		assertEquals(unStock.getPresentacion(), unaPresentacion);
	}
	
	@Test
	public void testEsStockDePresentacion() {
		assertTrue(unStock.esStockDePresentacion(unaPresentacion));
	}
}
