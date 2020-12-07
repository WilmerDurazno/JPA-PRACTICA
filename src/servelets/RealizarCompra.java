package servelets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidades.Usuario;
import Entidades.Producto;
import dao.DAOFactory;
import dao.ProductoDAO;
import dao.UsuarioDAO;

@WebServlet("/RealizarCompra")
public class RealizarCompra extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	java.util.Date fecha;
	private Usuario usuario;
	private UsuarioDAO usuarioDao;
	private Producto producto;
	private ProductoDAO productoDao;
	private List<Producto> listaProducto;
       
    public RealizarCompra() {
        
    	fecha = new Date();
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    	usuario = new Usuario();
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Ingresado al metodo de doGet de Realizar Compra : Servlet");
		
		String correo = request.getParameter("correo");
		String contra = request.getParameter("contra");
		
		String url = null;
		
		try {
			
			//usuario = usuarioDao.findUser(correo, contra);
			usuario = usuarioDao.buscarUsuario(correo);
			
			int codigo_empresa = usuario.getEm_pro_id().getCodigo();
			
			listaProducto = (List<Producto>) productoDao.buscarProductoPorEmpresa(codigo_empresa);
			
			System.out.println("Tamaño de la lista: " + listaProducto.size());
			request.setAttribute("productos", listaProducto);
			
			url = "/JPSs/CompraProductos.jsp";
			//response.sendRedirect("http://localhost:8080/PracticaServJSPyJDBC/JPSs/CompraProductos.jsp");
			
		}catch(Exception e) {
			url = "/JPSs/VentanaUsuario.jsp";
			System.out.println("Error: " + e.getMessage());
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	} 

}
