package dao;

import java.util.List;

import Entidades.Compra;

public interface CompraDAO extends GenericDAO<Compra, Integer> {
	
	public List<Compra> listarCompras(int idEmpresa);
}
