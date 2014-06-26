package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistema.CuentaCorriente;

public class CuentaCorrienteTest {

	CuentaCorriente unaCuentaCorriente;
	
	@Before
	public void setUp() {
		unaCuentaCorriente = new CuentaCorriente();
	}

	@Test
	public void testUnaNuevaCuentaCorrienteTieneSaldoCero() {
		assertEquals(unaCuentaCorriente.getSaldo(), 0d, 0d);
	}
	
	@Test
	public void testSetSalgo() {
		unaCuentaCorriente.setSaldo(25d);
		assertEquals(unaCuentaCorriente.getSaldo(), 25d, 0d);
	}
	
	@Test
	public void testDepositarSaldo() {
		unaCuentaCorriente.depositarSaldo(500d);
		assertEquals(unaCuentaCorriente.getSaldo(), 500d, 0d);
		unaCuentaCorriente.depositarSaldo(600.5d);
		assertEquals(unaCuentaCorriente.getSaldo(), 1100.5d, 0d);
	}
	
	@Test
	public void testDescontarSaldo() {
		unaCuentaCorriente.depositarSaldo(500d);
		unaCuentaCorriente.descontarSaldo(200.5d);
		assertEquals(unaCuentaCorriente.getSaldo(), 299.5d, 0d);
	}

}
