<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegJsp</title>
</head>
<body>	
	<%@page import = "java.sql.*" %>
	<%@page import = "javax.sql.*" %>
	<%
		String login = request.getParameter("login");
		//session.putValue("login",user);
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("nome");
		String lastName=request.getParameter("sobrenome");
		String Email=request.getParameter("email");
		String CEP=request.getParameter("cep");
		String Number=request.getParameter("numero");
		String complement=request.getParameter("complemento");
		String sqlCmd;
		
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clinica","root","1234");		
		Statement st = con.createStatement();
		
		ResultSet rs;
		int i = st.executeUpdate("insert into acesso values(null,'"+login+"','"+pwd+"', 1)");
		
		sqlCmd = "INSERT INTO pacientes values(null,'"+name+"','"+lastName+"','"+Email+"',"+CEP+","+Number+",'"+complement+"');";
				 
		i = st.executeUpdate(sqlCmd);
		 
		
		out.println("Cadastrado");
	%>
	<a href="index.html">Login</a>
	<a href="index.html">Página Inicial</a>
</body>
</html>	