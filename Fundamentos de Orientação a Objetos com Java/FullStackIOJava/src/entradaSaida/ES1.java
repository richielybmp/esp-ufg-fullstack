/**
 * 
 */
package entradaSaida;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class ES1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o nome: ");
		String nome = sc.nextLine();
		System.out.println("Quantidade de letras: " + nome.length());
		System.out.println("Maiusculo: " + nome.toUpperCase());

		sc.close();
	}
}
