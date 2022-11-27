package comanda.main.entities;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
			
	@ManyToOne(targetEntity = Categoria.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="categoria_id", referencedColumnName="categoria_id", nullable = false)
	private Categoria categoria_id;
	
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
	
	public Categoria getCategoria() {
		return categoria_id;
	}

	public void setCategoria(int categoria) {
		this.categoria_id = categoria;
		
	}
	
}
