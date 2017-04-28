<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
<title>ListJsp</title>
</head>
<body>	            
	<%@page import = "java.sql.*" %>
	<%@page import = "javax.sql.*" %>
	<%
	try{
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM pacientes");
		out.println("<div class='CSSTableGenerator' >");
        out.println("<table >");
        out.println("<tr>");
        out.println("<td>ID</td>");
        out.println("<td>Nome</td>");
        out.println("<td>Sobrenome</td>");
        out.println("<td>Email</td>");
        out.println("<td>RG</td>");
        out.println("<td>CPF</td>");
        out.println("<td>CEP</td>");
        out.println("<td>Numero</td>");
        out.println("<td>Complemento</td>");
        out.println("</tr>");

		
		while(rs.next()){
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getString(7)+"</td>");
				out.println("<td>"+rs.getString(8)+"</td>");
				out.println("<td>"+rs.getString(9)+"</td>");
				out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</div>");
		
	}catch(Exception e){
		out.println(e.toString());
	}
	%>
	<br>
	<br>
	<br>
	<a href="index.html" class="btn"><i class="icon-white icon-heart"></i> Página Inicial</a>
</body>
</html>	