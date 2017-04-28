/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author VitorEmanuel
 */
public class LoginBanco {
    public static ArrayList<Login> buscarLogin() throws SQLException{
        ArrayList<Login> LAUX = new ArrayList<Login>();
        try{
            Connection conexao = Conexao.conectar();
            Statement state = conexao.createStatement();
            String sql = "select * from login";
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                Login l = new Login();
                l.setLogin(rs.getString("login"));
                l.setSenha(rs.getString("senha"));
                LAUX.add(l);
            }  
        }catch(SQLException se){
            throw new SQLException("Erro ao localizar os dados: "+ se.getMessage());
        }
     return LAUX; 
    }
}

