package jpa;

import javax.persistence.Query;
import Entidades.Producto;
import dao.ProductoDAO;

public class JPAProductoDAO extends JPAGenericDAO<Producto,Integer> implements ProductoDAO{
	
	public JPAProductoDAO() {
		super(Producto.class);
	}

	@Override
	public void eliminarPorNombre(String nombre) {
		Query query = em.createNamedQuery("eliminarPorNombre");
		query.setParameter("nombre", nombre);
		query.executeUpdate();
	}
	
	
}
