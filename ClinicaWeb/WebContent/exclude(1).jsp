<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
<title>EditJsp</title>
</head>
<body>	
	<%@page import = "java.sql.*" %>
	<%@page import = "javax.sql.*" %>
	<%
	try{
		String CPF=request.getParameter("cpf");
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		Statement st = con.createStatement();
		ResultSet rs;
		int i=st.executeUpdate("UPDATE pacientes SET Ativo = 0 WHERE Id='" + session.getAttribute("id")+ "'");
        	
			out.println("<div id='signup-form'>");
			out.println("<div id='signup-inner'>");
			out.println("<div class='clearfix' id='header'>");
         	out.println("<h1>Excluir Conta</h1>");
            out.println("</div>");    

            out.println("<p>Conta excluída com sucesso.</p>");	

            out.println("</div>");
            out.println("</div>");         

	}catch(Exception e){
		out.println(e.toString());
	}
		
	%>

	<a href="index.html" class="btn"><i class="icon-white icon-heart"></i> Página Inicial</a>
</body>
</html>