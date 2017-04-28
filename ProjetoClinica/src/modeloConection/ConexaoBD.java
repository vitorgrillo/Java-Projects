/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloConection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5437/ProjetoClinica";
    private String usuario = "postgres";
    private String senha = "wolf3d";
    public Connection con;
    
    
    public void conexao(){
    System.setProperty("jdbc.Drivers", driver);
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Banco Conectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão do banco de dados:\n" + ex.getMessage());
        }
    
    }
    
    public void executaSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro executa SQL:\n" + ex.getMessage());
        }
    
    }
    
    public void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar banco de dados:\n" + ex.getMessage());
        }
    }
}
