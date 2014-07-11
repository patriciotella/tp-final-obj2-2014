package sistemaTests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sistema.Cliente;
import sistema.ConfiguracionDeDevolucionDeDinero;
import sistema.CuentaCorriente;
import sistema.DevolucionPorCtaCte;
import ventas.Venta;
import ventas.VentaDirecta;

public class DevolucionPorCtaCteTest {
	
	Cliente cliente;
	Venta venta;
	CuentaCorriente cuentaCorriente;
	ConfiguracionDeDevolucionDeDinero configuracion;

	@Before
	public void setUp() {
		cliente = Mockito.mock(Cliente.class);
		venta = Mockito.mock(VentaDirecta.class);
		cuentaCorriente = Mockito.mock(CuentaCorriente.class);
		configuracion = new DevolucionPorCtaCte();
		Mockito.when(venta.getCliente()).thenReturn(cliente);
		Mockito.when(cliente.getCuentaCorriente()).thenReturn(cuentaCorriente);
	}

	@Test
	public void testDevolverDineroAlCliente() {
		configuracion.devolverDineroACliente(venta, 200f);
		Mockito.verify(venta).getCliente();
		Mockito.verify(cliente).getCuentaCorriente();
		Mockito.verify(cuentaCorriente).depositarSaldo(200f);
	}

}
