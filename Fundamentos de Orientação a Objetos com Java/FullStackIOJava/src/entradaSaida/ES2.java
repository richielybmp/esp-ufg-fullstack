/**
 * 
 */
package entradaSaida;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class ES2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o nome: ");
		String nome = sc.nextLine();

		System.out.println(nome.equals("Testando"));
		System.out.println(nome.length());
		System.out.println(nome.charAt(2));
		System.out.println(nome.substring(2, 4));
		System.out.println(nome.toUpperCase());
		System.out.println(nome.toLowerCase());
		System.out.println(nome.trim());
		System.out.println(nome.replace("s", "x"));
		nome = "Fábrica de brinquedos";
		System.out.println(nome.indexOf("br"));
		System.out.println(nome.lastIndexOf("br"));
		System.out.println(nome.equals("br"));
		System.out.println(nome.equalsIgnoreCase("br"));
		sc.close();
	}
}
