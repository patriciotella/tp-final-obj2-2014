package ventas;

import java.util.List;

import productos.Articulo;
import sistema.Cliente;

public abstract class VentaConCtaCte extends Venta {

	protected VentaConCtaCte(List<Articulo> unaListaDeArticulos,
			Cliente unCliente) {
		super(unaListaDeArticulos, unCliente);
	}

	
}
