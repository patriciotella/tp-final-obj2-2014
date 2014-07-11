package filtrosTests;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import filtros.EntreFechas;
import ventas.VentaDirecta;

public class EntreFechasTest {

	EntreFechas criterioDeFiltro;
	VentaDirecta unaVenta;

	@Before
	public void setUp() {
		criterioDeFiltro = new EntreFechas(new LocalDate(2014, 06, 15),
				new LocalDate(2015, 07, 05));
		unaVenta = Mockito.mock(VentaDirecta.class);
	}

	@Test
	public void testCumpleCriterioDeFiltro() {
		Mockito.when(unaVenta.getFecha()).thenReturn(
				new LocalDate(2014, 06, 16));
		assertTrue(criterioDeFiltro.cumpleCriterioDeFiltro(unaVenta));
		Mockito.verify(unaVenta, Mockito.times(2)).getFecha();
	}

	@Test
	public void testNoCumpleCriterioDeFiltro() {
		Mockito.when(unaVenta.getFecha()).thenReturn(
				new LocalDate(2015, 07, 20));
		assertFalse(criterioDeFiltro.cumpleCriterioDeFiltro(unaVenta));
		Mockito.verify(unaVenta, Mockito.times(2)).getFecha();
	}

}
