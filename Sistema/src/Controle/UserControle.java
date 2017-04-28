/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.User;
import Modelo.UserBanco;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author VitorEmanuel
 */
public class UserControle {
    public void cadastrarUser(User U)throws SQLException, ClassNotFoundException{
        UserBanco.cadastrar(U);
    }
    
    public User consultarUser(String U)throws SQLException,ClassNotFoundException{
        User user;
        System.out.println(U + "2");
        user = UserBanco.consultar(U);
        
        System.out.println(user.getCpf());
        return user;
    }
    
     public void atualizarUser(User U)throws SQLException, ClassNotFoundException{
        UserBanco.atualizar(U);
    }
      public void excluirUser(User U)throws SQLException, ClassNotFoundException{
        UserBanco.excluir(U);
    }
}
