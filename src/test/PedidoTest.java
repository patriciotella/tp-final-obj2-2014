package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import productos.Presentacion;
import productos.Stock;
import sistema.Cliente;
import sistema.PresentacionNotFoundException;
import sistema.Tienda;
import ventas.Pedido;

public class PedidoTest {

	Tienda tienda;
	LocalDate fecha;
	Cliente cliente;
	Stock stockDeCaramelos;
	Stock stockDeEnchufes;
	Presentacion caramelo;
	Presentacion enchufe;
	Pedido pedido;
	List<Stock> stocks;

	@Before
	public void setUp() throws PresentacionNotFoundException {
		tienda = Mockito.mock(Tienda.class);
		fecha = new LocalDate(2014, 01, 01);
		cliente = Mockito.mock(Cliente.class);
		stockDeCaramelos = Mockito.mock(Stock.class);
		stockDeEnchufes = Mockito.mock(Stock.class);
		stocks = new LinkedList<Stock>();
		caramelo = Mockito.mock(Presentacion.class);
		enchufe = Mockito.mock(Presentacion.class);
		stocks.add(stockDeCaramelos);
		stocks.add(stockDeEnchufes);
		Mockito.when(stockDeCaramelos.getPresentacion()).thenReturn(caramelo);
		Mockito.when(stockDeEnchufes.getPresentacion()).thenReturn(enchufe);
		Mockito.when(stockDeCaramelos.getCantidad()).thenReturn(20);
		Mockito.when(stockDeEnchufes.getCantidad()).thenReturn(10);
		Mockito.when(tienda.buscarStockDePresentacion(caramelo)).thenReturn(
				stockDeCaramelos);
		Mockito.when(tienda.buscarStockDePresentacion(enchufe)).thenReturn(
				stockDeEnchufes);
	}

	@Test
	public void testVerificarDisponibilidadDeStock()
			throws PresentacionNotFoundException {
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(caramelo, 20))
				.thenReturn(true);
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(enchufe, 10))
				.thenReturn(false);
		pedido = new Pedido(tienda, stocks, cliente, fecha);
		Mockito.verify(tienda).buscarStockDePresentacion(caramelo);
		Mockito.verify(stockDeCaramelos, Mockito.times(2)).getPresentacion();
		Mockito.verify(stockDeCaramelos, Mockito.times(2)).getCantidad();
		Mockito.verify(stockDeCaramelos).descontarVentaDeArticulo(20);
		Mockito.verify(stockDeEnchufes, Mockito.times(2)).getPresentacion();
		Mockito.verify(stockDeEnchufes).addObserver(pedido);
		Mockito.verifyZeroInteractions(cliente);
	}

	@Test
	public void testPuedeNotificarAlClienteAlMomentoDeCrearElPedido()
			throws PresentacionNotFoundException {
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(caramelo, 20))
				.thenReturn(true);
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(enchufe, 10))
				.thenReturn(true);
		pedido = new Pedido(tienda, stocks, cliente, fecha);
		Mockito.verify(tienda).buscarStockDePresentacion(caramelo);
		Mockito.verify(stockDeCaramelos, Mockito.times(2)).getPresentacion();
		Mockito.verify(stockDeCaramelos, Mockito.times(2)).getCantidad();
		Mockito.verify(stockDeEnchufes, Mockito.times(2)).getPresentacion();
		Mockito.verify(stockDeEnchufes, Mockito.times(2)).getCantidad();
		Mockito.verify(stockDeCaramelos).descontarVentaDeArticulo(20);
		Mockito.verify(stockDeEnchufes).descontarVentaDeArticulo(10);
		Mockito.verify(cliente).update(pedido, "Ya puede retirar su pedido");
	}

	@Test
	public void testNotificarAlClienteSiDebe()
			throws PresentacionNotFoundException {
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(caramelo, 20))
				.thenReturn(true);
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(enchufe, 10))
				.thenReturn(false);
		pedido = new Pedido(tienda, stocks, cliente, fecha);
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(enchufe, 10))
				.thenReturn(true);
		pedido.update(stockDeEnchufes, null);
		Mockito.verify(tienda).hayStockSuficienteParaRealizarVentaDe(caramelo,
				20);
		Mockito.verify(tienda, Mockito.times(2))
				.hayStockSuficienteParaRealizarVentaDe(enchufe, 10);
		Mockito.verify(tienda, Mockito.times(2)).buscarStockDePresentacion(
				enchufe);
		Mockito.verify(stockDeEnchufes).descontarVentaDeArticulo(10);
		Mockito.verify(stockDeEnchufes, Mockito.times(3)).getCantidad();
		Mockito.verify(stockDeEnchufes, Mockito.times(4)).getPresentacion();
	}

	@Test
	public void testNoDebeNotificarAlCliente()
			throws PresentacionNotFoundException {
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(caramelo, 20))
				.thenReturn(true);
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(enchufe, 10))
				.thenReturn(false);
		pedido = new Pedido(tienda, stocks, cliente, fecha);
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(enchufe, 10))
				.thenReturn(false);
		pedido.update(stockDeEnchufes, null);
		Mockito.verify(tienda).hayStockSuficienteParaRealizarVentaDe(caramelo,
				20);
		Mockito.verify(tienda, Mockito.times(2))
				.hayStockSuficienteParaRealizarVentaDe(enchufe, 10);
		Mockito.verify(stockDeEnchufes, Mockito.times(2)).getCantidad();
		Mockito.verify(stockDeEnchufes, Mockito.times(3)).getPresentacion();
		Mockito.verify(stockDeEnchufes).addObserver(pedido);
		Mockito.verifyZeroInteractions(cliente);
	}

	@Test
	public void testNotificarAlClienteSiDebeCatch()
			throws PresentacionNotFoundException {
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(caramelo, 20))
				.thenReturn(true);
		Mockito.when(tienda.hayStockSuficienteParaRealizarVentaDe(enchufe, 10))
				.thenReturn(false);
		pedido = new Pedido(tienda, stocks, cliente, fecha);
		Mockito.doThrow(PresentacionNotFoundException.class).when(tienda)
				.hayStockSuficienteParaRealizarVentaDe(enchufe, 10);
		pedido.update(stockDeEnchufes, null);
	}

	@Test
	public void testGetFecha() throws PresentacionNotFoundException {
		pedido = new Pedido(tienda, stocks, cliente, fecha);
		assertEquals(pedido.getFecha(), fecha);
	}

}
