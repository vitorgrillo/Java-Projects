

package servidor;

/**
 * <h1>CLASSE INICIA SERVIDOR</h1>
 * Classe StartServidor é responsável por iniciar a conexão com o servidor. 
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class StartServidor {
    public static void main(String[] args){
        try {
            Servidor servidor = new Servidor(2300);
            servidor.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
