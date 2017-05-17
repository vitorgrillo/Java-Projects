package projetolabirinto;

/**Classe construtora dos métodos da pilha utilizando as boas práticas requisitadas para o projeto.
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class Pilha<T> {

    private Object[] pilha;
    private int topo;
    
    /**
     * Método cujo qual tem a função de instanciar os objetos do tipo capacidade.
     * @param capacidade Capacidade é o valor inteiro máximo a ser utilizado pelo vetor de coordenadas.
     */
    public Pilha(int capacidade) {
        this.pilha = new Object[capacidade];
        this.topo = -1;
    }

    /**
     * Método cujo qual tem a função de empilhar as coordenadas.
     * @param x é correspondente ao valor da coordenada a ser empilhado no Objeto Pilha.
     * @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     */
    public void empilhar(T x) throws Exception {
        if (x == null) {
            throw new Exception("Valor a guardar ausente");
        }

        if (this.topo == this.pilha.length - 1) {
            throw new Exception("Nao cabe na pilha...");
        }

        this.topo++;
        this.pilha[this.topo] = x;
    }
    
    /**
     * Método cujo qual tem como retorno da funçao as coordenadas que se encontram no topo da pilha.
     * @return A função visa retornar os valores de coordenadas empilhados pela function Empilha().
     * @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     */
    public T exibeUltimoValor() throws Exception {
        if (this.topo == -1) {
            throw new Exception("Nao ha o que recuperar");
        }

        return (T) this.pilha[this.topo];
    }

    /**
     * Método cujo qual tem como principal  funçao desempilhar as coordenadas que se encontram no topo da pilha.
     * @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     * @return A função visa remover os valores de coordenadas empilhados pela function Empilha() do topo do Object Pilha.
     */
    public T desempilhar() throws Exception {
        if (this.topo == -1) {
            throw new Exception("Nao ha o que jogar fora");
        }

        return (T) this.pilha[topo--];
    }
    
    /**
     * Método cujo qual tem como principal  funçao verificar se o objeto pilha se encontra vazio ou não.
     * @return Caso a pilha seja negativa o valor true indicará que ela está vazia, senão a mesma retorna false indicando que possui elementos.
     */
    public boolean vazia() {
        if (this.topo == -1) {
            return true;
        }
        return false;
    }
    
    /**
     * Método cujo qual tem como principal  funçao verificar se o objeto pilha se encontra vazio ou não.
     * @return Caso a pilha seja negativa o valor true indicará que ela está vazia, senão a mesma retorna false indicando que possui elementos.
     */
    public int tamanho() {
        if (this.vazia()) {
            return 0;
        }
        return this.topo + 1;
    }
    
    /**
     * Método cujo qual tem como as boas práticas de programação apresentados em aula.
     * @return String contendo os elementos da pilha utilizados.
     */
    @Override
    public String toString() {
        String ret = "";

        ret += (this.topo + 1) + " elementos";

        if (this.topo > -1) {
            ret += " (Ultimo: " + this.pilha[this.topo];
            ret += ")";
        }

        return ret;
    }

    /**
     * Método cujo qual tem como as boas práticas de programação apresentados em aula.
     */
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

        Pilha<T> p = (Pilha<T>) obj;

        if (this.topo != p.topo) {
            return false;
        }

        for (int i = 0; i <= this.topo; i++) {
            if (!this.pilha[i].equals(p.pilha[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Método cujo qual tem como as boas práticas de programação apresentados em aula.
     * @return retorno do hash contendo coordenadas do topo da pilha
     */
    @Override
    public int hashCode() {
        int ret = 777;

        ret = 7 * ret + new Integer(this.topo).hashCode();

        for (int i = 0; i <= this.topo; i++) {
            ret = 13 * ret + this.pilha[i].hashCode();
        }

        return ret;
    }

}
