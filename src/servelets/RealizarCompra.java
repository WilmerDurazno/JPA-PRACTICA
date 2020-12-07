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
						
			usuario = usuarioDao.buscarUsuario(correo);
			
			int codigo_empresa = usuario.getEm_pro_id().getCodigo();
			
			listaProducto = productoDao.listarProducto(codigo_empresa);
			
			System.out.println("Tamaño de la lista: " + listaProducto.size());
			request.setAttribute("productos", listaProducto);
			
			getServletContext().getRequestDispatcher("/JPSs/CompraProductos.jsp").forward(request, response);
			
		}catch(Exception e) {
			
			getServletContext().getRequestDispatcher("/JPSs/VentanaUsuario.jsp").forward(request, response);
			System.out.println("Error: " + e.getMessage());
		
		}
		
	} 

}
