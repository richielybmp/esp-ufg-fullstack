/**
 * 
 */
package entradaSaida;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class ES6QuadradoERaiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe um numero: ");
		int valor1 = sc.nextInt();

		System.out.println("Quadrado de " + valor1 + " eh " + valor1 * valor1);
		System.out.println("A raiz de  " + valor1 + " eh " + Math.sqrt(valor1));

		sc.close();
	}
}
