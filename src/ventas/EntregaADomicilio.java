package ventas;

import java.util.List;

import org.joda.time.LocalDate;

import productos.Articulo;
import sistema.Cliente;

public class EntregaADomicilio extends Venta {

	private EstadoEnvio estado;
	private LocalDate fecha;
	
	protected EntregaADomicilio(List<Articulo> unaListaDeArticulos,
			Cliente unCliente, LocalDate unaFecha) {
		super(unaListaDeArticulos, unCliente, unaFecha);
		fecha = unaFecha;
		estado = new Pendiente(this);
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
}
