package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import productos.Stock;
import filtros.PorStockCritico;

public class PorStockCriticoTest {
	PorStockCritico criterioFiltro;
	Stock stock;

	@Test
	public void test() {
		stock = Mockito.mock(Stock.class);
		criterioFiltro = new PorStockCritico();

		Mockito.when(stock.esStockCritico()).thenReturn(true);
		assertTrue(criterioFiltro.cumpleCriterioDeFiltro(stock));
		Mockito.verify(stock, Mockito.times(1)).esStockCritico();
	}

}
