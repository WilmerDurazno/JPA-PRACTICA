package jpa;

import java.util.List;

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
		em.getTransaction().begin();
		query.setParameter("nombre", nombre);
		query.executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	public Producto buscarProducto(String nombre) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT p FROM Producto p WHERE p.nombre = :nombre");
		query.setParameter("nombre", nombre);
		Producto p = (Producto) query.getSingleResult();
		//em.getTransaction().commit();
		return p;
	}
	
	public List<Producto> listarProducto(int id){
		Query query = em.createQuery("SELECT p FROM Producto p WHERE p.em_pro_id.codigo = :nombre");
		query.setParameter("nombre", id);
		List<Producto> listp = (List<Producto>) query.getResultList();
		return listp;
	}

	
	
}
