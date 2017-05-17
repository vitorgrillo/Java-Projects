package projetolabirinto;

/**Classe construtora para objetos do tipo Percorrer Labirinto, onde serão contidos, valores e métodos para o mesmo.
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class PercorrerLabirinto {

	private Labirinto labirinto;
	private Coordenada atual;
	private Pilha<Coordenada> caminho;
	private Pilha<Fila<Coordenada>> possibilidades;

    /**
     * Método cujo qual tem a função de receber a instância do Objeto do tipo l (Labirinto) ao qual percorremos a matriz de posições contendo paredes e caminho.
     *  @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     * @param  l é o valor correspondente a matriz de elementos do programa, onde se contém as linhas colunas e coordenadas do projeto.
     */
	public PercorrerLabirinto(Labirinto l) throws Exception{
		this.labirinto = l;

		int linhas = labirinto.getPosicoes().length;
		int colunas = labirinto.getPosicoes()[0].length;
		this.caminho = new Pilha<Coordenada>(linhas*colunas);
		this.possibilidades = new Pilha<Fila<Coordenada>>(linhas*colunas);
		this.atual = this.labirinto.getEntrada();

	}
	
    /**
     * Método cujo qual tem a função de percorrer a instância do Objeto do tipo l (Labirinto) verificando por duas formas diferentes (Progressiva e Regressiva).
     *  @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     *  @return Após percorrer a instância do Objeto retornamos a função main a Matriz com o resultado final de entrada e saida se possivel pelo labirinto.
     **/
	public Labirinto percorreLabirinto() throws Exception{

		do{
			
			//Progressivo
			while(haProgressivo(this.atual)){
				Fila<Coordenada> jogadas = jogadasValidas(this.atual);
				this.atual.setElemento(Character.valueOf('*'));
				this.caminho.empilhar(this.atual);

				this.atual = jogadas.desenfileirar();
				this.possibilidades.empilhar(jogadas);
				
			}
			this.atual.setElemento('*');
			
			//Regressivo
			if(!(this.atual.linha == this.labirinto.getSaida().linha && this.atual.coluna == this.labirinto.getSaida().coluna)){
				Coordenada entrada = this.labirinto.getEntrada();
				Fila<Coordenada> jogadas = null;
				if(!possibilidades.vazia()){
					jogadas = possibilidades.exibeUltimoValor();
				}
					
				
				while (!possibilidades.vazia() && jogadas != null && jogadas.vazia()
						&& !this.atual.equals(entrada)) {
					Coordenada coordenada = this.caminho.desempilhar();
					this.labirinto.getPosicoes()[coordenada.linha][coordenada.coluna].setElemento(' ');
					this.possibilidades.desempilhar();
					jogadas= possibilidades.exibeUltimoValor();
				}

				if (!possibilidades.vazia() && !jogadas.vazia()) {
					this.atual.setElemento(' ');
					this.atual = jogadas.desenfileirar();
				}
			}
			
		}while(!(this.atual.equals(this.labirinto.getSaida())) && !(this.atual.equals(this.labirinto.getEntrada())));
		
		if(this.atual.equals(this.labirinto.getEntrada()))
			throw new Exception("O labirinto nao possui solucao");
		
		return this.labirinto;
	}
	
    /**
     * Método cujo qual tem a função de Verificar se a jogada é Progressiva e valida.
     *  @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     *  @return Possivel Válida vazia possivel para ser percorrida pelo jogador.
     **/
	private boolean haProgressivo(Coordenada c) throws Exception{
	
		Fila<Coordenada> jogadas = this.jogadasValidas(c);
		return !jogadas.vazia();
		
	}
	
    /**
     * Método cujo qual tem a função de Verificar se a jogada é válida.
     *  @param Coordenada c Passagem das coordenadas para verificação do caminho final percorrido.
     *  @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     *  @return Saida do Labirinto ou Coordenadas a serem enfileiradas referentes as possições percorridas.
     **/
	private Fila<Coordenada> jogadasValidas(Coordenada c) throws Exception{

		Coordenada[][] posicoes = labirinto.getPosicoes();
		Fila<Coordenada> retorno = new Fila<Coordenada>(3);

		if(c.equals(labirinto.getSaida())){
			return retorno;
		}
		
		//cima
		if(c.linha > 0){
			if(posicoes[c.linha-1][c.coluna].getElemento() == ' ' || posicoes[c.linha-1][c.coluna].getElemento() == 'S')
				retorno.enfileirar(posicoes[c.linha-1][c.coluna]);
		}

		//baixo
		if(c.linha < posicoes.length){
			if(posicoes[c.linha+1][c.coluna].getElemento() == ' ' || posicoes[c.linha+1][c.coluna].getElemento() == 'S')
				retorno.enfileirar(posicoes[c.linha+1][c.coluna]);
		}

		//esquerda
		if(c.coluna > 0){
			if(posicoes[c.linha][c.coluna-1].getElemento() == ' ' || posicoes[c.linha][c.coluna-1].getElemento() == 'S')
				retorno.enfileirar(posicoes[c.linha][c.coluna-1]);
		}

		//direita
		if(c.coluna < posicoes[0].length){
			if(posicoes[c.linha][c.coluna+1].getElemento() == ' ' || posicoes[c.linha][c.coluna+1].getElemento() == 'S')
				retorno.enfileirar(posicoes[c.linha][c.coluna+1]);
		}

		return retorno;
	}
}
