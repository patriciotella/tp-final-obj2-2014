package filtrosTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Stock;
import filtros.PorStockMinimo;

public class PorStockMinimoTest {

	PorStockMinimo criterioFiltro;
	Stock stock;
	
	@Before
	public void setUp() {
		stock = Mockito.mock(Stock.class);
		criterioFiltro = new PorStockMinimo();
	}

	@Test
	public void testCumpleCriterioDeFiltro() {
		Mockito.when(stock.esStockMinimo()).thenReturn(true);
		assertTrue(criterioFiltro.cumpleCriterioDeFiltro(stock));
		Mockito.verify(stock, Mockito.times(1)).esStockMinimo();
	}

	@Test
	public void testNoCumpleCriterioDeFiltro() {
		Mockito.when(stock.esStockMinimo()).thenReturn(false);
		assertFalse(criterioFiltro.cumpleCriterioDeFiltro(stock));
		Mockito.verify(stock, Mockito.times(1)).esStockMinimo();
	}

}
