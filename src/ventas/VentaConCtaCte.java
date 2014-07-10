package ventas;

import java.util.List;

import org.joda.time.LocalDate;

import productos.Articulo;
import sistema.Cliente;
import sistema.NoTieneSaldoSuficienteParaRealizarOperacionException;

public class VentaConCtaCte extends Venta {

	/**
	 * Crea una venta con cuenta corriente, esto quiere decir que descuenta de
	 * la cuenta del cliente el monto de la venta. Si la cuenta no tiene saldo
	 * suficiente para pagar, se cancela la compra, levantando una exception.
	 * @param unaListaDeArticulos
	 * @param unCliente
	 * @param unaFecha
	 * @throws NoTieneSaldoSuficienteParaRealizarOperacionException
	 */
	public VentaConCtaCte(List<Articulo> unaListaDeArticulos,
			Cliente unCliente, LocalDate unaFecha)
			throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		super(unaListaDeArticulos, unCliente, unaFecha);
		try {
			unCliente.getCuentaCorriente().descontarSaldo(this.getMonto());
		} catch (NoTieneSaldoSuficienteParaRealizarOperacionException e) {
			this.cancelarCompraDeArticulos();
			throw new NoTieneSaldoSuficienteParaRealizarOperacionException(
					"Saldo insuficiente para realizar operacion");
		}
	}

}
