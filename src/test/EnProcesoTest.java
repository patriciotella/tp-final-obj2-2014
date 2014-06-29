package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ventas.EnProceso;
import ventas.EntregaADomicilio;

public class EnProcesoTest {

	EnProceso ventaEnProcesoQueDebeAbonar;
	EnProceso ventaEnProcesoQueNoDebeAbonar;
	EntregaADomicilio unaEntrega;
	EntregaADomicilio entregaPaga;

	@Before
	public void setUp() {
		unaEntrega = Mockito.mock(EntregaADomicilio.class);
		Mockito.when(unaEntrega.getMontoQueDebeAbonar()).thenReturn(25.5f);
		ventaEnProcesoQueDebeAbonar = new EnProceso(unaEntrega);

		entregaPaga = Mockito.mock(EntregaADomicilio.class);
		Mockito.when(unaEntrega.getMontoQueDebeAbonar()).thenReturn(0f);
		ventaEnProcesoQueNoDebeAbonar = new EnProceso(entregaPaga);
	}

	@Test
	public void testDebeAbonarAlgoEnEntrega() {
		assertTrue(ventaEnProcesoQueDebeAbonar.debeAbonarAlgoEnEntrega());
	}

	@Test
	public void testDebeAbonarAlgoEnEntregaFalse() {
		assertFalse(ventaEnProcesoQueNoDebeAbonar.debeAbonarAlgoEnEntrega());
	}

	@Test
	public void testCantidadQueDebeAbonarEnEntrega() {
		assertEquals(ventaEnProcesoQueDebeAbonar.cantidadQueDebeAbonar(),
				25.5f, 0f);
		assertEquals(ventaEnProcesoQueNoDebeAbonar.cantidadQueDebeAbonar(), 0f,
				0f);
	}

}
