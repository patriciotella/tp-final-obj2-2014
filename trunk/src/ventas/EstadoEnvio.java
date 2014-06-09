package ventas;


public abstract class EstadoEnvio {
	
	/**
	 * Retorna true si el cliente debe abonar algo en el momento de la entrega.
	 * @return boolean.
	 */
	public abstract boolean debeAbonarAlgoEnEntrega();
	
	/**
	 * Retorna el precio que debe pagar el cliente al momento de la entrega.
	 * @return Double.
	 */
	public abstract Double cantidadQueDebeAbonar();
}
