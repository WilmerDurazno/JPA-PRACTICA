import Entidades.Categoria;
import Entidades.Empresa;
import Entidades.Producto;
import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.EmpresaDAO;
import dao.ProductoDAO;

public class prueba {

	
	public static void main(String [] arg) {
			EmpresaDAO eu = DAOFactory.getFactory().getEmpresaDAO();
			CategoriaDAO cd = DAOFactory.getFactory().getCategoriaDAO();
			ProductoDAO pd = DAOFactory.getFactory().getProductoDAO();
			Empresa em = new Empresa(0,"1234567890123","Ecuaceramica333s","Pase de los Canaris");
			Categoria c = new Categoria(0,"Salsi44nas");
			Empresa em2 = new Empresa(0,"1234567890123","Ecuacerami33cas","Pase de los Canaris");
			Categoria c2 = new Categoria(0,"Sals44inas");
			cd.create(c);
			cd.create(c2);
			eu.create(em);
			eu.create(em2);
			Producto p = new Producto(0, "a", "4", "f", c2, em2);
			Producto p2 = new Producto(0, "b", "44", "fe", c, em);
			pd.create(p);
			pd.create(p2);
	}
}
