package jpa;

import Entidades.Producto;
import dao.ProductoDAO;

public class JPAProductoDAO extends JPAGenericDAO<Producto,Integer> implements ProductoDAO{
	
	public JPAProductoDAO() {
		super(Producto.class);
	}
}
