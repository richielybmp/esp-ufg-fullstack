/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class CategoriaB extends Operario {
	private double porcentagem = 0.05;

	public CategoriaB(int matricula, int numeroDePecasPorMes, Sexo sexo) {
		super(matricula, numeroDePecasPorMes, sexo);
	}

	public double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	public double calcularSalario() {
		double salario = this.getSalarioMinimo();
		double adicional = 0;
		if (this.getNumeroDePecasPorMes() > 10) {
			int excedente = this.getNumeroDePecasPorMes() - 10;
			adicional = porcentagem * excedente;
		}
		return salario + adicional;
	}
}
