package ventas;

import java.util.List;

import productos.Articulo;
import sistema.Cliente;

public class Productos extends VentaConCtaCte {

	protected Productos(List<Articulo> unaListaDeArticulos, Cliente unCliente) {
		super(unaListaDeArticulos, unCliente);
	}

}
