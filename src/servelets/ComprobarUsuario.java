package servelets;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidades.Usuario;
import dao.DAOFactory;
import dao.UsuarioDAO;

@WebServlet("/ComprobarUsuario")
public class ComprobarUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ComprobarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		System.out.println("DATOS USUARIO LOGIN----->"+email+" - "+contrasena);
		
		UsuarioDAO usDAO = DAOFactory.getFactory().getUsuarioDAO();
		Usuario user = usDAO.buscarUsuario(email);
		
		if(user != null) {
			
			System.out.println("Usuario: "+user.getCorreo()+", recuperado satisfactoriamente...");
			
			String tipo_user = user.getTipo_usuario();
			String nombre_user = user.getNombre();
			String apellido_user = user.getApellido();
			String cedula_user = user.getCedula();
			
			if(tipo_user.equals("U")) {
				
				request.getSession().setAttribute("Sesion", "Logeado");
				System.out.println("El usuario: "+user.getCorreo()+" es un usuario sin priviliegios...");
				response.sendRedirect("http://localhost:8080/JPA-PRACTICA/JPSs/VentanaUsuario.jsp");
				
			}else if(tipo_user.equals("A")) {
				
				request.getSession().setAttribute("SesionAdmin", "LogeadoAdmin");
				System.out.println("El usuario: "+user.getCorreo()+" es administrador...");
				response.sendRedirect("http://localhost:8080/JPA-PRACTICA/JPSs/VentanaAdmin.jsp");
				
			}else {
				
				System.out.println("Usuario no encontrado...");
				response.sendRedirect("http://localhost:8080/JPA-PRACTICA/index.html");
				
			}
			
		}else {
			
			System.out.println("Usuario no recuperado (Servlet: ComprobarUsuario.java)");
			
		}
		
	}

}
