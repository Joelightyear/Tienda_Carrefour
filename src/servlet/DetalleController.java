package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.MysqlConnect;


@WebServlet("/DetalleController")
public class DetalleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public DetalleController() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MysqlConnect c = MysqlConnect.getDbCon();
		ResultSet rs = null;
		String id = request.getParameter("id");
		
		try {
			rs=c.query("SELECT * FROM producto WHERE id='"+id+"'");
			request.setAttribute("detalle", rs);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("html/detalle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
