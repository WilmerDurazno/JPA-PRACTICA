package servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Producto;
import dao.DAOFactory;



/**
 * Servlet implementation class ListarProductos
 */
@WebServlet("/ListarProductos")
public class ListarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String eid = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		eid = request.getParameter("eid");
		System.out.println("ListarEProductosGET--->"+eid);
		List<Producto>listP = new ArrayList<Producto>();
		listP = DAOFactory.getFactory().getProductoDAO().listarProducto(Integer.parseInt(eid));
		if(listP != null) {
			request.setAttribute("lista", listP);
			System.out.println("El tamano de la lista es"+listP.size());
			getServletContext().getRequestDispatcher("/JPSs/ListarProductos.jsp?eid="+eid).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
