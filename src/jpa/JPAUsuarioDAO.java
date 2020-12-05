package jpa;

import javax.persistence.Query;
import Entidades.Usuario; 
import dao.UsuarioDAO;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO{

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}
	
	@Override
	public void crearUsuario(int codigo, String nombre, String apellido, String cedula, String correo, String contrasena, String tipo_usuario, int Empresa_em_id) {
		Query query = em.createNamedQuery("crearUsuario");
		query.setParameter("codigo", codigo);
		query.setParameter("nombre", nombre);
		query.setParameter("apellido", apellido);
		query.setParameter("cedula", cedula);
		query.setParameter("correo", correo);
		query.setParameter("contrasena", contrasena);
		query.setParameter("tipo_usuario", tipo_usuario);
		query.setParameter("Empresa_em_id", Empresa_em_id);
		query.executeUpdate();
	}
	
}
