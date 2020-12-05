package dao;

import Entidades.Producto;

public interface ProductoDAO extends GenericDAO<Producto, Integer> {
	
	public void eliminarPorNombre(String nombre);
}
