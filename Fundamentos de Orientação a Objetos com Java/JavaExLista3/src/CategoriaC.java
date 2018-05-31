/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class CategoriaC extends Operario {
	private double porcentagem = 0.09;

	public CategoriaC(int matricula, int numeroDePecasPorMes, Sexo sexo) {
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
		if (this.getNumeroDePecasPorMes() > 35) {
			int excedente = this.getNumeroDePecasPorMes() - 35;
			adicional = porcentagem * excedente;
		}
		return salario + adicional;
	}
}
