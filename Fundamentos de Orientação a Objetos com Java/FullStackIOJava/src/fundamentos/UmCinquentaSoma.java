/**
 * 
 */
package fundamentos;

/**
 * @author Richiely Batista
 *
 */
public class UmCinquentaSoma {
	public static void main(String[] args) {
		int soma = 0;
		for (int i = 1; i <= 50; i++) {
			soma += i;
		}

		// ou então , a seguinte formula calcula a soma de um intervalo; (b*(a+b))/2
		// soma = (50 *(1 + 50))/ 2;

		System.out.println(soma);
	}
}
