/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <h1>CLASSE CONEXAO SERVIDOR </h1>
 * Classe ConexaoNoServidor é responsável por realizar a conexão do usuário com o servidor via socket. 
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class ConexaoNoServidor{
    private final Socket conexao;
    private final ObjectOutputStream writerObjetos;
    public ConexaoNoServidor(Socket conexao, ComunicaChamante servidor) throws Exception{
        this.conexao = conexao;
        this.writerObjetos = new ObjectOutputStream(this.conexao.getOutputStream());
        new RecebedorDadosNoServidor(this.conexao.getInputStream(), servidor);
    }

    public ObjectOutputStream getWriterObjetos() {
        return writerObjetos;
    }
}
