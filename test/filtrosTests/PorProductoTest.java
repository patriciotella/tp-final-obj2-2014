package filtrosTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import productos.Presentacion;
import filtros.PorProducto;
import ventas.VentaDirecta;

public class PorProductoTest {

	PorProducto criterioPorProducto;
	Presentacion presentacion;
	VentaDirecta ventaDirecta;

	@Test
	public void testCumpleCriterioDeFiltro() {
		presentacion = Mockito.mock(Presentacion.class);
		ventaDirecta = Mockito.mock(VentaDirecta.class);
		criterioPorProducto = new PorProducto(presentacion);

		Mockito.when(ventaDirecta.incluyeArticulo(presentacion)).thenReturn(
				true);
		assertTrue(criterioPorProducto.cumpleCriterioDeFiltro(ventaDirecta));
		Mockito.verify(ventaDirecta, Mockito.times(1)).incluyeArticulo(
				presentacion);
	}
	
	@Test
	public void testNoCumpleCriterioDeFiltro() {
		presentacion = Mockito.mock(Presentacion.class);
		ventaDirecta = Mockito.mock(VentaDirecta.class);
		criterioPorProducto = new PorProducto(presentacion);

		Mockito.when(ventaDirecta.incluyeArticulo(presentacion)).thenReturn(
				false);
		assertFalse(criterioPorProducto.cumpleCriterioDeFiltro(ventaDirecta));
		Mockito.verify(ventaDirecta, Mockito.times(1)).incluyeArticulo(
				presentacion);
	}

}
