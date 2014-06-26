package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Oferta;
import productos.PaqueteDeOferta;
import productos.PresentacionEnOferta;

public class PaqueteDeOfertaTest {

	PaqueteDeOferta unPaquete;
	PresentacionEnOferta caramelo;
	PresentacionEnOferta chicle;
	PresentacionEnOferta tetra;
	List<Oferta> ofertas;
	
	@Before
	public void setUp() {
		caramelo = Mockito.mock(PresentacionEnOferta.class);
		chicle = Mockito.mock(PresentacionEnOferta.class);
		tetra = Mockito.mock(PresentacionEnOferta.class);
		ofertas = new LinkedList<Oferta>();
		ofertas.add(caramelo);
		ofertas.add(chicle);
		ofertas.add(tetra);
		unPaquete = new PaqueteDeOferta(ofertas, 1.1f);
	}

	@Test
	public void testGetPrecio() {
		Mockito.when(caramelo.getPrecio()).thenReturn(2f);
		Mockito.when(chicle.getPrecio()).thenReturn(3f);
		Mockito.when(tetra.getPrecio()).thenReturn(5f);
		assertEquals(unPaquete.getPrecio(), 9f, 0.1f);
		Mockito.verify(caramelo).getPrecio();
		Mockito.verify(chicle).getPrecio();
		Mockito.verify(tetra).getPrecio();
	}

	@Test
	public void testGetDescuento() {
		assertEquals(unPaquete.getDescuento(), 1.1f, 0f);
	}
	
	@Test
	public void testSetDescuento() {
		unPaquete.setDescuento(2f);
		assertEquals(unPaquete.getDescuento(), 2f, 0f);
	}
	
	@Test
	public void testGetOfertas() {
		assertEquals(unPaquete.getOfertas(), ofertas);
	}
	
	@Test
	public void testAgregarOferta() {
		PresentacionEnOferta pizza = Mockito.mock(PresentacionEnOferta.class);
		unPaquete.agregarOferta(pizza);
		assertTrue(unPaquete.getOfertas().contains(pizza));
	}
}
