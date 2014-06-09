package ventas;

public class EnProceso extends EstadoEnvio {
	
	private double cantidadQueDebeAbonar;
	
	/**
	 * Crea una instancia de EnProceso con el precio que debe abonar el cliente al
	 * momento de la entrega.
	 * @param cantidadQueDebeAbonarElCliente
	 */
	public EnProceso(Double cantidadQueDebeAbonarElCliente){
		cantidadQueDebeAbonar = cantidadQueDebeAbonarElCliente;
	}
	
	public boolean debeAbonarAlgoEnEntrega(){
		return (this.cantidadQueDebeAbonar()>0);
	}
	
	public Double cantidadQueDebeAbonar(){
		return this.cantidadQueDebeAbonar;
	}


}
