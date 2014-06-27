package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import filtros.EntreMontos;
import ventas.VentaDirecta;

public class EntreMontosTest {

	EntreMontos criterioDeFiltro;
	VentaDirecta unaVentaDirecta;
	
	@Before
	public void setUp() {
		unaVentaDirecta = Mockito.mock(VentaDirecta.class);
		criterioDeFiltro = new EntreMontos(20.5f, 30f);
	}

	@Test
	public void testCumpleCriterioDeFiltro() {
		Mockito.when(unaVentaDirecta.getMonto()).thenReturn(29.3f);
		assertTrue(criterioDeFiltro.cumpleCriterioDeFiltro(unaVentaDirecta));
		Mockito.verify(unaVentaDirecta, Mockito.times(2)).getMonto();
	}

}
