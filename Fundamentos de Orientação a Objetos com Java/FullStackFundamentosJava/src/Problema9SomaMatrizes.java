import java.util.Scanner;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Problema9SomaMatrizes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira um número inteiro que representará a dimensão N x N da matriz: ");
		int dimemsao = sc.nextInt();

		int m1[][] = new int[dimemsao][dimemsao];
		int m2[][] = new int[dimemsao][dimemsao];
		int mSoma[][] = new int[dimemsao][dimemsao];

		System.out.println("A seguir, preencha a primeira matriz: ");

		for (int i = 0; i < dimemsao; i++) {
			for (int j = 0; j < dimemsao; j++) {
				System.out.println("M1[" + i + "][" + j + "]: ");
				m1[i][j] = sc.nextInt();
			}
		}

		System.out.println("A seguir, preencha a segunda matriz: ");

		for (int i = 0; i < dimemsao; i++) {
			for (int j = 0; j < dimemsao; j++) {
				System.out.println("M2[" + i + "][" + j + "]: ");
				m2[i][j] = sc.nextInt();
			}
		}

		System.out.printf("Matriz 1 + Matriz 2\n");

		for (int i = 0; i < dimemsao; i++) {
			for (int j = 0; j < dimemsao; j++) {
				mSoma[i][j] = m1[i][j] + m2[i][j];
				System.out.print(mSoma[i][j] + " ");
			}
			System.out.printf("\n");
		}

		sc.close();
	}
}
