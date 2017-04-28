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

/**
 *
 * @author VitorEmanuel
 */
public class UserBanco {
    public static void cadastrar(User U) throws SQLException{
        try{
            Connection conexao = Conexao.conectar();
            Statement state = conexao.createStatement();
            String sql = "insert into user(nome,cpf,email,sexo,telefone,endereco,valor)values('"+U.getNome()+"', '"+U.getCpf()+"', '"+U.getEmail()+"', '"+U.getSexo()+"', '"+U.getTelefone()+"', '"+U.getEndereco()+"', '"+U.getValor()+"');";
            state.executeUpdate(sql);
            state.close();
            conexao.close();
        }catch(SQLException se){
            throw new SQLException("Erro ao cadastrar o usuário: " + se.getMessage());
        }   
    }
    
    public static User consultar(String U)throws SQLException{
        ResultSet rs;
        User user = null;
        System.out.println(U + "3");
        Connection conexao = Conexao.conectar();
        Statement state = conexao.createStatement();
        //String sql = "select * from user where nome = '"+U+"';";
        String sql = "select * from user;";
        rs = state.executeQuery(sql);
        while(rs.next())
        {
            if(rs.getString("nome").equals(U))
            {
                user.setCpf(rs.getString("cpf"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setEndereco(rs.getString("endereco"));
                user.setTelefone(rs.getString("telefone"));
                user.setSexo(rs.getString("sexo"));
                user.setValor(rs.getFloat("valor"));
            }
                
        }
        System.out.println(rs.getString("cpf"));
        return user; 
    }
    

    public static void excluir(User U) throws SQLException{
        try{
            Connection conexao = Conexao.conectar();
            Statement state = conexao.createStatement();
            String sql = "delete from user where nome='"+U.getNome()+"';";
            state.executeUpdate(sql);
            state.close();
            conexao.close();
        }catch(SQLException se){
            throw new SQLException("Erro ao excluir o usuário: " + se.getMessage());
        }   
    }

        public static void atualizar(User U) throws SQLException{
        try{
            Connection conexao = Conexao.conectar();
            Statement state = conexao.createStatement();
            String sql = "update user set nome='"+U.getNome()+"',cpf='"+U.getCpf()+"',email='"+U.getEmail()+"',sexo='"+U.getSexo()+"',telefone='"+U.getTelefone()+"',endereco='"+U.getEndereco()+"',valor='"+U.getValor()+"' where id="+U.getNome()+";";
            state.executeUpdate(sql);
            state.close();
            conexao.close();
        }catch(SQLException se){
            throw new SQLException("Erro ao atualizar o usuário: " + se.getMessage());
        }   
    }  
}
