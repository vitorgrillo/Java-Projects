
package projetolabirinto;

/**Classe construtora para objetos do tipo ValidadorLabirito, onde serão contidos, valores e métodos para o mesmo.
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class ValidadorLabirinto {  
	
    /**
     * Função cuja qual realiza a chamada para a verificação das "Paredes do sistema" e das "Posições Percorridas" via coordenadas fornecidas.
     * @param labirinto Coordenadas necessárias para a verificação.
     * @throws Exception Quando as coordenadas retornam elementos inválidos.
     */
    public static void validaLabirinto(Coordenada[][] labirinto) throws Exception{
        verificaBorda(labirinto);
        verificaInterior(labirinto);
    }
    
    /**
     * Função cuja qual realiza a verificação das "Paredes do sistema" via coordenadas fornecidas.
     * @param labirinto Coordenadas necessárias para a verificação.
     * @throws Exception Quando as coordenadas retornam elementos inválidos.
     */
    private static void verificaBorda(Coordenada[][] labirinto)throws Exception{
    
    	int countLinhas = labirinto.length;
    	int countColunas = labirinto[0].length;
    	int entradas = 0;
    	int saidas = 0;
    	
    	/**
         * Verificação se possui posição livre para cima (Ao Norte).
         */
    	for(int i = 0; i < countColunas; i++){
    		Character c = labirinto[0][i].getElemento();
    		if(c != 'E' && c != 'S' && c != '#')
    			throw new Exception("Há elementos invalidos no labirinto");
    		if(c == 'E')
    			entradas++;
    		if(c == 'S')
    			saidas++;
    	}
    	
    	/**
         * Verificação se possui posição livre para baixo (Ao Sul).
         */
    	for(int i = 0; i < countColunas; i++){
    		Character c = labirinto[countLinhas-1][i].getElemento();
    		
    		if(c != 'E' && c != 'S' && c != '#')
    			throw new Exception("Há elementos invalidos no labirinto");
    		if(c == 'E')
    			entradas++;
    		if(c == 'S')
    			saidas++;
    	}
    	
    	/**
         * Verificação se possui posição livre para esquerda (Ao Leste).
         */
    	for(int i = 0; i < countLinhas; i++){
    		
    		Character c = labirinto[i][0].getElemento();
    		
    		if(c != 'E' && c != 'S' && c != '#')
    			throw new Exception("Há elementos invalidos no labirinto");
    		if(c == 'E')
    			entradas++;
    		if(c == 'S')
    			saidas++;
    	}
    	
    	/**
         * Verificação se possui posição livre para direita (Ao Oeste).
         */
    	for(int i = 0; i < countLinhas; i++){
    		
    		Character c = labirinto[i][countColunas-1].getElemento();
    		
    		if(c != 'E' && c != 'S' && c != '#')
    			throw new Exception("Há elementos invalidos no labirinto");
    		if(c == 'E')
    			entradas++;
    		if(c == 'S')
    			saidas++;
    	}
    	
    	/**
         * Verifica quantidade de entradas/saidas é valida
         */
    	if(entradas != 1 || saidas != 1)
    		throw new Exception("Quantidade de entradas/saidas invalida");
    	
    }
    
    /**
     * Função cuja qual realiza a verificação das "Posições Percorridas" via coordenadas fornecidas.
     * @param labirinto Coordenadas necessárias para a verificação.
     * @throws Exception Quando as coordenadas retornam elementos inválidos.
     */
    private static void verificaInterior(Coordenada[][] labirinto) throws Exception{
    	
    	int countLinhas = labirinto.length-1;
    	int countColunas = labirinto[0].length-1;
    	
    	for(int i = 1; i < countLinhas; i++){
    		for(int j = 1; j < countColunas; j++){
    			Character c = labirinto[i][j].getElemento();
    			if(c != '#' && c != ' ')
    				throw new Exception("Ha elementos invalidos no interior do labirinto");
    		}
    	}
    	
    }
    
}
