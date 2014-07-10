package ventas;

import java.util.List;

import org.joda.time.LocalDate;

import productos.Articulo;
import sistema.Cliente;
import sistema.NoTieneSaldoSuficienteParaRealizarOperacionException;

public class VentaConCtaCte extends Venta {

	public VentaConCtaCte(List<Articulo> unaListaDeArticulos,
			Cliente unCliente, LocalDate unaFecha) {
		super(unaListaDeArticulos, unCliente, unaFecha);
		try {
			unCliente.getCuentaCorriente().descontarSaldo(this.getMonto());
		} catch (NoTieneSaldoSuficienteParaRealizarOperacionException e) {
			this.cancelarCompraDeArticulos();
		}
	}
	
}
