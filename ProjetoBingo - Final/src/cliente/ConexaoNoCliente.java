
package cliente;

import java.io.ObjectOutputStream;
import java.net.Socket;
import servidor.ComunicaChamante;

/**
 * <h1>CLASSE CONEXÃO NO CLIENTE</h1>
 * Classe ConexãoNoCliente é responsável por iniciar uma conexão do usuario com a sala que deseja-se iniciar o jogo.
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class ConexaoNoCliente{
    private ObjectOutputStream writerObjetos;
    
    public ConexaoNoCliente(String ip, int porta, ComunicaChamante chamante)throws Exception{
        Socket conexao = new Socket(ip, porta);
        this.writerObjetos = new ObjectOutputStream(conexao.getOutputStream());
        System.out.println("Cliente conectado no servidor da porta " + porta);
        new RecebedorDadosNoCliente(conexao.getInputStream(), chamante);
    }

    public ObjectOutputStream getWriterObjetos() {
        return writerObjetos;
    }
      
}
