package filtrosTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sistema.Cliente;
import ventas.Venta;
import ventas.VentaDirecta;
import filtros.Criterio;
import filtros.VentaRealizadaPorCliente;

public class VentaRealizadaPorClienteTest {

	Cliente unCliente;
	Criterio<Venta> criterioDeFiltro;
	Venta venta;

	@Before
	public void setUp() {
		unCliente = Mockito.mock(Cliente.class);
		criterioDeFiltro = new VentaRealizadaPorCliente(unCliente);
	}

	@Test
	public void testEsUnaVentaRealizadaPorElCliente() {
		venta = Mockito.mock(VentaDirecta.class);
		Mockito.when(venta.fueCompradaPor(unCliente)).thenReturn(true);
		assertTrue(criterioDeFiltro.cumpleCriterioDeFiltro(venta));
	}

	@Test
	public void testNoEsUnaVentaRealizadaPorElCliente() {
		venta = Mockito.mock(VentaDirecta.class);
		Mockito.when(venta.fueCompradaPor(unCliente)).thenReturn(false);
		assertFalse(criterioDeFiltro.cumpleCriterioDeFiltro(venta));
	}

}
