/**
 * 
 */
package entradaSaida;

import java.util.Scanner;

/**
 * @author Richiely Batista
 *
 */
public class ES3Decimal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe um valor decimal: ");
		double valor = sc.nextDouble();

		System.out.println(Math.ceil(valor));
		System.out.println(Math.floor(valor));
		System.out.println(Math.round(valor));
		sc.close();
	}
}
