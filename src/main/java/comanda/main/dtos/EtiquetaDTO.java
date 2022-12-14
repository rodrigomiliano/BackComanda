package comanda.main.dtos;

import java.io.Serializable;

public class EtiquetaDTO implements Serializable{

	private int id;
	private String nombre;
	private String descripcion;	
	
	public EtiquetaDTO(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;		
	}
	
	public EtiquetaDTO() {
		
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
