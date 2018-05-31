/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */

public class Operario {
	private int matricula;
	private int numeroDePecasPorMes;
	private Sexo sexo;
	private double salarioMinimo = 968.31;

	public Operario(int matricula, int numeroDePecasPorMes, Sexo sexo) {
		this.matricula = matricula;
		this.numeroDePecasPorMes = numeroDePecasPorMes;
		this.sexo = sexo;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getNumeroDePecasPorMes() {
		return numeroDePecasPorMes;
	}

	public void setNumeroDePecasPorMes(int numeroDePecasPorMes) {
		this.numeroDePecasPorMes = numeroDePecasPorMes;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public double getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public double calcularSalario() {
		return this.salarioMinimo;
	}

}
