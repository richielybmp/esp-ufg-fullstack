/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Problema6PreencheVetor {
	public static void main(String[] args) {
		double[] vetor = new double[50];

		vetor[0] = vetor[vetor.length - 1] = 100;

		System.out.print("[0]=" + vetor[0] + " ");
		for (int i = 1; i < vetor.length - 1; i++) {
			int anterior = i - 1;
			// Math.exp(0) esta retornando 1.
			vetor[i] = ((anterior * anterior) + Math.sqrt(i + 1));
			System.out.print("[" + i + "]=" + vetor[i] + " ");
		}
		System.out.print("[49]=" + vetor[49] + " ");
	}
}

// soma do quadrado do índice do elemento anterior e a raiz quadrada do índice
// do elemento seguinte