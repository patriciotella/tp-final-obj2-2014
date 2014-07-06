package ventas;

public class EnProceso extends EstadoEnvio {

	private float cantidadQueDebeAbonar;

	/**
	 * Crea una instancia de EnProceso con el precio que debe abonar el cliente
	 * al momento de la entrega.
	 * 
	 * @param cantidadQueDebeAbonarElCliente
	 */
	public EnProceso(EntregaADomicilio unaEntrega) {
		super(unaEntrega);
		cantidadQueDebeAbonar = this.getEntregaADomicilio().getMontoQueDebeAbonar();
	}

	@Override
	public boolean debeAbonarAlgoEnEntrega() {
		return (this.cantidadQueDebeAbonar > 0f);
	}

	@Override
	public Float cantidadQueDebeAbonar() {
		return this.cantidadQueDebeAbonar;
	}

	@Override
	public void enviar() throws EnvioEnProcesoException {
		throw new EnvioEnProcesoException("El envio ya esta en proceso.");
	}

	@Override
	public void cancelar() {
		getEntregaADomicilio().setEstado(new Cancelado(getEntregaADomicilio()));
	}

	@Override
	public void reprogramar() {
		getEntregaADomicilio().setEstado(new Pendiente(getEntregaADomicilio()));
	}

}
