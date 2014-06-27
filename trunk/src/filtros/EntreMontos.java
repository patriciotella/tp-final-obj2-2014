package filtros;

import ventas.Venta;

public class EntreMontos implements Criterio<Venta> {

	private float montoDesde;
	private float montoHasta;

	public EntreMontos(float montoDesde, float montoHasta){
		this.montoDesde = montoDesde;
		this.montoHasta = montoHasta;
	}

	@Override
	public boolean cumpleCriterioDeFiltro(Venta venta) {
		return this.montoDesde<=venta.getMonto() && venta.getMonto()<=this.montoHasta;
	}
	


}
