package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import productos.Presentacion;
import productos.Stock;
import sistema.Cliente;
import sistema.Tienda;

public class PedidoTest {

	Tienda tienda;
	org.joda.time.LocalDate fecha;
	Cliente cliente;
	Stock stockDeCaramelos;
	Stock stockDeEnchufes;
	Presentacion caramelo;
	Presentacion enchufe;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
