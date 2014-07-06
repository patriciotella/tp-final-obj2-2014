package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Articulo;
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
	
	public void testGetGananciaDeVenta() {
		List<Articulo> articulos = new LinkedList<Articulo>();
		Articulo articulo1 = Mockito.mock(Articulo.class);
		Articulo articulo2 = Mockito.mock(Articulo.class);
		articulos.add(articulo1);
		articulos.add(articulo2);
		Mockito.when(entrega.getDetalle()).thenReturn(articulos);
		Mockito.when(articulo1.getGanancia()).thenReturn(20.5f);
		Mockito.when(articulo2.getGanancia()).thenReturn(15f);
		assertEquals(envioPago.getGananciaDeVenta(), 35.5f, 0f);
	}

}
