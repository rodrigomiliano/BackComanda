package comanda.main.dtos;

import java.io.Serializable;

public class ProductoDTO implements Serializable{

	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	
	public ProductoDTO(String nombre, String descripcion, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public ProductoDTO() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
