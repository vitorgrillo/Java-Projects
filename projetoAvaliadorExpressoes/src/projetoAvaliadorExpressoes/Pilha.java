
package projetoAvaliadorExpressoes;

public class Pilha {

    public String[] pilha;
    public int posicaoPilha;

    public Pilha() {
        this.posicaoPilha = -1;
         // indica que esta nula, vazia, pois posições um indica que contém informação
        this.pilha = new String[1000];
         // criando uma pilha com 1000 posições
    }

    public boolean vazia() {
        if (this.posicaoPilha == -1) {
            return true;
        }
        return false;
    }

    public int tamanho() {
        if (this.vazia()) {
            return 0;
        }
        return this.posicaoPilha + 1;
    }

    public String exibeUltimoValor() {
        if (this.vazia()) {
            return null;
        }
        return this.pilha[this.posicaoPilha];
    }

    public String desempilhar() throws Exception {
        if (vazia()) {
            throw new Exception("Não existe mais item para remover");
        }
        return (String) this.pilha[this.posicaoPilha--];
    }

    public void empilhar(String valor) throws Exception {
        if (posicaoPilha == pilha.length - 1) {
            throw new Exception("Não existe mais espaço");
        }
        this.pilha[++posicaoPilha] = valor;
    }
    
    public boolean verificaPrioridade(String valor, String valorPilha){
    	boolean retorno = true;
    	
        switch(valor) {
            case "(":
            switch(valorPilha) {
              case "(":
              retorno = false;
              break;

              case "^":
              retorno = false;
              break;

              case "*":
              retorno = false;
              break;

              case "/":
              retorno = false;
              break;

              case "+":
              retorno = false;
              break;

              case "-":
              retorno = false;
              break;   

              case ")":
              retorno = false;
              break;                       
          }

          break;

          case "^":
          switch(valorPilha) {
            case "(":
            retorno = false;
            break;         

            case "^":
            retorno = false;
            break;   

            case "*":
            retorno = false;
            break;   

            case "/":
            retorno = false;
            break;

            case "+":
            retorno = false;
            break;   

            case "-":
            retorno = false;
            break;

            case ")":
            retorno = false;
            break;   
        }
        break;

        case "*":
        switch(valorPilha){
            case "(":
            retorno = false;
            break;

            case "^":
            retorno = true;
            break;

            case "*":
            retorno = true;
            break;

            case "/":
            retorno = true;
            break;

            case "+":
            retorno = false;
            break;

            case "-":
            retorno = false;
            break;

            case ")":
            retorno = false;
            break;
        }

        break;

        case "/":
        switch(valorPilha) {
            case "(":
            retorno = false;
            break;   

            case "^":
            retorno = true;
            break;   

            case "*":
            retorno = true;
            break;   

            case "/":
            retorno = true;
            break;

            case "+":
            retorno = false;
            break;   

            case "-":
            retorno = false;
            break;   

            case ")":
            retorno = false;
            break;   
        }
        break;

        case "+":
        switch(valorPilha) {
            case "(":
            retorno = false;
            break;  

            case "^":
            retorno = true;
            break;   

            case "*":
            retorno = true;
            break;   

            case "/":
            retorno = true;
            break;   

            case "+":
            retorno = true;
            break;   

            case "-":
            retorno = true;
            break;   

            case ")":
            retorno = false;
            break;   
        }
        break;

        case "-":
        switch(valorPilha) {
            case "(":
            retorno = false;
            break;   

            case "^":
            retorno = true;
            break;

            case "*":
            retorno = true;
            break;

            case "/":
            retorno = true;
            break;

            case "+":
            retorno = true;
            break;

            case "-":
            retorno = true;
            break;

            case ")":
            retorno = false;
            break;
        }
        break;

        case ")":
        switch(valorPilha) {
            case "(":
            retorno = true;
            break;

            case "^":
            retorno = true;
            break;

            case "*":
            retorno = true;
            break;

            case "/":
            retorno = true;
            break;

            case "+":
            retorno = true;
            break;

            case "-":
            retorno = true;
            break;

            case ")":
            retorno = false;
            break;
            
        }
        break;
    }

    return retorno;
}
}