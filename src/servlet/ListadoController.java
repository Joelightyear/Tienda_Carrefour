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


@WebServlet("/ListadoController")
public class ListadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ListadoController() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MysqlConnect c = MysqlConnect.getDbCon();
		ResultSet rs = null;
		
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		
		try {
			rs = c.query("SELECT * FROM cliente ");
			if (rs.next()) {
				String id_cliente = rs.getString("id");
				request.getSession().setAttribute("id_cliente", id_cliente );				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			rs = c.query("SELECT * FROM cliente WHERE contrasena = '"+contrasena+"' AND usuario = '"+usuario+"'");
			
			request.getSession().setAttribute("cliente", usuario);
			
			if (rs.next()){
				rs = c.query("SELECT * FROM producto");
				request.setAttribute("producto", rs);
				request.getRequestDispatcher("html/listado.jsp").forward(request, response);
			}else{
				response.sendRedirect("index.jsp");
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
