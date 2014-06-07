package productos;

import java.util.List;

public class Producto {
	
	private String nombre;
	private String descripcion;
	private String marca;
	private String tipo;
	private List<Presentacion> presentaciones;
	
	public String getNombre(){
		return this.nombre;
	}
	public String getMarca(){
		return this.marca;
	}
	public List<Presentacion> getPresentaciones(){
		return this.presentaciones;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	public String getTipo(){
		return this.tipo;
	}
	public void setNombre(String n){
		this.nombre=n;
	}
	public void setMarca(String m){
		this.marca=m;
	}
	public void setPresentacion(Presentacion p){
		this.presentaciones.add(p);
	}

}
