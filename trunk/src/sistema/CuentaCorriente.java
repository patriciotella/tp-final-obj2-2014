package sistema;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente {

	private float saldo;
	private List<String> movimientos;

	// creo que faltaria que definamos un poco que son los movimientos
	// plantearlo como una clase nueva, que toma una venta, fehca, monto,
	// los nombres de los productos de la venta y el importe total
	// EL STRING ES MEDIO FLACO
	public CuentaCorriente() {
		this.saldo = 0f;
		this.movimientos = new ArrayList<String>();
	}

	public List<String> getMovimientos() {
		return movimientos;
	}

	public float getSaldo() {
		return this.saldo;
	}

	public void setSaldo(float unMonto) {
		this.saldo = unMonto;
	}

	public void depositarSaldo(Float unMonto) {
		this.saldo += unMonto;
	}

	public void descontarSaldo(Float unMonto)
			throws NoTieneSaldoSuficienteParaRealizarOperacionException {
		if(this.saldo - unMonto < 0)
			throw new NoTieneSaldoSuficienteParaRealizarOperacionException();
		this.saldo -= unMonto; // <- Ver si puede tener saldo negativo, si no
	} // Exception.

}
