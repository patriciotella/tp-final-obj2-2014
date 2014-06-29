package ventas;

public class Cancelado extends EstadoEnvio {

	public Cancelado(EntregaADomicilio unaEntrega) {
		super(unaEntrega);
		this.getEntregaADomicilio().cancelarCompraDeArticulos();
	}
	@Override
	public boolean debeAbonarAlgoEnEntrega() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Float cantidadQueDebeAbonar() {
		// TODO Auto-generated method stub
		return null;
	}

}
