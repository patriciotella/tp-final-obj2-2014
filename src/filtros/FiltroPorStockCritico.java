package filtros;

import productos.Stock;

public class FiltroPorStockCritico extends FiltroDeProductos {

	protected boolean cumpleCriterioDeFiltro(Stock unStock){
		return unStock.esStockCritico();
	}
}
