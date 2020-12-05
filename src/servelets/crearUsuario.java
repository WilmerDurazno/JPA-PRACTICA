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
import dao.EmpresaDAO;
import jpa.JPAUsuarioDAO;
import jpa.JPAEmpresaDAO;

@WebServlet("/crearUsuario")
public class crearUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//RECUPERANDO VARIABLES ENVIADAS DESDE EL FORMULARIO. 
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String cedula = request.getParameter("cedula");
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		String tipo_usuario = request.getParameter("tipo_usuario");
		String empresa = request.getParameter("empresa");
		int codigo_empresa = 0;
		
		//OBTENIENDO EL CODIGO DE LA EMPRESA. 
		if(empresa.equals("ONERON")) {
			codigo_empresa = 1;
		}else if(empresa.equals("Importsum")) {
			codigo_empresa = 2;
		}else if(empresa.equals("Papelesa")) {
			codigo_empresa = 3;
		}else {
			System.out.println("Error al recuperar el codigo de la empresa...");
		}
		
		UsuarioDAO ud = DAOFactory.getFactory().getUsuarioDAO();
		EmpresaDAO ed = DAOFactory.getFactory().getEmpresaDAO();
		
		Usuario user = new Usuario(0,nombre,apellido,cedula,correo,contrasena,tipo_usuario,codigo_empresa);
		
		try {
			ud.create(user);
			System.out.println("Usuario insertado en la base de datos correctamente...");
		}catch(Exception e) {
			System.out.println("Error en la inserción: " + e.getMessage());
		}
		
	}

}
