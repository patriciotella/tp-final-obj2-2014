package filtros;

import productos.Articulo;
import ventas.Venta;

public class PorProducto implements Criterio<Venta> {

	private Articulo articulo;

	public PorProducto(Articulo unArticulo){
		this.articulo = unArticulo;
	}
	
	@Override
	public boolean cumpleCriterioDeFiltro(Venta venta) {
		return venta.incluyeArticulo(this.articulo);
	}

}
