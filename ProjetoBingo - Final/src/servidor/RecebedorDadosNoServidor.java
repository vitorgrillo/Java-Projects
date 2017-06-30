
package servidor;

import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * <h1>CLASSE RECEBEDOR DADOS</h1>
 * Classe RecebedorDadosNoServidor é responsável por controlar o recebimentos dos dados transmitidos entre o cliente e o servidor via sockets. 
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class RecebedorDadosNoServidor extends Thread{
    private ObjectInputStream leitorObjetos;
    private ComunicaChamante servidor;
    public RecebedorDadosNoServidor(InputStream streamObjetos, ComunicaChamante servidor)throws Exception{
        leitorObjetos = new ObjectInputStream(streamObjetos);
        this.servidor = servidor;
        this.start();
    }

    @Override
    public void run() {
        boolean deveParar = false;
        while(!deveParar){
            try {
                Object o = leitorObjetos.readObject();
                servidor.comunicar(o);
            } catch (Exception ex) {
                deveParar = true;
                System.out.println("Conexao perdida com o cliente, encerrando thread");
            }
        }
    }
    
    
}
