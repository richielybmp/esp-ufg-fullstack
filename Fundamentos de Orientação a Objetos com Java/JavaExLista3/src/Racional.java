/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Racional {
	private int numerador;
	private int denominador;

	public Racional() {
		this.numerador = 0;
		this.denominador = 0;
	}

	public Racional(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	public static Racional somarRacionais(Racional racional1, Racional racional2) {
		Racional temp1 = new Racional();
		Racional temp2 = new Racional();
		int mmc = racional1.denominador * racional2.denominador;

		temp1.numerador = racional1.numerador * racional2.denominador;
		temp1.denominador = mmc;

		temp2.numerador = racional1.denominador * racional2.numerador;
		temp2.denominador = mmc;

		Racional soma = new Racional();
		soma.numerador = temp1.numerador + temp2.numerador;
		soma.denominador = mmc;
		reduzir(soma);
		return soma;
	}

	public static Racional subtrairRacionais(Racional racional1, Racional racional2) {
		Racional temp1 = new Racional();
		Racional temp2 = new Racional();
		int mmc = racional1.denominador * racional2.denominador;

		temp1.numerador = racional1.numerador * racional2.denominador;
		temp1.denominador = mmc;

		temp2.numerador = racional1.denominador * racional2.numerador;
		temp2.denominador = mmc;

		Racional sub = new Racional();
		sub.numerador = temp1.numerador - temp2.numerador;
		sub.denominador = mmc;
		reduzir(sub);
		return sub;
	}

	public static Racional multiplicarRacionais(Racional racional1, Racional racional2) {
		Racional multi = new Racional();
		multi.numerador = racional1.numerador * racional2.numerador;
		multi.denominador = racional1.denominador * racional2.denominador;
		reduzir(multi);
		return multi;
	}

	public static Racional dividirRacionais(Racional racional1, Racional racional2) {
		int novoDen = racional2.numerador;
		int novoNum = racional2.denominador;
		racional2.numerador = novoNum;
		racional2.denominador = novoDen;
		return Racional.multiplicarRacionais(racional1, racional2);
	}

	private static void reduzir(Racional fracao) {

		int mdc, maior;
		mdc = 1;
		maior = fracao.numerador;

		if (fracao.denominador > maior) {
			maior = fracao.denominador;
		}

		for (int i = 2; i <= maior; i++) {
			while ((fracao.numerador % i == 0) && (fracao.denominador % i == 0)) {
				fracao.numerador = fracao.numerador / i;
				fracao.denominador = fracao.denominador / i;
				mdc = mdc * i;
			}
		}
		// return mdc;
	}

	@Override
	public String toString() {
		return this.numerador + "/" + this.denominador;
	}
}