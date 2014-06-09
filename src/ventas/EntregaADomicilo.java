package ventas;

import java.util.List;

import org.joda.time.DateTime;

import productos.Articulo;
import sistema.Cliente;

public class EntregaADomicilo extends Venta {

	private EstadoEnvio estado;
	private DateTime fecha;
	
	protected EntregaADomicilo(List<Articulo> unaListaDeArticulos,
			Cliente unCliente) {
		super(unaListaDeArticulos, unCliente);
		fecha = DateTime.now();
		estado = new Pendiente();
	}
	
	protected void setEstado(EstadoEnvio unEstado){
		estado = unEstado;
	}
	
	public DateTime getFechaCreacion(){
		return fecha;
	}
}
