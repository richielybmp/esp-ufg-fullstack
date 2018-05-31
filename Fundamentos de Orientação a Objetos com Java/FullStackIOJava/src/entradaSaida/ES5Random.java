/**
 * 
 */
package entradaSaida;

import java.util.Random;

/**
 * @author Richiely Batista
 *
 */
public class ES5Random {
	public static void main(String[] args) {
		Random rd = new Random();
		int numero_random = rd.nextInt(101);
		System.out.println("Numero aleatorio: " + numero_random);
	}
}
