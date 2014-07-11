package sistemaTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Oferta;
import sistema.SistemaVentas;
import sistema.Tienda;
import ventas.Venta;

public class SistemaDeVentasTest {

	SistemaVentas sistema;
	List<Oferta> ofertas;
	List<Tienda> sucursales;
	Oferta oferta1, oferta2, oferta3;
	Tienda tienda1, tienda2, tienda3;
	
	@Before
	public void setUp() {
		
		oferta1 = Mockito.mock(Oferta.class);
		oferta2 = Mockito.mock(Oferta.class);
		oferta3 = Mockito.mock(Oferta.class);
		ofertas = new LinkedList<Oferta>();
		ofertas.add(oferta1);
		ofertas.add(oferta2);
		
		tienda1 = Mockito.mock(Tienda.class); 
		tienda2 = Mockito.mock(Tienda.class); 
		tienda3 = Mockito.mock(Tienda.class);
		sucursales = new LinkedList<Tienda>();
		sucursales.add(tienda1);
		sucursales.add(tienda2);
		
		sistema = new SistemaVentas(sucursales, ofertas);
	}

	@Test
	public void testAgregarOferta() {
		sistema.agregarOferta(oferta3);
		assertTrue(sistema.getOfertas().contains(oferta3));
	}
	
	@Test
	public void testGetOfertas() {
		assertEquals(sistema.getOfertas(), ofertas);
	}
	
	@Test
	public void testGetVentas() {
		Venta venta1 = Mockito.mock(Venta.class);	
		Venta venta2 = Mockito.mock(Venta.class);
		List<Venta> ventas = new LinkedList<Venta>();
		ventas.add(venta1);
		ventas.add(venta2);
		Mockito.when(tienda1.getVentasRealizadas()).thenReturn(ventas);
		Mockito.when(tienda2.getVentasRealizadas()).thenReturn(ventas);
		
		assertTrue(sistema.getVentas().contains(venta1));
		assertTrue(sistema.getVentas().contains(venta2));
	}


}
