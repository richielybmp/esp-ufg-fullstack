/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Vendedor {
	private int numInscricao;
	private int quantidadeTVPlana;
	private int quantidadeTVComum;
	private double comissaoPlana;
	private double comissaoComum;
	private double salarioFixo;

	public Vendedor(int numInscricao, double salarioFixo, int quantidadeTVPlana, int quantidadeTVComum) {
		this.numInscricao = numInscricao;
		this.quantidadeTVComum = quantidadeTVComum;
		this.quantidadeTVPlana = quantidadeTVPlana;
		this.salarioFixo = salarioFixo;
	}

	public int getNumInscricao() {
		return numInscricao;
	}

	public void setNumInscricao(int numInscricao) {
		this.numInscricao = numInscricao;
	}

	public int getQuantidadeTVComum() {
		return quantidadeTVComum;
	}

	public void setQuantidadeTVComum(int quantidadeTVComum) {
		this.quantidadeTVComum = quantidadeTVComum;
	}

	public int getQuantidadeTVPlana() {
		return quantidadeTVPlana;
	}

	public void setQuantidadeTVPlana(int quantidadeTVPlana) {
		this.quantidadeTVPlana = quantidadeTVPlana;
	}

	public double getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	public void calcularComissao() {
		if (quantidadeTVPlana < 10) {
			this.comissaoPlana = quantidadeTVPlana * 30;
		} else {
			this.comissaoPlana = quantidadeTVPlana * 50;
		}

		if (quantidadeTVComum < 20) {
			this.comissaoComum = quantidadeTVComum * 20;
		} else {
			this.comissaoComum = quantidadeTVComum * 30;
		}
	}

	public void mostrarSalario() {
		double descontoInss = this.salarioFixo * 0.08;
		System.out.println("Desconto INSS: " + descontoInss);

		System.out.println(
				"Salário liquido sem desconto: " + (this.salarioFixo + this.comissaoComum + this.comissaoPlana));

		double salarioTotal = this.salarioFixo + (this.comissaoComum + this.comissaoPlana) - descontoInss;
		System.out.println("Salário liquido com desconto INSS: " + salarioTotal);

		if (salarioTotal >= 700) {
			salarioTotal = salarioTotal - (salarioTotal * 0.05);
			System.out.println("Salário bruto com desconto desconto IR: " + salarioTotal);
		} else {
			System.out.println("Salário bruto: " + salarioTotal);
		}

	}
}
