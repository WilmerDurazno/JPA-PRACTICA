package servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Categoria;
import Entidades.Empresa;
import Entidades.Producto;
import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.EmpresaDAO;
import dao.ProductoDAO;

/**
 * Servlet implementation class AnadirProductos
 */
@WebServlet("/AnadirProductos")
public class AnadirProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String eid = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		eid = request.getParameter("eid");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JPSs/agregarProducto.jsp?eid="+eid);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		eid = request.getParameter("eid");
		String nombre = request.getParameter("nombre");
		String precio  = request.getParameter("precio");
		String descripcion = request.getParameter("descripcion");
		String cate = request.getParameter("cate");
		int codigo_cate;
    	if(cate.equals("Oficina")) {
    		codigo_cate = 1;
    	} else if(cate.equals("Papeleria")) {
    		codigo_cate = 2;
    	} else if(cate.equals("Tecnologia")) {
    		codigo_cate = 3;
    	} else {
    		codigo_cate = 0;
    	}
    	//System.out.println("Datos dEL producto = "+nombre+"-"+precio+"-"+descripcion+"-"+cate+"-"+eid);
    	
    	CategoriaDAO cd = DAOFactory.getFactory().getCategoriaDAO();
    	EmpresaDAO ed = DAOFactory.getFactory().getEmpresaDAO();
    	ProductoDAO pd = DAOFactory.getFactory().getProductoDAO();
    	
    	Categoria c = cd.read(codigo_cate);
    	Empresa em = ed.read(Integer.parseInt(eid));
    	Producto p = new Producto(0,nombre, precio, descripcion, c, em);
    	//System.out.println("DATOS--->"+c.getNombre()+"--"+em.getNombre());
    	pd.create(p);
    	response.sendRedirect("http://localhost:8080/JPA-PRACTICA/AnadirProductos?eid="+eid);
    	
    	
	}

}
