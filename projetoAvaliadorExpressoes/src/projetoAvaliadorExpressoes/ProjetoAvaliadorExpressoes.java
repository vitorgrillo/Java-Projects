package projetoAvaliadorExpressoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjetoAvaliadorExpressoes {

	public static void main(String[] args) throws Exception {

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));


		String valorFila = "";
		String valorPilha = "";
		boolean prioridade = true;

		Pattern numberExpression = Pattern.compile("[0-9]");
		Pattern mathExpression = Pattern.compile("[+-=*/^()]");

		String expressao;
		int opcaoEscolhida = 0;

		do {
			try {
				System.out.println("\n+----------------------------------------------------+");
				System.out.println("|             Escolha a opção desejada               |");
				System.out.println("|1 - Digitar uma expressão | 2 - Finalizar o programa|");
				System.out.println("+----------------------------------------------------+");

				Fila fila = new Fila();
				Pilha pilha = new Pilha();
				opcaoEscolhida = Integer.parseInt(entrada.readLine());

				switch (opcaoEscolhida) {

				case 1:
					System.out.println("\nDigite a expressão: ");
					expressao = entrada.readLine();

					StringTokenizer dividir = new StringTokenizer(expressao, "+-=*/^()", true);

					while (dividir.hasMoreTokens()) {
						String valor = dividir.nextToken();

						Matcher number = numberExpression.matcher(valor);
						Matcher math = mathExpression.matcher(valor);

						try {
							if (valor.equals(")")) {
								
								while (!pilha.exibeUltimoValor().equals("(")) {
									valorFila = pilha.desempilhar();
									fila.enfileirar(valorFila);
								}
								pilha.desempilhar();
							}else{
								if (number.find()) {
									System.out.println("Fila: " + valor);
									fila.enfileirar(valor);
								}else if(math.find()){

									System.out.println("Pilha: " + valor);
									if (pilha.vazia() == true) {
										pilha.empilhar(valor);
									} else {

										valorPilha = pilha.exibeUltimoValor();
										prioridade = pilha.verificaPrioridade(valor, valorPilha);

										if (prioridade == false) {
											pilha.empilhar(valor);
										} else {

											while (prioridade) {
												if(!pilha.vazia()){
												
													fila.enfileirar(pilha.desempilhar());
													
													if(!pilha.vazia()){
														valorPilha = pilha.exibeUltimoValor();
														prioridade = pilha.verificaPrioridade(valor, valorPilha);
													}else{
														prioridade = false;
													}
													
												}else{
													prioridade = false;
												}
											};

											pilha.empilhar(valor);
										}
									}

								
								}
							}

							 
						} catch (Exception e) {
							System.err.println("Erro: " + e.getMessage());
						}
					}
					
					while(!pilha.vazia()){
						fila.enfileirar(pilha.desempilhar());
					}
					
					Character op = null;
					Double n1 = null, n2 = null;
					String valorRecuperado = "";
					Pilha pilhaFinal = new Pilha();
					
					while(!fila.vazia()){
						
						System.out.println(fila.retornaUltimoValor());
						valorRecuperado = fila.desenfileirar();
						
						Matcher number = numberExpression.matcher(valorRecuperado);
						Matcher math = mathExpression.matcher(valorRecuperado);
						
						if(number.find()){
							pilhaFinal.empilhar(valorRecuperado);
						}else if(math.find()){
							
							Double resultado = 0.00;
							
							op = valorRecuperado.charAt(0);
							n2 = Double.valueOf(pilhaFinal.desempilhar());
							n1 = Double.valueOf(pilhaFinal.desempilhar());
							
							switch(op){
							case '+':
								resultado = n1 + n2;
								break;
							case '-':
								resultado = n1 - n2;
								break;
							case '*':
								resultado = n1 * n2;
								break;
							case '/':
								resultado = n1 / n2;
								break;
							case '^':
								resultado = Math.pow(n1, n2);
								break;
							default:
								throw new Exception("Operacao invalida");
								
							}
							
							pilhaFinal.empilhar(String.valueOf(resultado));
							
							if(pilhaFinal.tamanho() == 1 && fila.vazia()){
								System.out.println(pilhaFinal.exibeUltimoValor());
							}
							
						}
					}
					
					break;

				case 2:
					break;

				default:
					System.err.println("\nOpção inválida... Escolha novamente");
				}
			} catch (IOException erro) {
				System.err.println("Erro.. Reiniciar o programa...");
			} catch (NumberFormatException erro) {
				System.err.println("\nValor inválido");
			}
		} while (opcaoEscolhida != 2);

		System.out.println("\nSaindo do programa....\n\n");
	}
}
