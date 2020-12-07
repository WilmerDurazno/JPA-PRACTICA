package dao;

import Entidades.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer>{
	
	public Usuario buscarUsuario(String correo);

}
