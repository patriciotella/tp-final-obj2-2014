package ventasTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ventas.Cancelado;
import ventas.EntregaADomicilio;
import ventas.EnvioCanceladoException;

public class CanceladoTest {

	Cancelado estadoCancelado;
	EntregaADomicilio mockDeEntrega;
	@Before
	public void setUp() throws Exception {
		mockDeEntrega = Mockito.mock(EntregaADomicilio.class);
		estadoCancelado = new Cancelado(mockDeEntrega);
	}

	@Test
	public void testGetGanancia() {
		assertEquals(estadoCancelado.getGananciaDeVenta(), 0f, 0f);
	}
	
	@Test(expected = EnvioCanceladoException.class)
	public void testEnviar() throws EnvioCanceladoException {
		estadoCancelado.enviar();
	}
	
	@Test(expected = EnvioCanceladoException.class)
	public void testReprogramar() throws EnvioCanceladoException {
		estadoCancelado.reprogramar();
	}

}
