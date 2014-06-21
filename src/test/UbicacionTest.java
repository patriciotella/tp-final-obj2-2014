package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Ubicacion;
import sistema.Tienda;

public class UbicacionTest {

	Ubicacion ubicacion;
	Ubicacion otraUbicacion;
	Tienda tienda;
	
	private void configurarMockUbicacion(Ubicacion unaUbicacion, int unPasillo, int unEstante, Tienda unaTienda) {
		Mockito.when(unaUbicacion.getEstante()).thenReturn(unEstante);
		Mockito.when(unaUbicacion.getPasillo()).thenReturn(unPasillo);
		Mockito.when(unaUbicacion.getTienda()).thenReturn(unaTienda);
	}
	@Before
	public void setUp() {
		ubicacion = Mockito.mock(Ubicacion.class);
		tienda = Mockito.mock(Tienda.class);
		otraUbicacion = new Ubicacion(null, 0, 0);
	}

	@Test
	public void testGetPasillo() {
		configurarMockUbicacion(ubicacion, 5, 3, tienda);
		assertEquals(ubicacion.getPasillo(), 5);
	}
	
	@Test
	public void testGetEstante() {
		configurarMockUbicacion(ubicacion, 5, 3, tienda);
		assertEquals(ubicacion.getEstante(), 3);
	}
	
	@Test
	public void testGetTienda() {
		configurarMockUbicacion(ubicacion, 5, 3, tienda);
		assertEquals(ubicacion.getTienda(), tienda);
	}
	
	@Test
	public void testSetPasillo() {
		otraUbicacion.setPasillo(5);
		assertEquals(otraUbicacion.getPasillo(), 5);
	}
	
	@Test
	public void testSetEstante() {
		otraUbicacion.setEstante(1);
		assertEquals(otraUbicacion.getEstante(), 1);
	}
	
	@Test
	public void testSetTienda() {
		otraUbicacion.setTienda(tienda);
		assertEquals(otraUbicacion.getTienda(), tienda);
	}
}
