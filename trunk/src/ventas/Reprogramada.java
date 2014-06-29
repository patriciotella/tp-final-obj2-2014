package ventas;

public class Reprogramada extends EstadoEnvio {

	protected Reprogramada(EntregaADomicilio unEnvio) {
		super(unEnvio);
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
