package filtros;

import org.joda.time.LocalDate;

import ventas.Venta;

public class FiltroEntreFechas extends FiltroDeVentas {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public FiltroEntreFechas(LocalDate desdeFecha, LocalDate hastaFecha) {
		fechaInicio = desdeFecha;
		fechaFin = hastaFecha;
	}

	@Override
	protected boolean cumpleCriterioDeFiltro(Venta venta) {
		return venta.getFecha().isAfter(fechaInicio)
				&& venta.getFecha().isBefore(fechaFin);
	}

}
