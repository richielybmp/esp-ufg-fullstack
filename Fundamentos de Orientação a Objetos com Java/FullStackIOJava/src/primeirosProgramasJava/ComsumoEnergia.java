/**
 * 
 */
package primeirosProgramasJava;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class ComsumoEnergia {

	public static void main(String args[]) {
		Scanner leitor = new Scanner(System.in);

		System.out.println("Insira o consumo de energia em kw");
		double consumo = leitor.nextInt();
		System.out.println("Insira o consumo de energia em kw/h");
		double valor_qwts = leitor.nextInt();

		double valor_sem_desconto = (consumo * valor_qwts);
		double valor_com_desconto = ((consumo * valor_qwts) - (consumo * valor_qwts) * 0.01);

		System.out.println("Valor da fatura: " + valor_sem_desconto);
		System.out.println("Valor da fatura com desconto de 10% aplicado: R$" + valor_com_desconto);

		leitor.close();
	}
}
