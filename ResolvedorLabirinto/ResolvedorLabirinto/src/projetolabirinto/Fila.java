package projetolabirinto;

/**Classe construtora dos métodos da fila utilizando as boas práticas requisitadas para o projeto.
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class Fila <T>{
    
    private Object[] fila;
    private int topo;
    
    /**
     * Método cujo qual tem a função de instanciar os objetos do tipo capacidade.
     * @param capacidade Capacidade é o valor inteiro máximo a ser utilizado pelo vetor de coordenadas.
     * @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     */
    public Fila(int capacidade) throws Exception {
        this.fila = new Object[capacidade];
        this.topo = -1;
    }
    
    /**
     * Método cujo qual tem como principal  funçao verificar se o objeto fila se encontra vazio ou não.
     * @return Caso a fila seja negativa o valor true indicará que ela está vazia, senão a mesma retorna false indicando que possui elementos.
     */
    public boolean vazia() {
        if (this.topo == -1) {
            return true;
        }
        return false;
    }
 
    /**
     * Método cujo qual tem como principal  funçao verificar o tamanho da Fila (Lista de Elementos).
     * @return retorna o fim da fila caso ela não seja vazia, se for vazia irá retornar que a fila não possui elementos com o valor "0".
     */
    public int tamanhoLista() {
        if (this.vazia()) {
            return 0;
        }
        return this.topo + 1;
    }

    /**
     * Método cujo qual tem como retorno da funçao a coordenada que se encontra no fim da fila.
     * @return A função visa retornar os valores de coordenadas enfileirados pela function enfileirar().
     */
    public T exibeUltimoValor() {
        if (this.vazia()) {
            return null;
        }
        return (T)this.fila[0];
    }

    /**
     * Método cujo qual tem como principal  funçao remover elementos do fim da Fila.
     * @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     * @return retorna o último elemento da fila.
     */
    public T desenfileirar() throws Exception {
        T retorno = null;
    	
    	if (vazia()) {
            throw new Exception("NÃ£o existe mais item para desenfileirar");
        }
    	
    	retorno = (T) this.fila[0];
       
        for(int i = 1; i < this.fila.length; i++){
        	this.fila[i-1] = this.fila[i];
        }
        
        fila[topo--] = null;
        
        return retorno;
        
    }

    /**
     * Método cujo qual tem como principal  funçao adicionar elementos ao inicio da Fila.
     * @param valor referente ao último elemento da fila.
     * @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     */
    public void enfileirar(T valor) throws Exception {
        if (topo == fila.length - 1) {
            throw new Exception("NÃ£o existe mais espaÃ§o");
        }
        this.fila[++topo] = valor;
    }
    
    /**
     * Método cujo qual tem como as boas práticas de programação apresentados em aula.
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
     * Método cujo qual tem como as boas práticas de programação apresentados em aula.
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

    
    

