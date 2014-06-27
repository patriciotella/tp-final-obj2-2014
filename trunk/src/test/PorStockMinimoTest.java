package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import productos.Stock;
import filtros.PorStockMinimo;

public class PorStockMinimoTest {

	PorStockMinimo criterioFiltro;
	Stock stock;

	@Test
	public void test() {
		stock = Mockito.mock(Stock.class);
		criterioFiltro = new PorStockMinimo();

		Mockito.when(stock.esStockMinimo()).thenReturn(true);
		assertTrue(criterioFiltro.cumpleCriterioDeFiltro(stock));
		Mockito.verify(stock, Mockito.times(1)).esStockMinimo();
	}

}
