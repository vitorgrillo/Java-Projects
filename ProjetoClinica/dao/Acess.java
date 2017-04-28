package dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.swing.JOptionPane;

public class Acess {
	
	public boolean acess;
	
	public void Acesso(String login, String senha) throws ClassNotFoundException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/clinica","root","1234");
			stmt = (Statement) con.createStatement();
			rs = ((java.sql.Statement) stmt).executeQuery("SELECT login, senha from acesso where login = '" + login + "'and senha='" + senha + "'");
			if(rs.next()){
				JOptionPane.showMessageDialog(null,"Usuário Logado Com Sucesso !");
				acess = true;
			}else{
				JOptionPane.showMessageDialog(null,"Usuário ou Senha Inválidos !");
				acess = false;
			}
		}catch(SQLException e){
			
		}
		
	}

}
