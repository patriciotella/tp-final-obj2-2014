package sistema;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente {
	
	private double saldo;
	private List<String> movimientos;
	
	// creo que faltaria que definamos un poco que son los movimientos
	//plantearlo como una clase nueva, que toma una venta, fehca, monto,
	//los nombres de los productos de la venta y el importe total
	//EL STRING ES MEDIO FLACO
	public CuentaCorriente(){
		this.saldo=0;
		this.movimientos=new ArrayList<String>();
	}
	
	public List<String> getMovimientos(){
		return movimientos; 
	}
	public double getSaldo(){
		return this.saldo;
	}
	public void setSaldo(double unMonto){
		this.saldo = unMonto;
	}
	public void depositarSaldo(Double unMonto){
		this.saldo += unMonto;
	}
	public void descontarSaldo(Double unMonto){
		this.saldo -= unMonto; //<- Ver si puede tener saldo negativo, si no
	}                          // Exception.

}
