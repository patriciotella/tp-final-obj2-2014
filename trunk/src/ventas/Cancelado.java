package ventas;

public class Cancelado extends EstadoEnvio {

	public Cancelado(EntregaADomicilio unaEntrega) {
		super(unaEntrega);
		this.getEntregaADomicilio().cancelarCompraDeArticulos();
	}
	
	@Override
	public void enviar() throws EnvioCanceladoException {
		throw new EnvioCanceladoException("El envio fue cancelado.");
	}
	
	@Override
	public void cancelar() throws EnvioCanceladoException {
		//throw new EnvioCanceladoException("El envio ya esta cancelado.");
	}
	@Override
	public void reprogramar() throws EnvioCanceladoException {
		throw new EnvioCanceladoException("El envio fue cancelado.");
	}

}
