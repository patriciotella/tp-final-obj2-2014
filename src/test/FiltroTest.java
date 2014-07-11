package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Stock;
import sistema.Cliente;
import ventas.Venta;
import ventas.VentaDirecta;
import filtros.Criterio;
import filtros.Filtro;
import filtros.VentaRealizadaPorCliente;

public class FiltroTest {

	Filtro<Venta> filtroDeVentas;
	Criterio<Venta> criterioDeFiltroDeVenta;
	Venta venta;
	Venta venta2;
	Venta venta3;
	List<Venta> ventas;
	
	@Before
	public void setUp() {
		filtroDeVentas = new Filtro<Venta>();
		venta = Mockito.mock(VentaDirecta.class);
		venta2 = Mockito.mock(VentaDirecta.class);
		venta3 = Mockito.mock(VentaDirecta.class);
		ventas = new LinkedList<Venta>();
		ventas.add(venta);
		ventas.add(venta2);
		ventas.add(venta3);
	}

	@Test
	public void test() {
		criterioDeFiltroDeVenta = Mockito.mock(VentaRealizadaPorCliente.class);
		Mockito.when(criterioDeFiltroDeVenta.cumpleCriterioDeFiltro(venta)).thenReturn(true);
		Mockito.when(criterioDeFiltroDeVenta.cumpleCriterioDeFiltro(venta2)).thenReturn(false);
		Mockito.when(criterioDeFiltroDeVenta.cumpleCriterioDeFiltro(venta3)).thenReturn(true);
		List<Venta> ventasFiltradas = filtroDeVentas.filtrar(ventas, criterioDeFiltroDeVenta);
		assertTrue(ventasFiltradas.contains(venta));
		assertTrue(ventasFiltradas.contains(venta3));
	}

}
