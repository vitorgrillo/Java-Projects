
package projetolabirinto;

/**Classe construtora para objetos do tipo Labirinto, onde serão contidos, valores e métodos para o mesmo.
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class Coordenada {
    
    public int linha, coluna;
    private Character elemento;
    
    /**
     * Método cujo qual tem a função de receber as linhas, colunas e elementos da matriz e verificar qual o atual elemento que possuimos dentro da atual coordenada.
     * @param  linha é o valor correspondente ao inteiro referente a coordenada X da matriz.
     * @param  coluna  é o valor correspondente ao inteiro referente a coordenada Y da matriz.
     * @param elemento é o valor correspondente ao caracter "*" ou " " ou "#" da matriz.
     */
    public Coordenada(int linha, int coluna, Character elemento){
        this.linha = linha;
        this.coluna = coluna;
        this.elemento = elemento;
    }
    
    /**
     * Método cujo qual tem a função de atribuir o atual elemento para a atual coordenada da nossa matriz.
     * @param elemento é o valor correspondente ao caracter "*" ou " " ou "#" da matriz.
     */
    public void setElemento(Character elemento){
        this.elemento = elemento;
    }
    
    /**
     * Método cujo qual tem a função de receber o atual elemento da atual coordenada de nossa matriz.
     * @return é o valor correspondente ao caracter "*" ou " " ou "#" da matriz.
     */
    public Character getElemento(){
        return this.elemento;
    }
    
 }
