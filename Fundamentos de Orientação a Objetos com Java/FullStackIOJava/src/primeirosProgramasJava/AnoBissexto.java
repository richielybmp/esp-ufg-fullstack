/**
 * 
 */
package primeirosProgramasJava;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class AnoBissexto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o ano: ");
		int ano = sc.nextInt();

		if (ano % 400 == 0) {
			System.out.println("O ano " + ano + " eh bissexto.");
		} else if ((ano % 4 == 0) && (ano % 100 != 0)) {
			System.out.println("O ano " + ano + " eh bissexto.");
		} else {
			System.out.println("O ano " + ano + " nao eh bissexto");
		}

		sc.close();
	}
}
