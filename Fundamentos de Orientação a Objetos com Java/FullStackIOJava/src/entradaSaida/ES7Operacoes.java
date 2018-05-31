/**
 * 
 */
package entradaSaida;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class ES7Operacoes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o valor 1: ");
		double valor1 = sc.nextDouble();
		System.out.println("Informe o valor 2: ");
		double valor2 = sc.nextDouble();

		System.out.println(valor1 + " + " + valor2 + " = " + (valor1 + valor2));
		System.out.println(valor1 + " - " + valor2 + " = " + (valor1 - valor2));
		System.out.println(valor1 + " * " + valor2 + " = " + (valor1 * valor2));
		System.out.println(valor1 + " / " + valor2 + " = " + (valor1 / valor2));

		sc.close();
	}
}
