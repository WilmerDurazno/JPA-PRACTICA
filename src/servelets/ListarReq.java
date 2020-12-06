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
 * Servlet implementation class ListarReq
 */
@WebServlet("/ListarReq")
public class ListarReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String eid = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		eid = request.getParameter("eid");
		System.out.println("ListarReqsGET--->"+eid);
		CompraDAO cd = DAOFactory.getFactory().getCompraDAO();
		List<Compra> lista = cd.listarCompras(Integer.parseInt(eid));
		System.out.println("Listar rEQ:---->"+lista.size());
		request.setAttribute("requisitos", lista);
		getServletContext().getRequestDispatcher("/JPSs/ListarRequisitos.jsp?eid="+eid).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
