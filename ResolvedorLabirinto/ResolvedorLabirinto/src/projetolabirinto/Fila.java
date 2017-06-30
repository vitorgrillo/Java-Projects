package projetolabirinto;

/**Classe construtora dos m�todos da fila utilizando as boas pr�ticas requisitadas para o projeto.
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class Fila <T>{
    
    private Object[] fila;
    private int topo;
    
    /**
     * M�todo cujo qual tem a fun��o de instanciar os objetos do tipo capacidade.
     * @param capacidade Capacidade � o valor inteiro m�ximo a ser utilizado pelo vetor de coordenadas.
     * @throws Exception alguns dos valores s�o inv�lidos ou n�o correspondem ao esperado pela fun��o.
     */
    public Fila(int capacidade) throws Exception {
        this.fila = new Object[capacidade];
        this.topo = -1;
    }
    
    /**
     * M�todo cujo qual tem como principal  fun�ao verificar se o objeto fila se encontra vazio ou n�o.
     * @return Caso a fila seja negativa o valor true indicar� que ela est� vazia, sen�o a mesma retorna false indicando que possui elementos.
     */
    public boolean vazia() {
        if (this.topo == -1) {
            return true;
        }
        return false;
    }
 
    /**
     * M�todo cujo qual tem como principal  fun�ao verificar o tamanho da Fila (Lista de Elementos).
     * @return retorna o fim da fila caso ela n�o seja vazia, se for vazia ir� retornar que a fila n�o possui elementos com o valor "0".
     */
    public int tamanhoLista() {
        if (this.vazia()) {
            return 0;
        }
        return this.topo + 1;
    }

    /**
     * M�todo cujo qual tem como retorno da fun�ao a coordenada que se encontra no fim da fila.
     * @return A fun��o visa retornar os valores de coordenadas enfileirados pela function enfileirar().
     */
    public T exibeUltimoValor() {
        if (this.vazia()) {
            return null;
        }
        return (T)this.fila[0];
    }

    /**
     * M�todo cujo qual tem como principal  fun�ao remover elementos do fim da Fila.
     * @throws Exception alguns dos valores s�o inv�lidos ou n�o correspondem ao esperado pela fun��o.
     * @return retorna o �ltimo elemento da fila.
     */
    public T desenfileirar() throws Exception {
        T retorno = null;
    	
    	if (vazia()) {
            throw new Exception("Não existe mais item para desenfileirar");
        }
    	
    	retorno = (T) this.fila[0];
       
        for(int i = 1; i < this.fila.length; i++){
        	this.fila[i-1] = this.fila[i];
        }
        
        fila[topo--] = null;
        
        return retorno;
        
    }

    /**
     * M�todo cujo qual tem como principal  fun�ao adicionar elementos ao inicio da Fila.
     * @param valor referente ao �ltimo elemento da fila.
     * @throws Exception alguns dos valores s�o inv�lidos ou n�o correspondem ao esperado pela fun��o.
     */
    public void enfileirar(T valor) throws Exception {
        if (topo == fila.length - 1) {
            throw new Exception("Não existe mais espaço");
        }
        this.fila[++topo] = valor;
    }
    
    /**
     * M�todo cujo qual tem como as boas pr�ticas de programa��o apresentados em aula.
     * @return String contendo os elementos da fila utilizados.
     */
    @Override
    public String toString() {
        String ret = "";

        ret += (this.topo + 1) + " elementos";

        if (this.topo > -1) {
            ret += " (Ultimo: " + this.fila[this.topo];
            ret += ")";
        }

        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Fila<T> f = (Fila<T>) obj;

        if (this.topo != f.topo) {
            return false;
        }

        for (int i = 0; i <= this.topo; i++) {
            if (!this.fila[i].equals(f.fila[i])) {
                return false;
            }
        }

        return true;
    }
    
    /**
     * M�todo cujo qual tem como as boas pr�ticas de programa��o apresentados em aula.
     */
    @Override
    public int hashCode() {
        int ret = 777;

        ret = 7 * ret + new Integer(this.topo).hashCode();

        for (int i = 0; i <= this.topo; i++) {
            ret = 13 * ret + this.fila[i].hashCode();
        }

        return ret;
    }

}

    
    

