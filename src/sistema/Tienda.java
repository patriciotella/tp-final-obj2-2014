package sistema;

import java.util.LinkedList;
import java.util.List;

import productos.Stock;
import ventas.Venta;

public class Tienda {
	
	private List<Stock> stock; //Usamos una lista o un hashmap para que la búsqueda
	                           //de productos sea más eficiente?
	private List<Venta> ventas;//Lo mismo con las ventas, para devolución y cambio hay
	                           //que buscar la venta y cancelarla.
	
	public void registrarVenta(Venta unaVenta){
		ventas.add(unaVenta);
	}
	
	public List<Venta> getVentasRealizadas(){
		return ventas;
	}
	
	public List<Stock> getPresentacionesConStockMinimo(){
		List<Stock> stocksMinimos = new LinkedList<Stock>();
		for(Stock stockPresentacion : stock){
			if(stockPresentacion.esStockMinimo())
				stocksMinimos.add(stockPresentacion);
		}
		return stocksMinimos;
	}
	
	public List<Stock> getPresentacionesConStockCritico(){
		List<Stock> stocksCriticos = new LinkedList<Stock>();
		for(Stock stockPresentacion : stock){
			if(stockPresentacion.esStockCritico())
				stocksCriticos.add(stockPresentacion);
		}
		return stocksCriticos;
	}
	
	/*ventasRealizadas()

	+ productosConPocoStock()
	+ productosConStockCritico()
	montoCompradoPor(Cliente)
	+ubicarProducto(Producto) holiz, ubicamos producto buscando su stock?
	   quedaría ubicarPresentacion(Stock, int unPasillo, int unEstante)
	    
	+ registrarVenta (Venta) : void
	+ devolver(Venta) : void
	+ cambiar(Presentacion, Venta) : void
*/
}
