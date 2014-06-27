package filtros;

import org.joda.time.LocalDate;

import ventas.Venta;

public class EntreFechas implements Criterio<Venta> {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public EntreFechas(LocalDate desdeFecha, LocalDate hastaFecha) {
		fechaInicio = desdeFecha;
		fechaFin = hastaFecha;
	}

	@Override
	public boolean cumpleCriterioDeFiltro(Venta venta) {
		return venta.getFecha().isAfter(fechaInicio)
				&& venta.getFecha().isBefore(fechaFin);
	}

}
