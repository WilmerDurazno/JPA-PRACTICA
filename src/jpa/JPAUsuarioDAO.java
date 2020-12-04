package jpa;

import Entidades.Usuario;
import dao.UsuarioDAO;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO{

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}
}