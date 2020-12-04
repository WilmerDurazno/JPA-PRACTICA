package Entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity

public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private String precio;
	private String descripcion;
	@ManyToOne
	@JoinColumn
	private Categoria cat_pro_id;
	@ManyToOne
	@JoinColumn
	private Empresa em_pro_id;

	public Producto() {
		super();
	}

	public Producto(int codigo, String nombre, String precio, String descripcion, Categoria cat_pro_id, Empresa em_pro_id) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.cat_pro_id = cat_pro_id;
		this.em_pro_id = em_pro_id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCat_pro_id() {
		return cat_pro_id;
	}

	public void setCat_pro_id(Categoria cat_pro_id) {
		this.cat_pro_id = cat_pro_id;
	}

	public Empresa getEm_pro_id() {
		return em_pro_id;
	}

	public void setEm_pro_id(Empresa em_pro_id) {
		this.em_pro_id = em_pro_id;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", descripcion="
				+ descripcion + ", cat_pro_id=" + cat_pro_id + ", em_pro_id=" + em_pro_id + "]";
	}
	
	
   
}
