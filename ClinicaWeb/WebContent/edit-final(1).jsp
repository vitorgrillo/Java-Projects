<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EditJsp</title>
</head>
<body>	
	<%@page import = "java.sql.*" %>
	<%@page import = "javax.sql.*" %>
	<%
	try{
		String name=request.getParameter("nome");
		String lastName=request.getParameter("sobrenome");
		String Email=request.getParameter("email");
		String CEP=request.getParameter("cep");
		String number=request.getParameter("numero");
		String complement=request.getParameter("complemento");
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		Statement st = con.createStatement();
		ResultSet rs;
			int i=st.executeUpdate("update pacientes SET Nome='"+name+"',"+"Sobrenome='"+lastName+"',"+"Email='"+Email+"',"+"CEP='"+CEP+"',"+"Numero='"+number+"',"+"Complemento='"+complement+"' where Id = '" + session.getAttribute("id")+"'" );
			out.println("Usuário e Senha Alterado Com Sucesso");
	}catch(Exception e){
		out.println(e.toString());
	}
		
	%>
	<a href="index.html">Login</a></hr></br/>
	<a href="index.html">Página Inicial</a>
</body>
</html>