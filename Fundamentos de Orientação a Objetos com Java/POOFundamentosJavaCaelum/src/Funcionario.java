/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Funcionario {
	String nome;
	String departamento;
	double salario;
	Data dataDeEntrada;
	String rg;
	boolean estaNaEmpresa;
	boolean possuiPlanoDeSaude;

	public Funcionario() {

	}

	public void recebeAumento(double aumento) {
		this.salario = this.salario + aumento;
	}

	public double calculaGanhoAnual() {
		return this.salario * 12;
	}

	public double calculaValorFerias() {
		return this.salario + (this.salario * 0.08);
	}

	public double calculaSalarioMensal() {
		return this.salario - calculaDescontosSalario();
	}

	private double calculaDescontosSalario() {
		double descontos = 0.0;
		if (possuiPlanoDeSaude) {
			descontos += 120;
		}
		return descontos;
	}

	public void demite() {
		this.estaNaEmpresa = false;
	}

	public String ToString() {
		return "Colaborador:" + this.nome + "\nSalario liquido: " + this.salario + "\nDescontos: "
				+ calculaDescontosSalario() + "\nSalario final:" + calculaSalarioMensal() + "\n";
	}

	public void mostra() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Departamento: " + this.departamento);
		System.out.println("Salario: " + this.salario);
		System.out.println("Data de entrada: " + this.dataDeEntrada);
		System.out.println("RG: " + this.rg);
		System.out.println("Esta' na empresa: " + this.estaNaEmpresa);
		System.out.println("Possui plano de saude: " + this.possuiPlanoDeSaude);
		System.out.println("Salario mensal: " + this.calculaSalarioMensal());
		System.out.println("Descontos do salario: " + this.calculaDescontosSalario());
		System.out.println("Salário das ferias: " + this.calculaValorFerias());
		System.out.println("Dia: " + this.dataDeEntrada.dia);
		System.out.println("Mês: " + this.dataDeEntrada.mes);
		System.out.println("Ano: " + this.dataDeEntrada.ano);
		System.out.println("Data de entrada: " + this.dataDeEntrada.formatada());

	}
}
