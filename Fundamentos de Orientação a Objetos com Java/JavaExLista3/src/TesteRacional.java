/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class TesteRacional {
	public static void main(String[] args) {
		Racional rc1 = new Racional(6, 5);
		Racional rc2 = new Racional(4, 3);
		System.out.println(rc1 + " + " + rc2 + " = " + Racional.somarRacionais(rc1, rc2));
		System.out.println(rc1 + " - " + rc2 + " = " + Racional.subtrairRacionais(rc1, rc2));
		System.out.println(rc1 + " * " + rc2 + " = " + Racional.multiplicarRacionais(rc1, rc2));
		System.out.println(rc1 + " / " + rc2 + " = " + Racional.dividirRacionais(rc1, rc2));
		System.out.println();

		Racional rc3 = new Racional(1, 2);
		Racional rc4 = new Racional(1, 4);
		System.out.println(rc3 + " + " + rc4 + " = " + Racional.somarRacionais(rc3, rc4));
		System.out.println(rc3 + " - " + rc4 + " = " + Racional.subtrairRacionais(rc3, rc4));
		System.out.println(rc3 + " x " + rc4 + " = " + Racional.multiplicarRacionais(rc3, rc4));
		System.out.println(rc3 + " / " + rc4 + " = " + Racional.dividirRacionais(rc3, rc4));
		System.out.println();

		Racional rc5 = new Racional(3, 2);
		Racional rc6 = new Racional(8, 8);
		System.out.println(rc5 + " + " + rc6 + " = " + Racional.somarRacionais(rc5, rc6));
		System.out.println(rc5 + " - " + rc6 + " = " + Racional.subtrairRacionais(rc5, rc6));
		System.out.println(rc5 + " x " + rc6 + " = " + Racional.multiplicarRacionais(rc5, rc6));
		System.out.println(rc5 + " / " + rc6 + " = " + Racional.dividirRacionais(rc5, rc6));
		System.out.println();

	}
}
