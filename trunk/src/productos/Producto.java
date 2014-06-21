package productos;

import java.util.List;

/**
 * Esta clase es una representacion abstracta de un producto en si. 
 * Cada producto tendra distintas presentaciones que lo identificaran.
 * Un producto tiene un nombre, descripcion, marcam tipo y una lista de presentaciones. 
 */
public class Producto {
	
	private String nombre;
	private String descripcion;
	private String marca;
	private String tipo;
	private List<Presentacion> presentaciones;
	
	/**
	 * Retorna el nombre de un producto.
	 * @return String
	 */
	public String getNombre(){
		return this.nombre;
	}
	
	/**
	 * Retorna la marca de un producto.
	 * @return String
	 */
	public String getMarca(){
		return this.marca;
	}
	
	/**
	 * Retorna la lista de presentaciones de un producto.
	 * @return List<Presentacion>
	 */
	public List<Presentacion> getPresentaciones(){
		return this.presentaciones;
	}
	
	/**
	 * Retorna la descripcion que tiene un producto.
	 * @return String
	 */
	public String getDescripcion(){
		return this.descripcion;
	}
	
	/**
	 * Retorna el tipo de un producto
	 * @return String
	 */
	public String getTipo(){
		return this.tipo;
	}
	
	/**
	 * Establece el nombre de un producto
	 * @param unNombre
	 */
	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}
	
	/**
	 * Establece la marca de un producto
	 * @param unaMarca
	 */
	public void setMarca(String unaMarca){
		this.marca = unaMarca;
	}
	
	/**
	 * Establece una presentacion del producto.
	 * @param unaPresentacion
	 */
	public void setPresentacion(Presentacion unaPresentacion){
		this.presentaciones.add(unaPresentacion);
	}

}
