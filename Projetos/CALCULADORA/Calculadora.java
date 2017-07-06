import java.util.Scanner;

public class Calculadora {
	private int numero1;
	private int numero2;	
        
   

public void somar(){
	int soma;
 Scanner scanner = new Scanner(System.in);
System.out.println("=============================");
System.out.println("SOMANDO OS NÚMEROS:\n");
System.out.println("Digite o primeiro numero ");
numero1 = scanner.nextInt();
System.out.println("Digite o segundo numero");
numero2 = scanner.nextInt();
soma = numero1+numero2;
System.out.println("Soma:" +soma);
System.out.println("============================");

	
}
public void subtrair(){
		int subtracao;
Scanner scanner = new Scanner(System.in);
System.out.println("\nSUBTRAINDO OS NÚMEROS:\n");
System.out.println("Digite o primeiro numero ");
numero1 = scanner.nextInt();
System.out.println("Digite o segundo numero");
numero2 = scanner.nextInt();
subtracao = numero1-numero2;
System.out.println("Subtracao:" +subtracao);
System.out.println("=============================");

	
	
}
public void multiplicar(){
		int multiplicacao;
Scanner scanner = new Scanner(System.in);
System.out.println("\nMULTIPLICANDO OS NÚMEROS:\n");
System.out.println("Digite o primeiro numero ");
numero1 = scanner.nextInt();
System.out.println("Digite o segundo numero");
numero2 = scanner.nextInt();
multiplicacao = numero1*numero2;
System.out.println("multiplicacao:" + multiplicacao);
System.out.println("==============================");
}

public void dividir(){
		int divisao;
Scanner scanner = new Scanner(System.in);
System.out.println("\nDIVIDINDO OS NÚMEROS:\n");
System.out.println("Digite o primeiro numero ");
numero1 = scanner.nextInt();
System.out.println("Digite o segundo numero");
numero2 = scanner.nextInt();
divisao = numero1/numero2;
System.out.println("Divisao:" +divisao);
System.out.println("===============================");
	
} 
}
