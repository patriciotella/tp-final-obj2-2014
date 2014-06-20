package filtros;

import productos.Articulo;
import ventas.Venta;

public class FiltroPorProducto extends FiltroDeVentas {

	private Articulo articulo;

	public FiltroPorProducto(Articulo unArticulo){
		this.articulo = unArticulo;
	}
	
	@Override
	protected boolean cumpleCriterioDeFiltro(Venta venta) {
		return venta.incluyeArticulo(this.articulo);
	}

}
