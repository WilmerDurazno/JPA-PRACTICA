package Entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@NamedQuery(name = "crearUsuario", query = "INSERT Usuario VALUES(0,:nombre,:apellido,:cedula,:correo,:contrasena,:tipo_usuario,:Empresa_em_id")
@NamedQuery(name = "eliminarPorNombre", query = "DELETE FROM Producto p WHERE p.nombre = :nombre")
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
	private String contrasena;
	private String tipo_usuario;
	@ManyToOne
	@JoinColumn
	private int Empresa_em_id;
	
	public Usuario() {
		//CONSTRUCTOR OBLIGATORIO;
	}

	public Usuario(int codigo, String nombre, String apellido, String cedula, String correo, String contrasena,
			String tipo_usuario, int empresa_em_id) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.correo = correo;
		this.contrasena = contrasena;
		this.tipo_usuario = tipo_usuario;
		Empresa_em_id = empresa_em_id;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public int getEmpresa_em_id() {
		return Empresa_em_id;
	}

	public void setEmpresa_em_id(int empresa_em_id) {
		Empresa_em_id = empresa_em_id;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", correo=" + correo + ", contrasena=" + contrasena + ", tipo_usuario=" + tipo_usuario
				+ ", Empresa_em_id=" + Empresa_em_id + "]";
	}
   
}
