package servelets;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Producto;
import dao.DAOFactory;
import dao.ProductoDAO;

/**
 * Servlet implementation class BuscarProducto
 */
@WebServlet("/BuscarProducto")
public class BuscarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String eid = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		eid = request.getParameter("eid");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JPSs/BuscarProductoForm.jsp?eid="+eid);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		eid = request.getParameter("eid");
		ProductoDAO pd = DAOFactory.getFactory().getProductoDAO();
		Producto producto = pd.buscarProducto(nombre);
		
		if(producto != null) {
			System.out.println("Si pasa el parameter"+nombre+"--"+eid);
			request.setAttribute("producto", producto);
			RequestDispatcher rd = request.getRequestDispatcher("/JPSs/MostrarProducto.jsp?eid="+eid);
			rd.forward(request, response);
		}else {
			//RequestDispatcher rd = request.getRequestDispatcher("/JPSs/VentanaAdmin.jsp?eid="+eid);
			//rd.forward(request, response);
		}
	}

}
