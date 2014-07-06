package ventas;

public class Pendiente extends EstadoEnvio {

	public Pendiente(EntregaADomicilio unEnvio) {
		super(unEnvio);
	}

	@Override
	public void enviar() {
		getEntregaADomicilio().setEstado(
				new EnProceso(getEntregaADomicilio()));
	}

	@Override
	public void cancelar() {
		getEntregaADomicilio().setEstado(new Cancelado(getEntregaADomicilio()));
	}

	@Override
	public void reprogramar() throws Exception {
		throw new EnvioPendienteException("La entrega aun esta pendiente.");
	}

}
