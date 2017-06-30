/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import servidor.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>CLASSE CONEXÃO NO CLIENTE</h1>
 * Classe RecebedorDadosNoCliente é responsável por cuidar dos dados trafegados entre cliente e servidor.
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class RecebedorDadosNoCliente extends Thread{
    private ObjectInputStream leitorObjetos;
    private ComunicaChamante cliente;
    public RecebedorDadosNoCliente(InputStream streamObjetos, ComunicaChamante cliente)throws Exception{
        leitorObjetos = new ObjectInputStream(streamObjetos);
        this.cliente = cliente;
        this.start();
    }

    @Override
    public void run() {
        boolean deveParar = false;
        while(!deveParar){
            try {
                Object o = leitorObjetos.readObject();
                cliente.comunicar(o);
            } catch (Exception ex) {
                deveParar = true;
                System.out.println("Conexao perdida com o servidor, encerrando conexao");
            }
        }
    }
    
    
}
