package dao;

import Entidades.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer>{
	
	public void crearUsuario(int codigo, String nombre, String apellido, String cedula, String correo, String contrasena, String tipo_usuario, int Empresa_em_id);

}
