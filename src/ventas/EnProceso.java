package ventas;

public class EnProceso extends EstadoEnvio {
	
	private double cantidadQueDebeAbonar;
	
	public boolean debeAbonarAlgoEnEntrega(){
		return (this.cantidadQueDebeAbonar()>0);
	}
	public double cantidadQueDebeAbonar(){
		return this.cantidadQueDebeAbonar;
	}


}
