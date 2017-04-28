<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
	<meta charset="utf-8"/>
	<title>Painel Paciente</title>
	
	<link rel="stylesheet" href="assets/css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="assets/css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="assets/js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="assets/js/hideshow.js" type="text/javascript"></script>
	<script src="assets/js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="assets/js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});
    </script>
    <script type="text/javascript">
	    $(function(){
	        $('.column').equalHeight();
	    });
	</script>

</head>
<body>
 	
	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.html">Medical Clinic Puccamp </a></h1>
			<h2 class="section_title">Painel Pacientes</h2><div class="btn_view_site"><a href="admin.jsp">Home</a></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
		<!-- To Do Dynamic User Name -->
			<p> <% out.println(session.getAttribute("usr").toString());	%> </p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"> <a href="admin.jsp"> Medical Clinic </a> <div class="breadcrumb_divider"></div> <a class="current">Alterar Dados Usu�rio</a></article> 
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<form class="quick_search">
			<input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr/>
		<h3>Consultas</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="consult.jsp">Marcar Consulta</a></li>
			<li class="icn_categories"><a href="#">Listar Consultas Marcadas</a></li>
		</ul>
		<h3>Paciente</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="edit.jsp">Atualizar Dados Paciente</a></li>
			<li class="icn_view_users"><a href="exclude-initial.jsp">Excluir Dados Paciente</a></li>
			<li class="icn_profile"><a href="perfil.jsp">Seu Perfil</a></li>
		</ul>
		<h3>Administrativo</h3>
		<ul class="toggle">
			<li class="icn_jump_back"><a href="index.html">Logout</a></li>
		</ul>
		
		<footer>
			<hr />
			<p><strong>Copyright &copy; 2015 Vitor Grillo - Admin Theme</strong></p>
			<p>Theme by <a href="http://www.vitorgrillo.com.br">Vitor Grillo</a></p>
		</footer>
	</aside><!-- end of sidebar -->

<article class="module width_full">
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
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clinica","root","1234");
				Statement st = con.createStatement();
				ResultSet rs;
					int i=st.executeUpdate("update pacientes SET Nome='"+name+"',"+"Sobrenome='"+lastName+"',"+"Email='"+Email+"',"+"CEP='"+CEP+"',"+"Numero='"+number+"',"+"Complemento='"+complement+"' where Id = '" + session.getAttribute("id")+"'" );
					out.println("Usu�rio e Senha Alterado Com Sucesso");
			}catch(Exception e){
				out.println(e.toString());
			}
				
			%>
			<header>
				<h2>Dados Atualizados Com Sucesso!</h2>
			</header>
			
				<footer>
					<div class="submit_link">
						<form action="admin.jsp" method="post">
							<input type="submit" value="Voltar" >
						</form>
					</div>
				</footer>
</article><!-- end of post new article -->

</body>
</html>
