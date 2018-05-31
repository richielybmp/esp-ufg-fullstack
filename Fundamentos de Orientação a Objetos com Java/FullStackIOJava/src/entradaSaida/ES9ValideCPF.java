/**
 * 
 */
package entradaSaida;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class ES9ValideCPF {
	public static void main(String args[]) {
		Scanner leitor = new Scanner(System.in);

		System.out.println("Insira o CPF (apenas números): ");
		String cpf = leitor.nextLine();

		if (ValideCPF(cpf)) {
			System.out.println("CPF ok!");
			System.out.println(imprimeCPF(cpf));
		} else {
			System.out.println("ATENÇÃO!!!! CPF inválido.");
		}

		leitor.close();
	}

	public static boolean ValideCPF(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11)) {
			return false;
		}

		char dig10, dig11;
		int soma, i, resto, num, peso;
		try {
			soma = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.charAt(i) - 48);
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			resto = 11 - (soma % 11);
			if ((resto == 10) || (resto == 11)) {
				dig10 = '0';
			} else {
				dig10 = (char) (resto + 48);
			}

			soma = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			resto = 11 - (soma % 11);
			if ((resto == 10) || (resto == 11)) {
				dig11 = '0';
			} else {
				dig11 = (char) (resto + 48);
			}

			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
				return true;
			} else {
				return false;
			}
		} catch (Exception erro) {
			return false;
		}
	}

	public static String imprimeCPF(String cpf) {
		return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
				+ cpf.substring(9, 11));
	}
}
