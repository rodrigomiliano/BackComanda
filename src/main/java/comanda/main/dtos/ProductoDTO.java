package comanda.main.dtos;

import java.io.Serializable;

import comanda.main.entities.Categoria;

public class ProductoDTO implements Serializable{

	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	private Integer categoriaId;  
		
	public ProductoDTO(String nombre, String descripcion, double precio, Integer categoriaId) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoriaId = categoriaId;
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

	public Integer getCategoriaId() {
		return categoriaId;
	}
	
	public void setCategoriaId(Categoria categoria) {
		this.categoriaId = categoria.getId();
	}
}
