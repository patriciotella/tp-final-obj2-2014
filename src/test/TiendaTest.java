package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Presentacion;
import productos.Stock;
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
				
		ventas = new LinkedList<Venta>();
		ventas.add(venta3);
		ventas.add(venta2);
		
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
	
	/* ESTE TEST FALLA Y SEGURO ES PORQUE HICE MUCHO LIO CON LOS MOKITOS ASHUDA */
	
	@Test
	public void testGetPresentacionesConStockMinimo() {
		Presentacion presentacion1 = Mockito.mock(Presentacion.class);
		Presentacion presentacion2 = Mockito.mock(Presentacion.class);
		Presentacion presentacion3 = Mockito.mock(Presentacion.class);
		
		Stock stock1 = Mockito.mock(Stock.class);
		Stock stock2 = Mockito.mock(Stock.class);
		Stock stock3 = Mockito.mock(Stock.class);
		
		Mockito.when(presentacion1.getStockMinimo()).thenReturn(23);
		Mockito.when(presentacion2.getStockMinimo()).thenReturn(25);
		Mockito.when(presentacion3.getStockMinimo()).thenReturn(40);
		
		Mockito.when(stock1.getCantidad()).thenReturn(23);
		Mockito.when(stock2.getCantidad()).thenReturn(30);
		Mockito.when(stock3.getCantidad()).thenReturn(40);
		
		Mockito.when(stock1.getPresentacion()).thenReturn(presentacion1);
		Mockito.when(stock2.getPresentacion()).thenReturn(presentacion2);
		Mockito.when(stock3.getPresentacion()).thenReturn(presentacion3);
		
		Mockito.when(stock1.esStockMinimo()).thenReturn(true);
		Mockito.when(stock2.esStockMinimo()).thenReturn(true);
		Mockito.when(stock3.esStockMinimo()).thenReturn(true);
		
		assertTrue(tienda.getPresentacionesConStockMinimo().contains(stock1));
		assertTrue(tienda.getPresentacionesConStockMinimo().contains(stock3));
	}

}
