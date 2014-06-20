package filtros;

import productos.Stock;

public class FiltroPorStockMinimo extends FiltroDeProductos {

	protected boolean cumpleCriterioDeFiltro(Stock unStock){
		return unStock.esStockMinimo();
	}
}
