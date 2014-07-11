package ventasTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Articulo;
import productos.Presentacion;
import productos.PresentacionEnOferta;
import sistema.Cliente;
import ventas.EntregaADomicilio;
import ventas.EstadoEnvio;

public class EntregaADomicilioTest {

	EstadoEnvio estadoDeEnvio;
	LocalDate fecha;
	EntregaADomicilio entregaADomicilio;
	Articulo articulo1;
	Articulo articulo2;
	List<Articulo> articulos;
	Cliente cliente;

	@Before
	public void setUp() throws Exception {
		fecha = new LocalDate(2014, 07, 20);
		cliente = Mockito.mock(Cliente.class);
		articulo1 = Mockito.mock(Presentacion.class);
		articulo2 = Mockito.mock(PresentacionEnOferta.class);
		articulos = new LinkedList<Articulo>();
		articulos.add(articulo1);
		articulos.add(articulo2);
		entregaADomicilio = new EntregaADomicilio(articulos, cliente, fecha, 0f);
		estadoDeEnvio = Mockito.spy(entregaADomicilio.getEstadoDeEnvio());
	}

	@Test
	public void testGetMontoQueDebeAbonar() {
		assertEquals(entregaADomicilio.getMontoQueDebeAbonar(), 0f, 0f);
	}

	/*@Test
	public void testGetGanancia() {
		entregaADomicilio.getGanancia();
		Mockito.verify(estadoDeEnvio).getGananciaDeVenta();
	}*/
	
	@Test
	public void testGetFechaDeCreacion() {
		assertEquals(entregaADomicilio.getFechaCreacion(), fecha);
	}

}
