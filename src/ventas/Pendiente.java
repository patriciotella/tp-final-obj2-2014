package ventas;

public class Pendiente extends EstadoEnvio {

	protected Pendiente(EntregaADomicilio unEnvio) {
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
