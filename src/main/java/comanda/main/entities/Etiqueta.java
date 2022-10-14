package comanda.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comandabd_etiqueta")
public class Etiqueta {

	@Id
	@Column(name = "etiqueta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "etiqueta_nombre", unique = true)
	private String nombre;
	
	@Column(name = "etiqueta_descripcion")
	private String descripcion;
	
		
	public Etiqueta(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;		
	}
	
	public Etiqueta() {
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}		
	
}
