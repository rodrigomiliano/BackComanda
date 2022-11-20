package comanda.main.dtos;

import java.io.Serializable;

/*DTO es un encapsulador, permite mandar info a través de la red, solo tiene los campos necesarios*/
/*Serializable: un atributo detrás de otro, y lo manda a través de la red*/
public class CategoriaDTO implements Serializable{

	private int id;
	private String nombre;
	private String descripcion;	
	
	public CategoriaDTO(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;		
	}
	
	public CategoriaDTO() {
		
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

}
