/**
 * 
 */
package primeirosProgramasJava;

/**
 * @author Richiely Batista
 *
 */
public class MostraImpares {
	public static void main(String[] args) {
		for (int i = 2; i <= 100; i++) {
			if (i % 2 != 0)
				System.out.println(i);
		}
	}
}
