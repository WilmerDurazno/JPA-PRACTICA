package servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import Entidades.Producto;
import dao.DAOFactory;
import dao.ProductoDAO;

/**
 * Servlet implementation class EditarProducto
 */
@WebServlet("/EditarProducto")
public class EditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String eid = "";
	String nombreP;
	String descripcion;
	String precio;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		eid = request.getParameter("eid");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JPSs/EditarProducto.jsp?eid="+eid);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		ProductoDAO pd = DAOFactory.getFactory().getProductoDAO();
		Producto p = pd.buscarProducto(nombre);
		if(p != null) {
			request.setAttribute("producto", p);
			RequestDispatcher rd = request.getRequestDispatcher("/JPSs/MostrarProductoEditar.jsp?eid="+eid);
			rd.forward(request, response);
		}else {
			request.getRequestDispatcher("/JPSs/EditarProducto.jsp?eid="+eid);
		}
		
		
		
	}

}
