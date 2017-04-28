import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SistemaLinearGaussiano {
	public void resolver(double[][]  A, double[] B){
		int N = B.length;
        for (int k = 0; k < N; k++) 
        {
            /** encontra pivo linha **/
            int max = k;
            for (int i = k + 1; i < N; i++) 
                if (Math.abs(A[i][k]) > Math.abs(A[max][k])) 
                    max = i;
 
            /** troca linha na matriz A **/    
            double[] temp = A[k]; 
            A[k] = A[max]; 
            A[max] = temp;
 
            /** troca valor correspondente na matriz constante **/
            double t = B[k]; 
            B[k] = B[max]; 
            B[max] = t;
 
            /** Pivo entre A e B **/
            for (int i = k + 1; i < N; i++) 
            {
                double factor = A[i][k] / A[k][k];
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++) 
                    A[i][j] -= factor * A[k][j];
            }
        }
 
        /** Volta Substituição **/
        double[] solucao = new double[N];
        for (int i = N - 1; i >= 0; i--) 
        {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) 
                sum += A[i][j] * solucao[j];
            solucao[i] = (B[i] - sum) / A[i][i];
        }        
        /** Imprime Resultado **/
        imprimeResultado(solucao);
	}
	
	/** função para imprimir linhas da equação 
	 * @return **/
    public int imprimeLinhaEquacao(double[][] A, double[] B)
    {
        int N = B.length;
        System.out.println("\nLinha Equação : ");
        String out="Linha Equação : \n";
        for (int i = 0; i < N; i++)
           {
               for (int j = 0; j < N; j++){
            	   out += " | " + A[i][j];
            	   System.out.printf("%.2f ", A[i][j]);
               }
               System.out.printf("| %.2f\n", B[i]);   
               out += " | " + B[i] + "\n";
               
           }
        
           JOptionPane.showMessageDialog(null, out);
          
           return 0;
    }
    
    /** Função para imprimir resultados **/
    public void imprimeResultado(double[] res)
    {
        int N = res.length;
        System.out.println("\nResultado : ");
        String out="";
        out += "Resultado : \n";
        for (int i = 0; i < N; i++){ 
            System.out.printf(" %.2f ", res[i]);   
        	out += " | " + res[i];
        }
        
        JOptionPane.showMessageDialog(null, out);
    }    
    
    /** Main function **/
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Algoritmo Maligno de Gauss\n");
        /** Make an object of GaussianElimination class **/
        SistemaLinearGaussiano maligno = new SistemaLinearGaussiano();
 
        /** Numero de variaveis **/
        int N = 3;
 
       
        //System.out.printf("Informe o nome de arquivo texto:\n");  
        String path = "C:/Curso/JSE/VitorGrillo/SistemaLinear/src/";
        String nome = path.concat(JOptionPane.showInputDialog(null,"Digite o nome do arquivo: "));
        //String nome = path.concat(scan.nextLine());
		try {

			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = null;

	        double[] B = new double[N];
	        double[][] A = new double[N][N];
	        
	        /**Coeficientes Equação**/
	        for (int i = 0; i < N; i++){
	            for (int j = 0; j < N; j++){
	            			linha = lerArq.readLine();// lê da segunda até a última linha
							A[i][j] = Integer.parseInt(linha);
					}
	        }
	        
	        /**Numero Soluções**/
	        for (int i = 0; i < N; i++){
	        	linha = lerArq.readLine();
	            B[i] = Integer.parseInt(linha);
	        }
	        
	        maligno.imprimeLinhaEquacao(A,B);
	        maligno.resolver(A,B);
	        
		}catch (IOException e){
			e.printStackTrace();
		}
    }
}

