package filtros;

import sistema.Cliente;
import ventas.Venta;

public class VentaRealizadaPorCliente implements Criterio<Venta>{

	private Cliente cliente;

	public VentaRealizadaPorCliente(Cliente unCliente) {
		this.cliente = unCliente;
	}
	
	@Override
	public boolean cumpleCriterioDeFiltro(Venta unaVenta) {
		return unaVenta.fueCompradaPor(this.cliente);
	}

}
