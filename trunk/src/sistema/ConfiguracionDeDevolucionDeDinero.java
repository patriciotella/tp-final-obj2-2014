package sistema;

import ventas.Venta;

public abstract class ConfiguracionDeDevolucionDeDinero {

	public abstract void devolverDineroACliente(Venta unaVenta,float unMonto);

	public abstract void pagarlaDiferencia(Venta unaVenta, float unMonto);

}
