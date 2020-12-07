package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import Entidades.*;

@WebServlet("/ProcesarCompra")
public class ProcesarCompra extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String carrito;
	private Date fecha;
	private Producto producto;
	private ProductoDAO productoDao;
	private List<Producto> listaProducto;
	private Compra compra;
	private CompraDAO compraDao;
	private Usuario user;
	private UsuarioDAO userDao;
       
    public ProcesarCompra() {
        
    	fecha = new Date();
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    	compraDao = DAOFactory.getFactory().getCompraDAO();
    	compra = new Compra();
    	userDao = DAOFactory.getFactory().getUsuarioDAO();
    	user = new Usuario();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Ingreso al get de ProcesarCompra.java...");
		
		carrito = request.getParameter("carrito");
		
		String stringNew = carrito;
		String[] parts = stringNew.split(",");
		
		String correo = null;
		correo = request.getParameter("correo");
		
		try {
			
			user = userDao.buscarUsuario(correo);
			System.out.println("Usuario recuperado en servlet : ProcesarCompra.java ---> " +user.getCorreo());
			System.out.println("Tamaño del carrito: "+parts.length);
			
			EmpresaDAO ed = DAOFactory.getFactory().getEmpresaDAO();
			
			for(int i=0;i<=parts.length-1;i++) {
				
				//BUSQUEDA DE CODIGOS.
				int codigo_producto_recuperado=0;
				int codigo_empresa_producto=0;
				int codigo_usuario_recuperado=0;
				
				producto = productoDao.buscarProductoPorDescripcion(parts[i]);
				
				if(producto != null) {
					
					codigo_producto_recuperado = producto.getCodigo();
					codigo_empresa_producto = producto.getEm_pro_id().getCodigo();
					codigo_usuario_recuperado = user.getCodigo();
					
					System.out.println("Codigo de la empresa recurado: " + codigo_empresa_producto);
					
					Empresa em = ed.read(codigo_empresa_producto);
					String MiFecha = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
					String estado = "E";
					
					Compra compra = new Compra(0,MiFecha,estado,em,producto,user);
					compraDao.create(compra);
					
					System.out.println("Compra registrada con exito, Servlet : ProcesarCompra.java");
					
				}else {
					
					System.out.println("No se pudo recuperar producto desde, Servlet : ProcesarCompra.java");
					
				}
				
			}
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Confirmacion de Compra</title></head><body>"
					  + "<h2>Gracias, su solicitud de compra se a procesado con exito</h2>"
					  + "</body></html>");
			
			
		}catch(Exception e) {
			
			System.out.println("Error servlet : ProcesarCompra.java : " + e.getMessage());
			
		}
		
	}

}
