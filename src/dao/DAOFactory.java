package dao;
import jpa.JPADAOFactory;


public abstract class DAOFactory {
    // Sería mejor por inyección de objetos
    protected static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
	return factory;
    }
    
    public abstract CategoriaDAO getCategoriaDAO();
    
    public abstract ProductoDAO getProductoDAO();
    
    public abstract EmpresaDAO getEmpresaDAO();
    
    public abstract UsuarioDAO getUsuarioDAO();
}
