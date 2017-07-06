/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorademdc;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Joana
 */
public class CalculadoraDeMDC {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        // TODO code application logic 
Scanner ler = new Scanner(System.in);
Calculadora calcular = new Calculadora();
     int opcao = 5;
     while(opcao!=0){
     System.out.println("===============================================\n");
     System.out.println("escolha sua opcao:\n");
     System.out.println("1- Calcular MDC\n" + "0 - Sair\n ");
     System.out.println("==============================================\n");       
                                              
     opcao = ler.nextInt();
     switch(opcao){
         case 1:calcular.pegaValores();
         case 0:JOptionPane.showMessageDialog(null,"Progrma terminado!!");
         break;
     }  
 }
    }
}
