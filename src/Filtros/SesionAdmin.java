package Filtros;

import java.io.IOException;   
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/JPSs/VentanaAdmin.jsp","/JPSs/Pedidos.jsp","/JPSs/MostrarProductoEditar.jsp","/JPSs/MostrarProducto.jsp","/JPSs/ListarRequisitos.jsp","/JPSs/ListarProductos.jsp","/JPSs/EliminarProducto.jsp","/JPSs/EditarProducto.jsp","/JPSs/BuscarProductoForm.jsp","/JPSs/agregarProducto.jsp"})
public class SesionAdmin implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession sesion = ((HttpServletRequest) request).getSession();
		if(sesion.getAttribute("SesionAdmin") != null) {
			System.out.println("Se ha iniciado sesion correctamente (Filter: SesionAdmin.java - Session: Ok), redireccionando al Servlet Proceso.java...");
			chain.doFilter(request, response);
		} else {
			System.out.println("No se ha iniciado sesion (Filter: SesionAdmin.java - Session: Null), redireccionando al formulario de inicio de sesion...");
			((HttpServletResponse) response).sendRedirect("http://localhost:8080/JPA-PRACTICA/public/login.html");
		}
	}

}
