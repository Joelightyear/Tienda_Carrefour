<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.sql.ResultSet"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalle</title>
</head>
<body>
<% ResultSet rs= (ResultSet) (request.getAttribute("detalle")); 
if(rs.next()){
%>
	<div class="container">
		<div class="row text-center">
			<div class="col-sm-12">
			
			<p><%=rs.getString("nombre")%></p>
			<p><%=rs.getString("precio")%></p>
			<p><%=rs.getString("descripcion")%></p>
			<img width="200" src="img/<%=rs.getString("imagen")%>"><br>
			<a href="PedidoController?id_producto=<%=rs.getString("id") %>"><input name="cesta" type="submit" value="Añadir a la cesta"></a>
			
	
			</div>
		</div>

	</div>
	<% } %>
</body>
</html>