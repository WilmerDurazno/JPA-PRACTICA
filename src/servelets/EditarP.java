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
 * Servlet implementation class EditarP
 */
@WebServlet("/EditarP")
public class EditarP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String eid = "";  
	String nombreP;
	String descripcion;
	String precio;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarP() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		eid = request.getParameter("eid");
		nombreP = request.getParameter("nombrep");
		descripcion = request.getParameter("descripcion");
		precio =  request.getParameter("precio");
		System.out.println("llegamos"+"----?"+eid+"----"+nombreP);
		ProductoDAO pd = DAOFactory.getFactory().getProductoDAO();
		Producto p = pd .buscarProducto(nombreP);
		if(p != null) {
			System.out.println("Editado"+p.getNombre()+"--"+p.getDescripcion());
			p.setNombre(nombreP);
			p.setDescripcion(descripcion);
			p.setPrecio(precio);
			pd.update(p);
			RequestDispatcher rd = request.getRequestDispatcher("/JPSs/EditarProducto.jsp?eid="+eid);
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/JPSs/VentanaAdmin.jsp?eid="+eid);
			rd.forward(request, response);
		}
		
	}

}
