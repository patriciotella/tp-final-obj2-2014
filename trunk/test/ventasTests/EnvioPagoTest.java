package ventasTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ventas.EntregaADomicilio;
import ventas.EntregaPagaException;
import ventas.EnvioPago;

public class EnvioPagoTest {

	EntregaADomicilio entrega;
	EnvioPago envioPago;
	
	@Before
	public void setUp() throws Exception {
		entrega = Mockito.mock(EntregaADomicilio.class);
		envioPago = new EnvioPago(entrega);
	}

	@Test(expected = EntregaPagaException.class)
	public void testEnviar() throws EntregaPagaException {
		envioPago.enviar();
	}
	
	@Test(expected = EntregaPagaException.class)
	public void testCancelar() throws EntregaPagaException {
		envioPago.cancelar();
	}
	
	@Test(expected = EntregaPagaException.class)
	public void testReprogramar() throws EntregaPagaException {
		envioPago.reprogramar();
	}
	
	@Test
	public void testGetGananciaDeVenta() {
		Mockito.when(entrega.getGanancia()).thenReturn(35.5f);
		assertEquals(envioPago.getGananciaDeVenta(), 35.5f, 0f);
	}

}
