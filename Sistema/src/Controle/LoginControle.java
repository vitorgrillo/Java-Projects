/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Login;
import Modelo.LoginBanco;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author VitorEmanuel
 */
public class LoginControle {
    public ArrayList<Login> buscarLoginSenha() throws SQLException,ClassNotFoundException{
        return LoginBanco.buscarLogin();
    }
}
