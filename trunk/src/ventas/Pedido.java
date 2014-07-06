package ventas;

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

	public Pedido(Tienda unaTienda, List<Stock> unaListaDeStockDeArticulos,
			Cliente unCliente, LocalDate unaFecha)
			throws PresentacionNotFoundException {
		this.fecha = unaFecha;
		addObserver(unCliente);
		this.stockDeArticulos = unaListaDeStockDeArticulos;
		this.verificarDisponibilidadDeStock();
		this.tienda = unaTienda;
	}

	private void verificarDisponibilidadDeStock()
			throws PresentacionNotFoundException {
		boolean puedeNotificarAlCliente = true;
		for (Stock stock : stockDeArticulos) {
			if (!this.tienda.hayStockSuficienteParaRealizarVentaDe(
					stock.getPresentacion(), stock.getCantidad())) {
				stock.addObserver(this);
				puedeNotificarAlCliente = false;
			}
		}
		if (puedeNotificarAlCliente)
			notificar("Ya puede retirar su pedido");
	}

	private void notificar(String unMensaje) {
		setChanged();
		notifyObservers(unMensaje);
	}

	private void notificarAlClienteSiDebe() throws PresentacionNotFoundException {
		boolean puedeNotificarAlCliente = true;
		for (Stock stock : this.stockDeArticulos) {
			if (!this.tienda.hayStockSuficienteParaRealizarVentaDe(
					stock.getPresentacion(), stock.getCantidad()));
				puedeNotificarAlCliente = false;
		}
		if(puedeNotificarAlCliente)
			notificar("Ya puede retirar su pedido");
			
	}

	@Override
	public void update(Observable o, Object arg) {
		try{
			notificarAlClienteSiDebe();
		}catch (PresentacionNotFoundException e){
			/*No debe hacer nada porque se supone que ya pasó por el paso de veri-
			 * ficar la disponibilidad del stock, donde si está bien que se lance
			 * la exception al no encontrar la presentación.
			 */
		}	
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
}
