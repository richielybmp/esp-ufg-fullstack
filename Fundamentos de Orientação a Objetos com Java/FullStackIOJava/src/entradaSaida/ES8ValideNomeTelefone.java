/**
 * 
 */
package entradaSaida;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class ES8ValideNomeTelefone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira o nome: ");
		String nome = sc.nextLine();

		for (int i = 0; i < nome.length(); i++) {
			if (Character.isDigit(nome.charAt(i))) {
				System.out.println("O nome n�o cont�m apenas caracteres alfab�ticos!!!!");
				break;
			}
		}

		System.out.println("Nome: " + nome);

		System.out.println("Insira o numero telefone: ");
		String telefone = sc.nextLine();

		for (int i = 0; i < telefone.length(); i++) {
			if (!Character.isDigit(telefone.charAt(i))) {
				System.out.println("O telefone n�o cont�m apenas n�meros!!!!");
				break;
			}
		}

		System.out.println("Telefone: " + telefone);

		sc.close();
	}
}
