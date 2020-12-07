package servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CerrarSesion")
public class CerrarSesion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//SE OBTIENE EL CONTEXTO DE LA SESION ACTUAL Y SE LA INVALIDA. 
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("La sesion se ha cerrado con exito (Class: SessionDestroy.java), redireccionando al index.html...");
		//SE REDIRECCIONA AL USUARIO AL FORMULARIO DE INICIO DE SESION. 
		response.sendRedirect("http://localhost:8080/JPA-PRACTICA/public/IniciarSesion.html");
		
	}

}
