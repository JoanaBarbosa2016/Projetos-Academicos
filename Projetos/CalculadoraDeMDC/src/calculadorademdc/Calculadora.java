/*
=====================================================================================================
*APLICAÇÃO PONTUADA DESENVOLVIDA PARA DISCIPLINA DE TEORIA DOS NÚMEROS.                          =
O BOJETIVO DESTE ALGORITMO É CALCULAR O MDC ENTRE DOSIS NÚMEROS INTEIROS.                           =
======================================================================================================
METODOS ULTILIZADOS PARA CALCULAR O MDC ENTRE OS DOIS NÚMEROS, SUPONDO QUE ELES                      =
SEJAM X E Y, SENDO X MAIOR QUE Y:                                                                    =
I)Divida X por Y e obtenha o resto R1. Se R1 for zero, o mdc entre X e Y é Y.                        =
II)Se R1 não for zero, divida Y por R1 e obtenha o resto R2. Se R2 for zero, o mdc entre X e Y é R1. =
III)Se R2 não for zero, divida R1 por R2 e obtenha o resto R3. Se R3 for zero, o mdc entre X e Y é R2=
...                                                                                                  =
Assim até que se obtenha Rn = 0.                                                                     =
======================================================================================================
*
 */
package calculadorademdc;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Joana
 */
public class Calculadora {
    private int numeroUm;  
    private int numeroDois;
    private int resultado;
    
    
Scanner ler = new Scanner(System.in);


    public int getNumeroUm() {
        return numeroUm;
    }

    public void setNumeroUm(int numeroUm) {
        this.numeroUm = numeroUm;
    }
   

    public int getNumeroDois() {
        return numeroDois;
    }

    public void setNumeroDois(int numeroDois) {
        this.numeroDois = numeroDois;
    }
   

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    /**
     *
     */
    public void pegaValores(){

     numeroUm = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro numero:"));
     numeroDois = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo numero:"));
     
     while (numeroDois != 0) {  
         //o resultado é o resto da divisão do numero 1 pelo numero 2
         //logo ele passarrá a ser o numero 2
        resultado = numeroUm%numeroDois; 
        //o numero agora passará a ter o mesmo resultado do antigo numero 2
        numeroUm = numeroDois; 
        //o numer 2 agora terá o resultado do resto da divisão
        numeroDois = resultado;
        if(numeroDois == 0){
        JOptionPane.showMessageDialog(null,"MDC: " +numeroUm);
}
 }
 
 
}
}
