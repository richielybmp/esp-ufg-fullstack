import java.util.Scanner;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Problema7VetorImpar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] elementos = new int[9];

		System.out.println("Insira um vetor de 9 elementos inteiros:");

		for (int i = 0; i < elementos.length; i++) {
			System.out.println("Posi��o [" + i + "]:");
			elementos[i] = sc.nextInt();
		}

		for (int i = 0; i < elementos.length; i++) {
			if (elementos[i] % 2 != 0) {
				System.out.println("O n�mero " + elementos[i] + " � �mpar. Posi��o [" + i + "] do vetor.");
			}
		}

		sc.close();
	}
}
