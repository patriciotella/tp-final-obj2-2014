package ventas;

import java.util.List;

import productos.Articulo;
import sistema.Cliente;

public class VentaDirecta extends Venta {

	public VentaDirecta(List<Articulo> unaListaDeArticulos, Cliente unCliente){
		super(unaListaDeArticulos, unCliente);
	}
}
