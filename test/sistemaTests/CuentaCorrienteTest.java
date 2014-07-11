package sistemaTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistema.CuentaCorriente;
import sistema.NoTieneSaldoSuficienteParaRealizarOperacionException;

public class CuentaCorrienteTest {

	CuentaCorriente unaCuentaCorriente;

	@Before
	public void setUp() {
		unaCuentaCorriente = new CuentaCorriente();
	}

	@Test
	public void testUnaNuevaCuentaCorrienteTieneSaldoCero() {
		assertEquals(unaCuentaCorriente.getSaldo(), 0f, 0f);
	}

	@Test
	public void testSetSalgo() {
		unaCuentaCorriente.setSaldo(25f);
		assertEquals(unaCuentaCorriente.getSaldo(), 25f, 0f);
	}

	@Test
	public void testDepositarSaldo() {
		unaCuentaCorriente.depositarSaldo(500f);
		assertEquals(unaCuentaCorriente.getSaldo(), 500f, 0f);
		unaCuentaCorriente.depositarSaldo(600.5f);
		assertEquals(unaCuentaCorriente.getSaldo(), 1100.5f, 0f);
	}

	@Test
	public void testDescontarSaldo()
			throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		unaCuentaCorriente.depositarSaldo(500f);
		unaCuentaCorriente.descontarSaldo(200.5f);
		assertEquals(unaCuentaCorriente.getSaldo(), 299.5f, 0f);
	}

	@Test(expected = NoTieneSaldoSuficienteParaRealizarOperacionException.class) 
	public void testDescontarSaldoLevantaException()
			throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		unaCuentaCorriente.descontarSaldo(200f);
	}
	
	@Test
	public void testGetMoviemientos() {
		assertEquals(unaCuentaCorriente.getMovimientos().size(), 0);
	}
}
