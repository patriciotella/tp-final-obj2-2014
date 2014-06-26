package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Presentacion;
import productos.Stock;
import productos.Ubicacion;
import sistema.Cliente;
import sistema.PresentacionNotFoundException;
import sistema.Tienda;
import ventas.Venta;

public class TiendaTest {

	Tienda tienda;
	List<Venta> ventas;
	List<Stock> stock;
	Venta venta1, venta2, venta3;
	Stock stock1, stock2, stock3;
	Presentacion presentacion1, presentacion2, presentacion3;

	@Before
	public void setUp() {

		venta1 = Mockito.mock(Venta.class);
		venta2 = Mockito.mock(Venta.class);
		venta3 = Mockito.mock(Venta.class);
		ventas = new LinkedList<Venta>();
		ventas.add(venta3);
		ventas.add(venta2);

		stock1 = Mockito.mock(Stock.class);
		stock2 = Mockito.mock(Stock.class);
		stock3 = Mockito.mock(Stock.class);
		stock = new LinkedList<Stock>();
		stock.add(stock1);
		stock.add(stock2);
		stock.add(stock3);

		tienda = new Tienda(stock, ventas);
	}

	@Test
	public void testRegistrarVenta() {

		tienda.registrarVenta(venta1);
		assertTrue(tienda.getVentasRealizadas().contains(venta1));
	}

	@Test
	public void testGetVentasRealizadas() {

		assertEquals(tienda.getVentasRealizadas(), ventas);
	}

	@Test
	public void testGetStock() {

		assertEquals(tienda.getStock(), stock);
	}

	/*
	 * ESTE TEST FALLA Y SEGURO ES PORQUE HICE MUCHO LIO CON LOS MOKITOS ASHUDA
	 * Tiraba NullPointerException y eso porque no estaban inicializadas las
	 * variables de instancia antes de crear la tienda en el setUp.
	 */

	@Test
	public void testGetPresentacionesConStockMinimo() {

		/*
		 * Presentacion presentacion1 = Mockito.mock(Presentacion.class);
		 * Presentacion presentacion2 = Mockito.mock(Presentacion.class);
		 * Presentacion presentacion3 = Mockito.mock(Presentacion.class);
		 * 
		 * Mockito.when(presentacion1.getStockMinimo()).thenReturn(23);
		 * Mockito.when(presentacion2.getStockMinimo()).thenReturn(25);
		 * Mockito.when(presentacion3.getStockMinimo()).thenReturn(40);
		 * 
		 * Stock stock1= new Stock(23, presentacion1); Stock stock2= new
		 * Stock(30, presentacion2); Stock stock3= new Stock(40, presentacion3);
		 */

		Mockito.when(stock1.esStockMinimo()).thenReturn(true);
		Mockito.when(stock2.esStockMinimo()).thenReturn(false);
		Mockito.when(stock3.esStockMinimo()).thenReturn(true);
		/*
		 * stock = new LinkedList<Stock>(); stock.add(stock1);
		 * stock.add(stock2); stock.add(stock3);
		 * 
		 * ventas = new LinkedList<Venta>(); ventas.add(venta3);
		 * ventas.add(venta2);
		 * 
		 * tienda = new Tienda(stock, ventas);
		 */

		assertTrue(tienda.getPresentacionesConStockMinimo().contains(stock1));
		assertFalse(tienda.getPresentacionesConStockMinimo().contains(stock2));
		assertTrue(tienda.getPresentacionesConStockMinimo().contains(stock3));
	}

	@Test
	public void testGetPresentacionesConStockCritico() {
		Mockito.when(stock1.esStockCritico()).thenReturn(true);
		Mockito.when(stock2.esStockCritico()).thenReturn(false);
		Mockito.when(stock3.esStockCritico()).thenReturn(true);

		assertTrue(tienda.getPresentacionesConStockCritico().contains(stock1));
		assertFalse(tienda.getPresentacionesConStockCritico().contains(stock2));
		assertTrue(tienda.getPresentacionesConStockCritico().contains(stock3));
	}

	private void configurarMockVenta(Venta unMockDeVenta,
			Cliente unMockDeCliente, boolean fueCompradaPor, Float unMonto) {
		Mockito.when(unMockDeVenta.fueCompradaPor(unMockDeCliente)).thenReturn(
				fueCompradaPor);
		Mockito.when(unMockDeVenta.getMonto()).thenReturn(unMonto);
	}

	@Test
	public void testGetMontoCompradoPor() {
		Cliente unCliente = Mockito.mock(Cliente.class);
		configurarMockVenta(venta2, unCliente, true, 200.50f);
		configurarMockVenta(venta3, unCliente, false, 200f);

		assertEquals(tienda.montoCompradoPor(unCliente), 200.50f, 0f);
	}

	@Test
	public void testUbicarPresentacionEnTienda()
			throws PresentacionNotFoundException {
		presentacion1 = Mockito.mock(Presentacion.class);
		Mockito.when(stock3.esStockDePresentacion(presentacion1)).thenReturn(
				true);
		Mockito.when(stock3.getPresentacion()).thenReturn(presentacion1);
		Ubicacion unaUbicacion = Mockito.mock(Ubicacion.class);
		tienda.ubicarPresentacion(presentacion1, unaUbicacion);
		Mockito.verify(stock1).esStockDePresentacion(presentacion1);
		Mockito.verify(stock2).esStockDePresentacion(presentacion1);
		Mockito.verify(stock3).esStockDePresentacion(presentacion1);
		Mockito.verify(stock3).getPresentacion();
		Mockito.verify(presentacion1).setUbicacion(unaUbicacion);
	}

	@Test
	public void testGetGanancia() {
		Mockito.when(venta2.getGanancia()).thenReturn(50f);
		Mockito.when(venta3.getGanancia()).thenReturn(25.75f);

		assertEquals(tienda.getGanancia(), 75.75f, 0f);
	}
}
