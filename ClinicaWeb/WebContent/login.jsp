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
		String userid = request.getParameter("usr");
		
		String pwd=request.getParameter("pwd");
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clinica","root","1234");
		Statement st=con.createStatement();
				
		ResultSet rs=st.executeQuery("select * from acesso where Login='"+userid+"'");
		ResultSet rsAtivo=null;
		
		int ativo = 0;	
		int id = 0;
 		
		if(rs.next()){				
			if(rs.getString("Senha").equals(pwd)){
				
				id = rs.getInt("Id");
							
				ativo = rs.getInt("Ativo");
				
				if(ativo != 1){
					
					
					out.println("<table>");
					out.println("<tr>");	
					out.println("<td>");
					out.println("<div class='module_content'>");
					out.println("<h2 class='welcome-title'>"); 
					out.println("Usuário Inátivo !"); 
					out.println("</h2>");
					out.println("<form action='index.html' method='post' >");
					out.println("<input type='submit' value='Home'> ");
					out.println("</form>");
					out.println("</div>");
					out.println("</td>");
					out.println("</tr>");
					out.println("</table>");
				}	
		 		else {
		 			
		 			session.setAttribute("id", id);
		 			session.setAttribute("usr",userid);
		 			response.sendRedirect("admin.jsp");
		 			

		 		}
			}else{
				out.println("<table>");
				out.println("<tr>");	
				out.println("<td>");
				out.println("<div class='module_content'>");
				out.println("<h2 class='welcome-title'>"); 
				out.println("Senha Inválida !"); 
				out.println("</h2>");
				out.println("<form action='index.html' method='post' >");
				out.println("<input type='submit' value='Home'> ");
				out.println("</form>");
				out.println("</div>");
				out.println("</td>");
				out.println("</tr>");
				out.println("</table>");
			}
		} else{
			out.println("<table>");
			out.println("<tr>");	
			out.println("<td>");
			out.println("<div class='module_content'>");
			out.println("<h2 class='welcome-title'>"); 
			out.println("Usuário Não Cadastrado !"); 
			out.println("</h2>");
			out.println("<form action='index.html' method='post' >");
			out.println("<input type='submit' value='Home'> ");
			out.println("</form>");
			out.println("</div>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</form>");
			out.println("</table>");
			
		}
	%>
</body>
</html>