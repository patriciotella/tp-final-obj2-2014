package filtrosTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Stock;
import filtros.PorStockCritico;

public class PorStockCriticoTest {
	PorStockCritico criterioFiltro;
	Stock stock;
	
	@Before
	public void setUp() {
		stock = Mockito.mock(Stock.class);
		criterioFiltro = new PorStockCritico();
	}

	@Test
	public void testCumpleCriterioDeFiltro() {

		Mockito.when(stock.esStockCritico()).thenReturn(true);
		assertTrue(criterioFiltro.cumpleCriterioDeFiltro(stock));
		Mockito.verify(stock, Mockito.times(1)).esStockCritico();
	}
	
	@Test
	public void testNoCumpleCriterioDeFiltro() {

		Mockito.when(stock.esStockCritico()).thenReturn(false);
		assertFalse(criterioFiltro.cumpleCriterioDeFiltro(stock));
		Mockito.verify(stock, Mockito.times(1)).esStockCritico();
	}

}
