/**
 * 
 */
package primeirosProgramasJava;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */

public class MediaFinal {
	public static void main(String args[]) {
		Scanner leitor = new Scanner(System.in);

		System.out.println("Insira a nota da P1");
		double p1 = leitor.nextInt();

		System.out.println("Insira a nota da P2");
		double p2 = leitor.nextInt();

		System.out.println("Insira a nota da P3");
		double p3 = leitor.nextInt();

		System.out.println("Insira a nota do NT");
		double nt = leitor.nextInt();

		double nota_final = (p1 * 0.2 + p2 * 0.3 + p3 * 0.5) * 0.85 + nt * 0.15;

		System.out.println("Média final: " + nota_final);
		leitor.close();
	}
}