package comanda.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comandabd_producto")
public class Producto {

	@Id
	@Column(name = "producto_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "producto_nombre", unique = true)
	private String nombre;
	
	@Column(name = "producto_descripcion")
	private String descripcion;
	
	@Column(name = "producto_precio")
	private double precio;
	
		
	public Producto(String nombre, String descripcion, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;	
		this.precio = precio;
	}
	
	public Producto() {
		
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
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
