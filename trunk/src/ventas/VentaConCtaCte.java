package ventas;

import java.util.List;

import org.joda.time.LocalDate;

import productos.Articulo;
import sistema.Cliente;
import sistema.NoTieneSaldoSuficienteParaRealizarOperacionException;

public class VentaConCtaCte extends Venta {

	public VentaConCtaCte(List<Articulo> unaListaDeArticulos,
			Cliente unCliente, LocalDate unaFecha)
			throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		super(unaListaDeArticulos, unCliente, unaFecha);
		unCliente.getCuentaCorriente().descontarSaldo(this.getMonto());
	}
	
}
