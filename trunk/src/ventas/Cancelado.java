package ventas;

public class Cancelado extends EstadoEnvio {

	@Override
	public boolean debeAbonarAlgoEnEntrega() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double cantidadQueDebeAbonar() {
		// TODO Auto-generated method stub
		return null;
	}

}
