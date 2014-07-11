package sistema;

import ventas.Venta;

public class DevolucionPorCtaCte extends ConfiguracionDeDevolucionDeDinero {

	@Override
	public void devolverDineroACliente(Venta unaVenta, float unMonto) {
		unaVenta.getCliente().getCuentaCorriente().depositarSaldo(unMonto);

	}

	@Override
	public void pagarlaDiferencia(Venta unaVenta, float unMonto) {
		try{
			unaVenta.getCliente().getCuentaCorriente().descontarSaldo(unMonto);
		}catch (NoTieneSaldoSuficienteParaRealizarOperacionException e){
			System.out.println("Compra imposible de realizar por falta de stock");
		}

	}

}
