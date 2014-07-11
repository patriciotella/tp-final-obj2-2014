package ventasTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ventas.EntregaADomicilio;
import ventas.EnvioPendienteException;
import ventas.Pendiente;

public class PendienteTest {

	EntregaADomicilio entrega;
	Pendiente estadoPendiente;
	
	@Before
	public void setUp() throws Exception {
		entrega = Mockito.mock(EntregaADomicilio.class);
		estadoPendiente = new Pendiente(entrega);
	}

	@Test(expected = EnvioPendienteException.class)
	public void testReprogramar() throws Exception {
		estadoPendiente.reprogramar();
	}
	
	@Test
	public void testGetGanancia() {
		assertEquals(estadoPendiente.getGananciaDeVenta(), 0f, 0f);
	}
}
