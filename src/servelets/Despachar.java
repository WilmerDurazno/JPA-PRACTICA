package servelets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Compra;
import dao.CompraDAO;
import dao.DAOFactory;

/**
 * Servlet implementation class Despachar
 */
@WebServlet("/Despachar")
public class Despachar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String eid = "";
	String cabecera = "";
	String bandera = ""; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Despachar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		eid = request.getParameter("eid");
		cabecera = request.getParameter("cabecera");
		bandera = request.getParameter("bandera");
		eid = request.getParameter("eid");
		CompraDAO cd = DAOFactory.getFactory().getCompraDAO();
		List<Compra> list = cd.listarCompras(Integer.parseInt(eid));
		request.setAttribute("req", list);
		System.out.println(eid+list.get(0).getEstado());
		if(list != null && bandera != null) {
			int d = Integer.parseInt(bandera);
			request.setAttribute("req", list);
			if(d == 2) {
				System.out.println("aprueba Pedido --->"+cabecera);
				Compra c = cd.read(Integer.parseInt(cabecera));
				c.setEstado("A");
				cd.update(c);
				
			}
			if(d == 1) {
				System.out.println("Rechaza Pedido --->"+cabecera);
				Compra c = cd.read(Integer.parseInt(cabecera));
				c.setEstado("R");
				cd.update(c);
			}
		}
		getServletContext().getRequestDispatcher("/JPSs/Pedidos.jsp?eid="+eid).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("dddddddddddddd");
	}

}
