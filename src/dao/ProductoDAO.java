package dao;

import java.util.List;

import Entidades.Producto;

public interface ProductoDAO extends GenericDAO<Producto, Integer> {
	
	public void eliminarPorNombre(String nombre);
	
	public  Producto buscarProducto(String nombre);
	
	public Producto buscarProductoPorDescripcion(String descripcion);
		
	public List<Producto> listarProducto(int id);
}
