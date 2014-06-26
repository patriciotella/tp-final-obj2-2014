package test;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ventas.EnProceso;

public class EnProcesoTest {

	EnProceso ventaEnProcesoQueDebeAbonar;
	EnProceso ventaEnProcesoQueNoDebeAbonar;
	
	@Before
	public void setUp() {
		ventaEnProcesoQueDebeAbonar = new EnProceso(25.5d);
		ventaEnProcesoQueNoDebeAbonar = new EnProceso(0d);
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
