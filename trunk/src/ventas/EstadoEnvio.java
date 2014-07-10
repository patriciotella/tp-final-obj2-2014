package ventas;

public abstract class EstadoEnvio {

	private EntregaADomicilio entrega;

	protected EstadoEnvio(EntregaADomicilio unEnvio) {
		this.entrega = unEnvio;
	}

	/**
	 * Retorna true si el cliente debe abonar algo en el momento de la entrega.
	 * 
	 * @return boolean.
	 */
	public boolean debeAbonarAlgoEnEntrega() throws Exception {
		throw new Exception("Solo el envio en proceso tiene este dato");
	}

	/**
	 * Retorna el precio que debe pagar el cliente al momento de la entrega.
	 * 
	 * @return Double.
	 */
	public Float cantidadQueDebeAbonar() throws Exception {
		throw new Exception("Solo el envio en proceso tiene este dato");
	}

	protected EntregaADomicilio getEntregaADomicilio() {
		return this.entrega;
	}

	public abstract void enviar() throws EnvioCanceladoException,
			EntregaPagaException, EnvioEnProcesoException;

	public abstract void cancelar() throws EnvioCanceladoException,
			EntregaPagaException;

	public abstract void reprogramar() throws EnvioCanceladoException,
			EntregaPagaException, Exception;

	public float getGananciaDeVenta() {
		return 0;
	}

}
