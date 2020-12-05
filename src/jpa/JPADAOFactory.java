package jpa;


import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.EmpresaDAO;
import dao.ProductoDAO;
import dao.UsuarioDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new JPACategoriaDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new JPAProductoDAO();
	}

	@Override
	public EmpresaDAO getEmpresaDAO() {
		// TODO Auto-generated method stub
		return new JPAEmpresaDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuarioDAO();
	}
	
	
}
