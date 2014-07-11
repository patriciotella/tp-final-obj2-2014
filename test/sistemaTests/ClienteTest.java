package sistemaTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sistema.Cliente;
import sistema.CuentaCorriente;
import sistema.SistemaVentas;

public class ClienteTest {

	Cliente unCliente;
	SistemaVentas unSistema;
	CuentaCorriente cuentaDeUnCliente;

	@Before
	public void setUp() {
		unSistema = Mockito.mock(SistemaVentas.class);
		cuentaDeUnCliente = Mockito.mock(CuentaCorriente.class);
		unCliente = new Cliente("Francisco", 20205206, "unaDireccion",
				cuentaDeUnCliente);
	}

	@Test
	public void testGetNombre() {
		assertEquals(unCliente.getNombre(), "Francisco");
	}

	@Test
	public void testGetDNI() {
		assertEquals(unCliente.getDNI(), 20205206);
	}

	@Test
	public void testGetDireccion() {
		assertEquals(unCliente.getDireccion(), "unaDireccion");
	}

	@Test
	public void testGetCuentaCorriente() {
		assertEquals(unCliente.getCuentaCorriente(), cuentaDeUnCliente);
	}
	
	@Test
	public void testSetDireccion() {
		unCliente.setDireccion("nuevaDireccion");
		assertEquals(unCliente.getDireccion(), "nuevaDireccion");
	}

	@Test
	public void testSubscribirseALasOfertasDe() {
		unCliente.subscribirseALasOfertasDe(unSistema);
		Mockito.verify(unSistema).addObserver(unCliente);
		Mockito.verifyNoMoreInteractions(unSistema);
	}

}
