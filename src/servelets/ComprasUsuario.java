package servelets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidades.*;
import dao.*;
 
@WebServlet("/ComprasUsuario")
public class ComprasUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private UsuarioDAO usuarioDao;
	private Compra compra;
	private CompraDAO compraDao;
	private List<Compra> listaCompra;
       
    public ComprasUsuario() {
        
    	usuario = new Usuario();
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    	compra = new Compra();
    	compraDao = DAOFactory.getFactory().getCompraDAO();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String correo = request.getParameter("correo");
		String contra = request.getParameter("contra");
		
		String url = null;
		
		try {
			
			usuario = usuarioDao.buscarUsuario(correo);
			
			int codigo_usuario = usuario.getCodigo();
			
			listaCompra = compraDao.listarComprasPorUsuario(codigo_usuario);
			
			request.setAttribute("compras", listaCompra);
			
			System.out.println("Compras retornadas a la ventana con exito...");
			
			url = "/JPSs/MisCompras.jsp";
			
		}catch(Exception e) {
			
			System.out.println("Error en servlet : ComprasUsuario.java: " + e.getMessage());
			url = "/JPSs/VentanaUsuario.jsp";
			
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
