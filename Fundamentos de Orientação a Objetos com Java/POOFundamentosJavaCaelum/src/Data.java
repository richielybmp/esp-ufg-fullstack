/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Data {
	int dia;
	int mes;
	int ano;

	public Data() {
		// this.dia = 01;
		// this.mes = 01;
		// this.ano = 2000;
	}

	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public String formatada() {
		return this.dia + "/" + this.mes + "/" + this.ano;
	}
}
