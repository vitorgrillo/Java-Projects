package projetolabirinto;

/**Classe construtora para objetos do tipo Percorrer Labirinto, onde ser�o contidos, valores e m�todos para o mesmo.
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
     * M�todo cujo qual tem a fun��o de receber a inst�ncia do Objeto do tipo l (Labirinto) ao qual percorremos a matriz de posi��es contendo paredes e caminho.
     *  @throws Exception alguns dos valores s�o inv�lidos ou n�o correspondem ao esperado pela fun��o.
     * @param  l � o valor correspondente a matriz de elementos do programa, onde se cont�m as linhas colunas e coordenadas do projeto.
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
     * M�todo cujo qual tem a fun��o de percorrer a inst�ncia do Objeto do tipo l (Labirinto) verificando por duas formas diferentes (Progressiva e Regressiva).
     *  @throws Exception alguns dos valores s�o inv�lidos ou n�o correspondem ao esperado pela fun��o.
     *  @return Ap�s percorrer a inst�ncia do Objeto retornamos a fun��o main a Matriz com o resultado final de entrada e saida se possivel pelo labirinto.
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
     * M�todo cujo qual tem a fun��o de Verificar se a jogada � Progressiva e valida.
     *  @throws Exception alguns dos valores s�o inv�lidos ou n�o correspondem ao esperado pela fun��o.
     *  @return Possivel V�lida vazia possivel para ser percorrida pelo jogador.
     **/
	private boolean haProgressivo(Coordenada c) throws Exception{
	
		Fila<Coordenada> jogadas = this.jogadasValidas(c);
		return !jogadas.vazia();
		
	}
	
    /**
     * M�todo cujo qual tem a fun��o de Verificar se a jogada � v�lida.
     *  @param Coordenada c Passagem das coordenadas para verifica��o do caminho final percorrido.
     *  @throws Exception alguns dos valores s�o inv�lidos ou n�o correspondem ao esperado pela fun��o.
     *  @return Saida do Labirinto ou Coordenadas a serem enfileiradas referentes as possi��es percorridas.
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
