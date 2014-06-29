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
	
	@Before
	public void setUp() {
		unaEntrega = Mockito.mock(EntregaADomicilio.class);
		ventaEnProcesoQueDebeAbonar = new EnProceso(unaEntrega, 25.5f);
		ventaEnProcesoQueNoDebeAbonar = new EnProceso(unaEntrega, 0f);
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
		assertEquals(ventaEnProcesoQueDebeAbonar.cantidadQueDebeAbonar(), 25.5d, 0d);
		assertEquals(ventaEnProcesoQueNoDebeAbonar.cantidadQueDebeAbonar(), 0d, 0d);
	}
	

}
