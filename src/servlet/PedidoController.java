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


@WebServlet("/PedidoController")
public class PedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PedidoController() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MysqlConnect c = MysqlConnect.getDbCon();
		ResultSet rs = null;
		String id_producto = null;
		String id_pedido = null;
		String id_cliente= (String) request.getSession().getAttribute("id_cliente");
		
		try {
			rs = c.query("SELECT * FROM pedido where confirmado = 0 AND id = '"+id_cliente+"'");

			id_producto = request.getParameter("id_producto");
			
			if (rs.next()) {
				id_pedido = rs.getString("id");

				c.insert("INSERT INTO `producto_pedido`(`id_pedido`, `id_producto`) VALUES ('"+id_pedido+"','"+id_producto+"')");
				
			} else {
				
				
				//creo la cesta
				c.insert("INSERT INTO `pedido`(`fecha_compra`, `confirmado`, `id_cliente`) VALUES (CURRENT_DATE,0,'"+id_cliente+"');");
				rs = c.query("SELECT * FROM pedido where confirmado = 0 AND id = '"+id_cliente+"'");
				if (rs.next()) {
					
					id_pedido = rs.getString("id");
					
					c.insert("INSERT INTO `producto_pedido`(`id_pedido`, `id_producto`) VALUES ('"+id_pedido+"','"+id_producto+"')");

				}
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
