package jpa;

import java.util.List;

import javax.persistence.Query;

import Entidades.Compra;
import dao.CompraDAO;

public class JPACompraDAO extends JPAGenericDAO<Compra, Integer> implements CompraDAO {
	
	public JPACompraDAO() {
		super(Compra.class);
	}
	
	public List<Compra> listarCompras(int idEmpresa){
		Query query = em.createQuery("Select c From Compra c WHERE c.em_com_id.codigo = :nombre");
		query.setParameter("nombre", idEmpresa);
		List<Compra> listc = query.getResultList();
		return listc;
	}

	@Override
	public List<Compra> listarComprasPorUsuario(int idUsuario) {
		Query query = em.createQuery("Select c From Compra c WHERE c.us_com_id.codigo = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		List<Compra> listc = query.getResultList();
		return listc;
	}
	
}
