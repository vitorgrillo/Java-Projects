
package projetolabirinto;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Classe construtora para objetos do tipo Labirinto, onde ser�o contidos, valores e m�todos para o mesmo.
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class Labirinto {
    
    private Coordenada[][] labirinto;
    private Coordenada entrada;
    private Coordenada saida;
    
    /**
     * M�todo cujo qual tem a fun��o de receber o arquivo contendo a Matriz principal do projeto.
     *  @throws Exception alguns dos valores s�o inv�lidos ou n�o correspondem ao esperado pela fun��o.
     * @param  nomeArquivo � o valor correspondente a principal matriz de elementos do programa, onde se cont�m as linhas colunas e coordenadas do projeto.
     */
    public Labirinto(String nomeArquivo)throws Exception{
        this.labirinto = lerArquivo(nomeArquivo);
    }
    
    /**
     * M�todo cujo qual tem a fun��o de receber a letra "E" referente a Entrada do Labirinto.
     * @return Retorno da Entrada do Labirinto � valida.
     */
    public Coordenada getEntrada(){
    	return this.entrada;
    }
    
    /**
     * M�todo cujo qual tem a fun��o de receber a letra "S" referente a Saida do Labirinto.
     * @return Retorno da Saida do Labirinto � valida.
     */
    public Coordenada getSaida(){
    	return this.saida;
    }
    
    /**
     * M�todo cujo qual tem a fun��o de receber os caracteres "#" e " " referente as posi��es do Labirinto.
     * @return Retorno das Posi��es do Labirinto s�o validas.
     */
    public Coordenada[][] getPosicoes(){
    	return this.labirinto;
    }
    
    /**
     * M�todo cujo qual tem a fun��o de realizar a leitura do arquivo txt afim de montar a matriz do labirinto.
     *  @param nomeArquivo Matriz de elementos a ser convertida para o Objeto labirinto do projeto.
     *  @throws Exception alguns dos valores s�o inv�lidos ou n�o correspondem ao esperado pela fun��o.
     * @return Retorno do objeto labirinto.
     */
    private Coordenada[][] lerArquivo(String nomeArquivo) throws Exception{   
    	
            int linha, coluna;
            char[][] elementosArquivo;
            File arquivo = new File(nomeArquivo);
            Scanner sc = new Scanner(arquivo);
            Coordenada[][] labirinto;
            
              
            linha=sc.nextInt();
            coluna=sc.nextInt();
            
            elementosArquivo = new char[linha][coluna];
            
            int count = 0;
            while (sc.hasNextLine()) {
                String line;
                line = sc.nextLine().toUpperCase();
                
                if(!line.equals("")){
                    elementosArquivo[count] = line.toCharArray();
                    count++;
                }
            }
            sc.close();
            
            labirinto = new Coordenada[linha][coluna];
            
            for(int i = 0; i < linha; i++){
                for(int j = 0; j < coluna; j++){
                    labirinto[i][j] = new Coordenada(i,j,Character.valueOf(elementosArquivo[i][j]));
                    if(labirinto[i][j].getElemento().equals('E'))
                    	this.entrada = labirinto[i][j];
                    if(labirinto[i][j].getElemento().equals('S'))
                    	this.saida = labirinto[i][j];
                }
            }
            
            ValidadorLabirinto.validaLabirinto(labirinto);
            
            return labirinto;
    
    }
    /**
     * M�todo cujo qual tem como as boas pr�ticas de programa��o apresentados em aula.
     * @return retorno das coordenadas do labirinto
     */
    @Override
    public String toString(){
    	String retorno = "";
    	for(int i = 0; i < this.labirinto.length; i++){
    		for(int j = 0; j < this.labirinto[i].length; j++){
    			retorno += this.labirinto[i][j].getElemento();
    		}
    		retorno += "\n";
    	}
    	
    	return retorno;
    }
    
    public boolean equals(){
    	
    	return false;
    }
    
    public int hashCode(){
    	
    	return 0;
    }
    
}