package filtros;

import productos.Stock;

public class PorStockMinimo implements Criterio<Stock> {

	public boolean cumpleCriterioDeFiltro(Stock unStock){
		return unStock.esStockMinimo();
	}
}
