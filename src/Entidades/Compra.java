package Entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compra
 *
 */
@Entity

public class Compra implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String fecha;
	private String estado;
	@ManyToOne
	@JoinColumn
	private Empresa em_com_id;
	@OneToOne
	@JoinColumn
	private Producto pro_com_id;
	@ManyToOne
	@JoinColumn
	private Usuario us_com_id;

	public Compra() {
		super();
	}

	public Compra(int codigo, String fecha, String estado, Empresa em_com_id, Producto pro_com_id, Usuario us_com_id) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.estado = estado;
		this.em_com_id = em_com_id;
		this.pro_com_id = pro_com_id;
		this.us_com_id = us_com_id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Empresa getEm_com_id() {
		return em_com_id;
	}

	public void setEm_com_id(Empresa em_com_id) {
		this.em_com_id = em_com_id;
	}

	public Producto getPro_com_id() {
		return pro_com_id;
	}

	public void setPro_com_id(Producto pro_com_id) {
		this.pro_com_id = pro_com_id;
	}

	public Usuario getUs_com_id() {
		return us_com_id;
	}

	public void setUs_com_id(Usuario us_com_id) {
		this.us_com_id = us_com_id;
	}
   
}
