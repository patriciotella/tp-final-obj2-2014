package ventas;

import java.util.List;

import org.joda.time.LocalDate;

import productos.Articulo;
import sistema.Cliente;

public class VentaDirecta extends Venta {

	public VentaDirecta(List<Articulo> unaListaDeArticulos, Cliente unCliente,
			LocalDate unaFecha) {
		super(unaListaDeArticulos, unCliente, unaFecha);
	}
}
