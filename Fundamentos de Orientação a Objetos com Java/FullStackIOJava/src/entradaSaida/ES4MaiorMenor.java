/**
 * 
 */
package entradaSaida;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class ES4MaiorMenor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o valor 1: ");
		double valor1 = sc.nextDouble();
		System.out.println("Informe o valor 2: ");
		double valor2 = sc.nextDouble();

		double maior = valor1;

		if (valor2 > maior)
			maior = valor2;

		System.out.println(maior);
		sc.close();
	}

}
