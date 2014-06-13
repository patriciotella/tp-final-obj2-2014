package ventas;

import java.util.List;

import productos.Articulo;
import sistema.Cliente;

public class VentaConCtaCte extends Venta {

	public VentaConCtaCte(List<Articulo> unaListaDeArticulos,
			Cliente unCliente) {
		super(unaListaDeArticulos, unCliente);
	}

	
}
