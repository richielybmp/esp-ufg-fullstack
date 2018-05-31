import java.util.Scanner;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Problema8PreencherMatriz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] elementos = new int[9];
		int[][] matriz = new int[3][3];
		int el = 0;

		System.out.println("Insira um vetor de 9 elementos inteiros:");

		for (int i = 0; i < elementos.length; i++) {
			System.out.println("Posição [" + i + "]:");
			elementos[i] = sc.nextInt();
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++, el++) {
				matriz[i][j] = elementos[el];
			}
		}

		System.out.println("Imprimindo matriz gerada:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}
