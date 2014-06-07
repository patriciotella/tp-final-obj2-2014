package sistema;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
	
	private String nombre;
	private long dni;
	private String direccion;
	private CuentaCorriente ctacte;
	
	public Cliente (String n, long d, String dir){
		this.nombre=n;
		this.dni=d;
		this.direccion=dir;
		this.ctacte=new CuentaCorriente();
	}
	public String getNombre(){
		return this.nombre;
	}
	public long getDNI(){
		return this.dni;
	}
	public String getDireccion(){
		return this.direccion;
	}
	public void setDireccion(String dir){
		this.direccion=dir;
	}
	public void subscribirseALasOfertasDe(SistemaVentas sist){
		//VA EL UPDATE??
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
