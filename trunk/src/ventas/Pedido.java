package ventas;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.joda.time.LocalDate;

import productos.Stock;
import sistema.Cliente;
import sistema.PresentacionNotFoundException;
import sistema.Tienda;

public class Pedido extends Observable implements Observer {

	private LocalDate fecha;
	private List<Stock> stockDeArticulos;
	private Tienda tienda;
	private List<Stock> stockInsuficienteDeArticulos;

	public Pedido(Tienda unaTienda, List<Stock> unaListaDeStockDeArticulos,
			Cliente unCliente, LocalDate unaFecha)
			throws PresentacionNotFoundException {
		this.fecha = unaFecha;
		addObserver(unCliente);
		this.stockDeArticulos = unaListaDeStockDeArticulos;
		this.stockInsuficienteDeArticulos = new LinkedList<Stock>();
		this.tienda = unaTienda;
		this.verificarDisponibilidadDeStock();
	}

	private void verificarDisponibilidadDeStock()
			throws PresentacionNotFoundException {
		boolean puedeNotificarAlCliente = true;
		Stock stockDePresentacion;
		for (Stock stock : stockDeArticulos) {
			stockDePresentacion = tienda.buscarStockDePresentacion(stock
					.getPresentacion());
			if (!this.tienda.hayStockSuficienteParaRealizarVentaDe(
					stock.getPresentacion(), stock.getCantidad())) {
				stockDePresentacion.addObserver(this);
				this.stockInsuficienteDeArticulos.add(stock);
				puedeNotificarAlCliente = false;
			} else {
				stockDePresentacion.descontarVentaDeArticulo(stock.getCantidad());
			}
		}
		if (puedeNotificarAlCliente)
			notificar("Ya puede retirar su pedido");
	}

	private void notificar(String unMensaje) {
		setChanged();
		notifyObservers(unMensaje);
	}

	private void notificarAlClienteSiDebe() {
		boolean puedeNotificarAlCliente = true;
		for (Stock stock : this.stockInsuficienteDeArticulos) {
			try {
				if (!this.tienda.hayStockSuficienteParaRealizarVentaDe(
						stock.getPresentacion(), stock.getCantidad()))
					puedeNotificarAlCliente = false;
				else {
					this.stockInsuficienteDeArticulos.remove(stock);
					tienda.buscarStockDePresentacion(stock.getPresentacion())
							.descontarVentaDeArticulo(stock.getCantidad());
				}
			} catch (PresentacionNotFoundException e) {
				/*
				 * No debe hacer nada porque se supone que ya pasó por el paso
				 * de verificar la disponibilidad del stock, donde si está bien
				 * que se lance la exception al no encontrar la presentación.
				 */
			}
		}
		if (puedeNotificarAlCliente)
			notificar("Ya puede retirar su pedido");

	}

	@Override
	public void update(Observable o, Object arg) {
		notificarAlClienteSiDebe();
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

}
