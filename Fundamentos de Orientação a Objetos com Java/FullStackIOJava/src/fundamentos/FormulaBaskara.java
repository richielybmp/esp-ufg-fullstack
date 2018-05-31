package fundamentos;
/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class FormulaBaskara {
	public static void main(String[] args) {
		double a, b, c, delta, x1, x2;

		a = 5;
		b = 10;
		c = 2;

		delta = (b * b - 4) * a * c;

		if (delta < 0) {
			System.out.println("O valor de delta eh menor que zero.");
		} else {
			x1 = (-b + Math.sqrt(delta)) / (2 * a);

			x2 = (-b - Math.sqrt(delta)) / (2 * a);

			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
		}
	}
}
