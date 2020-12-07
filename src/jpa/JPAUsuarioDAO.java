package jpa;

import javax.persistence.Query; 
import Entidades.Usuario; 
import dao.UsuarioDAO;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO{

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario buscarUsuario(String correo) {
		
		Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :correo");
		query.setParameter("correo", correo);
		Usuario u = (Usuario) query.getSingleResult();
		return u;
	}
	
}
