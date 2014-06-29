package ventas;

public class Reprogramada extends EstadoEnvio {// No tiene mucho sentido esta
												// clase.

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

	@Override
	public void enviar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reprogramar() {
		// TODO Auto-generated method stub

	}

}
