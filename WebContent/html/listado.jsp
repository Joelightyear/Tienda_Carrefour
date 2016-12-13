<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado</title>
</head>
<body>

	<div class="container text-center">

		<div class="row">
		<p>Bienvenido <%= request.getSession().getAttribute("cliente") %></p>

			<%
				ResultSet rs = (ResultSet) (request.getAttribute("producto"));
				while (rs.next()) {
				int id = rs.getInt("id");
			%>


			<div class="col-sm-4">


				<p>
					<%=rs.getString("nombre")%></p>
				<p>
					<%=rs.getString("precio")%></p>


				<a href="DetalleController?id=<%=id%>"> <img width="200"
					src="img/<%=rs.getString("imagen")%>">
				</a>

			</div>
			<%
				}
			%>
		</div>
	</div>


</body>
</html>