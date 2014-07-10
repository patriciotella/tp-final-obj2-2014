package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.ArticuloSinStockException;
import productos.CantidadInvalidaException;
import productos.Presentacion;
import productos.Stock;
import ventas.Pedido;

public class StockTest {

	Stock unStock;
	Presentacion unaPresentacion;
	Pedido pedidoObserver;
	Presentacion otraPresentacion;

	@Before
	public void setUp() {
		otraPresentacion = Mockito.mock(Presentacion.class);
		unaPresentacion = Mockito.mock(Presentacion.class);
		pedidoObserver = Mockito.mock(Pedido.class);
		unStock = new Stock(5, unaPresentacion);
		unStock.addObserver(pedidoObserver);
	}

	@Test
	public void testGetCantidad() {
		assertEquals(unStock.getCantidad(), 5);
	}

	@Test
	public void testSetCantidad() throws CantidadInvalidaException {
		unStock.setCantidad(20);
		assertEquals(unStock.getCantidad(), 20);
		Mockito.verify(pedidoObserver).update(unStock, null);
	}

	@Test(expected = CantidadInvalidaException.class)
	public void testSetCantidadNegativaThrowsException()
			throws CantidadInvalidaException {
		unStock.setCantidad(-1);
	}

	@Test
	public void testSumarCantidad() {
		unStock.sumarCantidad(50);
		assertEquals(unStock.getCantidad(), 55);
		Mockito.verify(pedidoObserver).update(unStock, null);
	}

	@Test
	public void testRestasCantidad() throws ArticuloSinStockException {
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
	public void testEsStockMinimoFalse() {
		Mockito.when(unaPresentacion.getStockMinimo()).thenReturn(3);
		assertFalse(unStock.esStockMinimo());
		Mockito.verify(unaPresentacion).getStockMinimo();
	}
	
	@Test
	public void testEsStockCritico() throws ArticuloSinStockException {
		Mockito.when(unaPresentacion.getStockCritico()).thenReturn(1);
		unStock.restarCantidad(4);
		assertTrue(unStock.esStockCritico());
		Mockito.verify(unaPresentacion).getStockCritico();
	}

	@Test
	public void testEsStockCriticoFalse() throws ArticuloSinStockException {
		Mockito.when(unaPresentacion.getStockCritico()).thenReturn(2);
		assertFalse(unStock.esStockCritico());
		Mockito.verify(unaPresentacion).getStockCritico();
	}
	
	@Test
	public void testGetPresentacion() {
		assertEquals(unStock.getPresentacion(), unaPresentacion);
	}
	
	@Test
	public void testGetPresentacionNotEquals() {
		assertNotEquals(unStock.getPresentacion(), otraPresentacion);
	}
	
	@Test
	public void testEsStockDePresentacion() {
		assertTrue(unStock.esStockDePresentacion(unaPresentacion));
	}

	@Test
	public void testEsStockDePresentacionFalse() {
		assertFalse(unStock.esStockDePresentacion(otraPresentacion));
	}
	@Test(expected = ArticuloSinStockException.class)
	public void testRestarCantidadThrowsArticuloSinStockException()
			throws ArticuloSinStockException {
		unStock.restarCantidad(20);
	}
	
	@Test
	public void testHayStockSuficienteParaRealizarVenta() {
		assertTrue(unStock.hayStockSuficienteParaRealizarVenta(5));
	}
	
	@Test
	public void testNoHayStockSuficienteParaRealizarVenta() {
		assertFalse(unStock.hayStockSuficienteParaRealizarVenta(20));
	}
}
