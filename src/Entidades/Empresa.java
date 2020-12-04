package Entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Empresa
 *
 */
@Entity

public class Empresa implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String ruc;
	private String nombre;
	private String direccion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "em_pro_id" )
	private List<Producto> productos;
	
	public Empresa() {
		//CONSTRUCTOR OBLIGATORIO;
	}
	
	public Empresa(int codigo, String ruc, String nombre, String direccion) {
		super();
		this.codigo = codigo;
		this.ruc = ruc;
		this.nombre = nombre;
		this.direccion = direccion;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Empresa [codigo=" + codigo + ", ruc=" + ruc + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", productos=" + productos + "]";
	}
   
}
