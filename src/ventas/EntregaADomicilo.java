package ventas;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import productos.Articulo;
import sistema.Cliente;

public class EntregaADomicilo extends Venta {

	private EstadoEnvio estado;
	private LocalDate fecha;
	
	protected EntregaADomicilo(List<Articulo> unaListaDeArticulos,
			Cliente unCliente, LocalDate unaFecha) {
		super(unaListaDeArticulos, unCliente, unaFecha);
		fecha = unaFecha;
		estado = new Pendiente();
	}
	
	protected void setEstado(EstadoEnvio unEstado){
		estado = unEstado;
	}
	
	public LocalDate getFechaCreacion(){
		return fecha;
	}
}
