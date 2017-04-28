/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notapaulista;

import java.util.Scanner;

/**
 *
 * @author Vitor Grillo
 */
public class NotaPaulista {

    /** 
     * @param args the command line arguments
     */
    
    public static double CalculoCredito(){
        double result = 0;
        
        CalculaCredito calc = new CalculaCredito();
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o valor de ICMS: ");
        calc.VA = ler.nextDouble();
        
        System.out.println("Digite o valor de aquisição (compras): ");
        calc.VICMS = ler.nextDouble();
        
        System.out.println("Digite o valor de saída (Vendas): ");
        calc.VTS = ler.nextDouble();
        
        result = ((0.3 * calc.VICMS) * calc.VA / calc.VTS);
        
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
       double result;
       
       result = CalculoCredito();
        
       System.out.println("Créditos a resgatar: " + result);
        
    }
}
