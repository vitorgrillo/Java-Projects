/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorgrillo.app.service;

import com.vitorgrillo.app.bean.ChatMessage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.portable.UnknownException;

/**
 *
 * @author Vitor Grillo
 */
public class ClienteService {
    
    private Socket socket;
    private ObjectOutputStream output;
    
    public Socket connect(){
   try{
        this.socket = new Socket("localhost", 5555);
        this.output = new ObjectOutputStream(socket.getOutputStream());
    }catch(UnknownException ex){
        Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE,null,ex);
    } catch (IOException ex){
        Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE,null,ex);
    }
        return socket;
 }
    
    public void send(ChatMessage message){
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class ServidorService {

        public ServidorService() {
        }
    }
}
