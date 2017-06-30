
package projetolabirinto;
import java.util.Scanner;

/**Classe principal construtora do Projeto Labirinto.
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class ProjetoLabirinto {

    /**
     * M�todo cujo qual tem a fun��o de instanciar o Objeto do tipo l (Labirinto) ao qual receber� a matriz de posi��es contendo paredes e caminho.
     *  @throws Exception alguns dos valores s�o inv�lidos ou n�o correspondem ao esperado pela fun��o.
     * @param args � o valor correspondente a matriz de elementos do programa, onde se cont�m as linhas colunas e coordenadas percorridas do projeto.
     */
    public static void main(String[] args) throws Exception {
       
        try {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite o nome do arquivo .txt: ");
            Labirinto l = new Labirinto(entrada.nextLine());
            System.out.println(l);
        	PercorrerLabirinto p = new PercorrerLabirinto(l);
            System.out.println(p.percorreLabirinto());
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        
    }       
}

