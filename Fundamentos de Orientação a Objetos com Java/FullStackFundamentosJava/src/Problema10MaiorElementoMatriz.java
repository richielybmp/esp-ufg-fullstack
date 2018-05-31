import java.util.Scanner;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Problema10MaiorElementoMatriz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m[][] = new int[5][7];
		int maiorElemento = m[0][0];
		int posicaoLinha = 0, posicaoColuna = 0;
		System.out.println("A seguir, preencha a matriz 5x7: ");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.println("M[" + i + "][" + j + "]: ");
				m[i][j] = sc.nextInt();

				if (m[i][j] > maiorElemento) {
					maiorElemento = m[i][j];
					posicaoLinha = i;
					posicaoColuna = j;
				}
			}
		}

		System.out.printf("Maior elemento:\n" + maiorElemento + " na posição M" + "[" + posicaoLinha + "]["
				+ posicaoColuna + "]");

		sc.close();
	}
}
