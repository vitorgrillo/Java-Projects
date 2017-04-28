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
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM pacientes WHERE Id='"+session.getAttribute("id")+"' ");
        String nome="Error", sobrenome="Error", email="Error", cep="Error", numero="Error", complemento="Error";        
		
			out.println("<div id='signup-form'>");
			out.println("<div id='signup-inner'>");
			out.println("<div class='clearfix' id='header'>");
         	out.println("<h1>Editar Paciente</h1>");
            out.println("</div>");    
			
            while(rs.next()) {
            	nome = rs.getString("Nome");
            	sobrenome = rs.getString("Sobrenome");
            	email = rs.getString("Email");
            	cep = rs.getString("CEP");
            	numero = rs.getString("Numero");
            	complemento = rs.getString("Complemento");
            }
            
            out.println("<p>Por favor, preencha os campos abaixo.</p>");	
            out.println("<form name=\"edit\" id=\"edit\" method='post'>");
            out.println("<p>"); 
            out.println("<label for='nome'>Nome *</label>");
            out.println("<input id='nome' type='text' name='nome' value='"+ nome +"' />");
            out.println("</p>");     
            out.println("<p>");
            out.println("<label for='sobrenome'>Sobrenome </label>");
            out.println("<input id='sobrenome' type='text' name='sobrenome' value='"+ sobrenome +"' />");
            out.println("</p>");
            
            out.println("<p>");
			out.println("<label for='email'>Email *</label>");
                
            out.println("<input id='email' type='text' name='email' value='"+ email +"' />"); 
            out.println("<p>");
                
            out.println("<p>");
            out.println("<label for='cep'>CEP</label>");
            out.println("<input id='cep' type='text' name='cep' value='"+ cep +"' />");
            out.println("</p>");
            
            out.println("<p><label for='numero'>Numero</label><input id='numero' type='text' name='numero' value='"+ numero +"' /></p>");
        
            out.println("<p><label for='complemento'>Complemento</label><input id='complemento' type='text' name='complemento' value='"+ complemento +"' /></p>");
            		
           	out.println("<p><button id='submit' onclick=\"btn1();\">Confirmar Alterações</button></p>");
           	out.println("<p><button id='exclude' onclick=\"btn2();\">Desativar Conta</button></p>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println(" <script type=\"text/javascript\">\n" +  
            				"function btn1() {\n" +
            					"document.edit.action=\"edit-final.jsp\";\n" +
            					"document.forms.edit.submit();\n" +
            				"}\n" +
            				"function btn2() {\n" +
            					"document.edit.action=\"exclude.jsp\";\n" +
            					"document.forms.edit.submit();\n" +
            				"}\n" +
            			"</script>\n");

	}catch(Exception e){
		out.println(e.toString());
	}
		
	%>

	<a href="index.html" class="btn"><i class="icon-white icon-heart"></i> Página Inicial</a>
</body>
</html>