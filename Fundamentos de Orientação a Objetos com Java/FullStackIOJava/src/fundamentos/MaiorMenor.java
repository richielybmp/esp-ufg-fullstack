/**
 * 
 */
package fundamentos;

/**
 * @author Richiely Batista
 *
 */
public class MaiorMenor {
	public static void main(String[] args) {
		int n1 = 20;
		int n2 = 50;
		int n3 = 34;

		int maior = n1;
		int menor = n1;

		if (n2 > maior)
			maior = n2;
		if (n3 > maior)
			maior = n3;

		if (n2 < menor)
			menor = n2;
		if (n3 < menor)
			menor = n3;

		System.out.println("Maior: " + maior);
		System.out.println("Menor: " + menor);

	}
}
