package filtros;

import ventas.Venta;

public class FiltroEntreMontos extends FiltroDeVentas {

	private float montoDesde;
	private float montoHasta;

	public FiltroEntreMontos(float montoDesde, float montoHasta){
		this.montoDesde = montoDesde;
		this.montoHasta = montoHasta;
	}

	@Override
	protected boolean cumpleCriterioDeFiltro(Venta venta) {
		return this.montoDesde<=venta.getMonto() && venta.getMonto()>=this.montoHasta;
	}
	


}
