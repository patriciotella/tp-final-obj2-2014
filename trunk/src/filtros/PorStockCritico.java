package filtros;

import productos.Stock;

public class PorStockCritico implements Criterio<Stock> {

	public boolean cumpleCriterioDeFiltro(Stock unStock){
		return unStock.esStockCritico();
	}
}
