<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<title>loginjsp</title>
</head>
<body>
	<%@page import="java.sql.*"%>
	<%@page import="javax.sql.*" %>
	<%
		String userid=request.getParameter("usr");
		session.putValue("userid",userid);
		String pwd=request.getParameter("pwd");
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("select * from acesso where Login='"+userid+"'");
		ResultSet rsAtivo=null;
		
		boolean ativo = false;	
		int id = 0;
 		
		if(rs.next()){				
			if(rs.getString("Senha").equals(pwd)){
				
				id = rs.getInt("Id");
				
				rsAtivo=st.executeQuery("select Ativo from pacientes where Id = " + id);
				
				while(rsAtivo.next())
					ativo = rsAtivo.getBoolean("Ativo");
				
				if(ativo != true)
		 			out.println("Usuário Inativo");
		 		else {
		 			session.setAttribute("id", id);
				    out.println("<div id='signup-form'>");
				    out.println("<div id='signup-inner'>");
				    out.println("<div class='clearfix' id='header'>");
				    out.println("<img id='signup-icon' src='./images/signup.png' alt='' />");
				    out.println("<h1> Bem Vindo, "+userid+" </h1>");
				    out.println("</div>");
				    out.println("<p>Sistema Logado<p>");
				    out.println("<form action='edit.jsp' method='post'>");
				    out.println("<a href='edit.jsp' class='btn'><i class='icon-white icon-heart'></i> Alterar</a>");			    
				    out.println("</form>");
				    out.println("</div>");
				    out.println("</div>");
				    out.println("</div>");
		 		}
			}else{
				out.println("Senha Inválida Tente Novamente.");
			}
		} else
			out.println("Usuário não cadastrado.");	
	%>
		<a href="index.html">Pagina Inicial</a>
</body>
</html>