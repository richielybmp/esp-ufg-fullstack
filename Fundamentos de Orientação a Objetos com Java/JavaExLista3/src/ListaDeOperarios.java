import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class ListaDeOperarios {
	private List<Operario> operarios;

	public ListaDeOperarios() {
		this.operarios = new LinkedList<Operario>();
	}

	public List<Operario> getOperarios() {
		return operarios;
	}

	public void setOperarios(List<Operario> operarios) {
		this.operarios = operarios;
	}

	public void adicionarOperario(Operario operario) {
		operarios.add(operario);
	}

	public double totalFolhaDePagamento() {
		double total = 0;
		for (Operario operario : operarios) {
			total += operario.calcularSalario();
		}
		return total;
	}

	public double totalPecasFabricadas() {
		double total = 0;
		for (Operario operario : operarios) {
			total += operario.getNumeroDePecasPorMes();
		}
		return total;
	}

	public double mediaPecasHomemCatA() {
		double totalPecas = 0;
		double totalHomensCatA = 0;
		for (Operario operario : operarios) {
			if ((operario.getSexo() == Sexo.MASCULINO) && (operario instanceof CategoriaA)) {
				totalHomensCatA++;
				totalPecas += operario.getNumeroDePecasPorMes();
			}
		}
		return (totalPecas / totalHomensCatA);
	}

	public double mediaPecasMulheresCatC() {
		double totalPecas = 0;
		double totalMulheresCatC = 0;
		for (Operario operario : operarios) {
			if ((operario.getSexo() == Sexo.FEMININO) && (operario instanceof CategoriaC)) {
				totalMulheresCatC++;
				totalPecas += operario.getNumeroDePecasPorMes();
			}
		}
		return (totalPecas / totalMulheresCatC);
	}

	public String operarioComMaiorSalario() {
		Operario maior = operarios.get(0);
		for (int i = 1; i < operarios.size(); i++) {
			Operario temp = operarios.get(i);
			if (temp.calcularSalario() > maior.calcularSalario()) {
				maior = temp;
			}
		}
		return "Operario de matricula " + maior.getMatricula() + " tem o maior salário. Salario = "
				+ maior.calcularSalario();
	}
}
