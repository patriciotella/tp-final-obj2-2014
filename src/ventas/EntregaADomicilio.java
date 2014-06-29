package ventas;

import java.util.List;

import org.joda.time.LocalDate;

import productos.Articulo;
import sistema.Cliente;

public class EntregaADomicilio extends Venta {

	private EstadoEnvio estado;
	private LocalDate fecha;
	private Float montoAPagar;
	
	public EntregaADomicilio(List<Articulo> unaListaDeArticulos,
			Cliente unCliente, LocalDate unaFecha, Float montoQueDebeAbonar) {
		super(unaListaDeArticulos, unCliente, unaFecha);
		fecha = unaFecha;
		estado = new Pendiente(this);
		montoAPagar = montoQueDebeAbonar;
	}
	
	protected void setEstado(EstadoEnvio unEstado){
		estado = unEstado;
	}
	
	public LocalDate getFechaCreacion(){
		return fecha;
	}

	public void cancelarCompraDeArticulos() {
		for(Articulo articulo : this.getDetalle())
			articulo.cancelarCompraDeArticulo();
	}
	
	public void enviar() throws Exception {
		this.estado.enviar();
	}
	
	public void cancelarEnvio() throws EnvioCanceladoException {
		this.estado.cancelar();
	}
	
	public void reprogramarEnvio() throws Exception {
		this.estado.reprogramar();
	}
	
	public Float getMontoQueDebeAbonar() {
		return this.montoAPagar;
	}
}
