package sistema;

public class Cliente {
	
	private String nombre;
	private long dni;
	private String direccion;
	private CuentaCorriente ctacte;
	private boolean subcripcionOfertas;
	
	public Cliente (String n, long d, String dir){
		this.nombre=n;
		this.dni=d;
		this.direccion=dir;
		this.subcripcionOfertas=false;
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
	public void subscribirseALasOfertasDe(/*SistemaVentas sist*/){
		this.subcripcionOfertas=true;
	}
	public void cancelarSubscripcionAOfertas(){
		this.subcripcionOfertas=false;
	}
	public boolean recibeOferta(){
		return this.subcripcionOfertas;
	}

}
