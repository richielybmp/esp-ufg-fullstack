/**
 * 
 */
package primeirosProgramasJava;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class MenorNumero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o valor 1: ");
		double valor1 = sc.nextDouble();
		System.out.println("Informe o valor 2: ");
		double valor2 = sc.nextDouble();

		double menor = valor1;

		if (valor2 < menor)
			menor = valor2;

		System.out.println(menor);
		sc.close();
	}
}
