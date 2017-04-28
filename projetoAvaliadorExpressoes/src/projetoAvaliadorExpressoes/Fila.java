
package projetoAvaliadorExpressoes;

import java.util.LinkedList;
import java.util.List;

public class Fila {
      private List<String> numero = new LinkedList<String>();
      
      //Adicionar posicao da fila?
      private int posicao = -1;

      public void enfileirar(String numero) {
        posicao++;
        this.numero.add(numero);
      }
      
      public String desenfileirar() {         
          return this.numero.remove(0);
      }

      public boolean vazia() {
        return this.numero.size() == 0;
      }
      
      public void limparLista(){
          numero.clear();
      }
      
      public String retornaUltimoValor(){
          return this.numero.get(0);
      }
      
      public int tamanhoFila(){
    	  return numero.size();
      }
}

