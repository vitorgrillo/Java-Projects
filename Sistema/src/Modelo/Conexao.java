/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author VitorEmanuel
 */
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema?zeroDateTimeBehavior=convertToNull";
    private static final String USUARIO = "root";
    private static final String SENHA = "12345";
    
    public static Connection conectar() throws SQLException {
        try{
            return DriverManager.getConnection(URL,USUARIO,SENHA);
        }catch(SQLException se){
            throw new SQLException("ERRO AO CONECTAR NO BANCO DE DADOS: " + se.getMessage());
        }
    } 
}
