package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Articulo;
import productos.ArticuloSinStockException;
import productos.Presentacion;
import productos.PresentacionEnOferta;
import sistema.Cliente;
import sistema.CuentaCorriente;
import sistema.NoTieneSaldoSuficienteParaRealizarOperacionException;
import ventas.VentaConCtaCte;

public class VentaConCtaCteTest {

	Cliente cliente;
	LocalDate fecha;
	Articulo auricular;
	Articulo controlRemoto;
	VentaConCtaCte venta;
	List<Articulo> articulos;
	CuentaCorriente cuentaDelCliente;

	@Before
	public void setUp() {
		cliente = Mockito.mock(Cliente.class);
		auricular = Mockito.mock(Presentacion.class);
		controlRemoto = Mockito.mock(PresentacionEnOferta.class);
		articulos = new LinkedList<Articulo>();
		articulos.add(auricular);
		articulos.add(controlRemoto);
		fecha = new LocalDate(2020, 05, 05);
		cuentaDelCliente = Mockito.mock(CuentaCorriente.class);
		Mockito.when(cliente.getCuentaCorriente()).thenReturn(cuentaDelCliente);
	}

	@Test
	public void testPuedeRealizarseLaVenta()
			throws NoTieneSaldoSuficienteParaRealizarOperacionException,
			ArticuloSinStockException {
		Mockito.when(auricular.getPrecio()).thenReturn(20f);
		Mockito.when(controlRemoto.getPrecio()).thenReturn(25f);
		venta = new VentaConCtaCte(articulos, cliente, fecha);
		Mockito.verify(cuentaDelCliente).descontarSaldo(45f);
		Mockito.verify(auricular).descontarStockDeVenta(1);
		Mockito.verify(controlRemoto).descontarStockDeVenta(1);
	}
	
	@Test(expected = NoTieneSaldoSuficienteParaRealizarOperacionException.class)
	public void testNoTieneSaldoParaRealizarLaCompra()
			throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		Mockito.when(auricular.getPrecio()).thenReturn(20f);
		Mockito.when(controlRemoto.getPrecio()).thenReturn(25f);
		Mockito.doThrow(
				NoTieneSaldoSuficienteParaRealizarOperacionException.class)
				.when(cuentaDelCliente).descontarSaldo(45f);
		venta = new VentaConCtaCte(articulos, cliente, fecha);
		Mockito.verify(auricular).cancelarCompraDeArticulo();
		Mockito.verify(controlRemoto).cancelarCompraDeArticulo();
	}
	
	@Test
	public void testGetGanancia() throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		Mockito.when(auricular.getGanancia()).thenReturn(5f);
		Mockito.when(controlRemoto.getGanancia()).thenReturn(6.5f);
		Mockito.when(cliente.getCuentaCorriente()).thenReturn(cuentaDelCliente);
		venta = new VentaConCtaCte(articulos, cliente, fecha);
		assertEquals(venta.getGanancia(), 11.5f, 0f);
	}
	
	@Test
	public void testGetCliente() throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		venta = new VentaConCtaCte(articulos, cliente, fecha);
		assertEquals(venta.getCliente(), cliente);
	}
	
	@Test
	public void testGetFecha() throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		venta = new VentaConCtaCte(articulos, cliente, fecha);
		assertEquals(venta.getFecha(), fecha);
	}
	
	@Test
	public void testGetDetalle() throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		venta = new VentaConCtaCte(articulos, cliente, fecha);
		assertEquals(venta.getDetalle(), articulos);
	}
	
	@Test
	public void testFueCompradoPor() throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		venta = new VentaConCtaCte(articulos, cliente, fecha);
		assertTrue(venta.fueCompradaPor(cliente));
	}
	
	@Test
	public void testIncluyeArticulo() throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		venta = new VentaConCtaCte(articulos, cliente, fecha);
		assertTrue(venta.incluyeArticulo(auricular));
		assertTrue(venta.incluyeArticulo(controlRemoto));
	}
	
	@Test
	public void testCancelarCompraDeArticulos() throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		venta = new VentaConCtaCte(articulos, cliente, fecha);
		venta.cancelarCompraDeArticulos();
		Mockito.verify(auricular).cancelarCompraDeArticulo();
		Mockito.verify(controlRemoto).cancelarCompraDeArticulo();
	}

}
