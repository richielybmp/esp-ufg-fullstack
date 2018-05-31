/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Fibonacci {

	public int calculaFibonacci(int valor) {
		// if (valor == 0) {
		// return valor;
		// } else if (valor == 1) {
		// return valor;
		// } else {
		// return calculaFibonacci(valor - 1) + calculaFibonacci(valor - 2);
		// }

		// Operador condicional ternário
		return (valor == 0) ? 0 : (valor == 1) ? 1 : calculaFibonacci(valor - 1) + calculaFibonacci(valor - 2);
	}
}

// 3 2-1+0=1 1-retorna 1