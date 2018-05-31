/**
 * 
 */
package primeirosProgramasJava;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class DiaDaSemana {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira numero do dia da semana : ");
		int dia = sc.nextInt();

		switch (dia) {
		case 1:
			System.out.println(dia + " - Domingo");
			break;
		case 2:
			System.out.println(dia + " - Segunda");
			break;
		case 3:
			System.out.println(dia + " - Terça");
			break;
		case 4:
			System.out.println(dia + " - Quarta");
			break;
		case 5:
			System.out.println(dia + " - Quinta");
			break;
		case 6:
			System.out.println(dia + " - Sexta");
			break;
		case 7:
			System.out.println(dia + " - Sábado");
			break;
		default:
			System.out.println("Esse valor não corresponde a um dia da semana.");
			break;
		}

		sc.close();
	}
}
