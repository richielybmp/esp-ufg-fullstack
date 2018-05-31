/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class TesteComplexo {
	public static void main(String[] args) {
		Complexo c1 = new Complexo(12.34f, 34.12f);
		Complexo c2 = new Complexo(56.78f, 78.56f);
		System.out.println("C1: " + c1.mostrarComplexo());
		System.out.println("C2: " + c2.mostrarComplexo());

		Complexo complexoSoma = Complexo.somar(c1, c2);
		System.out.println("C1 + C2: " + complexoSoma.mostrarComplexo());

		Complexo complexoSubtrair = Complexo.subtrair(c1, c2);
		System.out.println("C1 - C2: " + complexoSubtrair.mostrarComplexo());
	}
}
