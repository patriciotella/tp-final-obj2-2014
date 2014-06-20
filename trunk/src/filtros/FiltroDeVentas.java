package filtros;

import java.util.LinkedList;
import java.util.List;

import sistema.SistemaVentas;
import sistema.Tienda;
import ventas.Venta;

public abstract class FiltroDeVentas {

	public final List<Venta> filtrar(SistemaVentas unSistema){
		return filtrarSegunCriterio(unSistema.getVentas());
	}
	
	public final List<Venta> filtrar(Tienda unaTienda){
		return filtrarSegunCriterio(unaTienda.getVentasRealizadas());
	}

	private final List<Venta> filtrarSegunCriterio(List<Venta> ventasRealizadas){
		List<Venta> ventasFiltradas = new LinkedList<Venta>();
		for(Venta venta : ventasRealizadas){
			if(cumpleCriterioDeFiltro(venta))
				ventasFiltradas.add(venta);
		}
		return ventasFiltradas;
	}

	protected abstract boolean cumpleCriterioDeFiltro(Venta venta);
}
