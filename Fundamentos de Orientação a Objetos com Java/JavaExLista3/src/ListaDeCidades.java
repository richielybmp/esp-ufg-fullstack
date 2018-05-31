
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alunoinf_2
 */
public class ListaDeCidades {

	List<Cidade> cidades;

	public ListaDeCidades() {
		cidades = new LinkedList<>();
	}

	public ListaDeCidades(LinkedList<Cidade> cidades) {
		this.cidades = cidades;
	}

	public void adicionarCidade(Cidade cidade) {
		cidades.add(cidade);
	}

	public void removerCidade(int index) {
		Cidade c = cidades.get(index);
		cidades.remove(c);
	}

	public void obtenhaCidadeComMaisAcidentes() {
		Cidade c = cidades.get(0);
		for (int i = 1; i < cidades.size(); i++) {
			Cidade temp = cidades.get(i);
			if (temp.getNumAcidentes() > c.getNumAcidentes()) {
				c = temp;
			}
		}
		System.out.println("Cidade com maior numero de acidentes: " + c.getCodigo() + " - " + c.getNome() + " com "
				+ c.getNumAcidentes() + " acidentes.");
	}

	public void obtenhaCidadeComMenosAcidentes() {
		Cidade c = cidades.get(0);
		for (int i = 1; i < cidades.size(); i++) {
			Cidade temp = cidades.get(i);
			if (temp.getNumAcidentes() < c.getNumAcidentes()) {
				c = temp;
			}
		}
		System.out.println("Cidade com menor numero de acidentes: " + c.getCodigo() + " - " + c.getNome() + " com "
				+ c.getNumAcidentes() + " acidentes.");
	}

	public double mediaDeVeiculos() {
		double somaVeiculos = 0;
		for (Cidade cidade : cidades) {
			somaVeiculos += cidade.getNumVeiculos();
		}
		return (somaVeiculos / cidades.size());
	}

	public double mediaDeAcidentes() {
		double somaAcidentes = 0;
		for (Cidade cidade : cidades) {
			somaAcidentes += cidade.getNumAcidentes();
		}
		return (somaAcidentes / cidades.size());
	}

	public double mediaAcidentesGoias() {
		double numCidadesGoias = 0;
		double qtdAcidentes = 0;
		for (Cidade cidade : cidades) {
			if (cidade.getSigla().equals("GO")) {
				numCidadesGoias++;
				qtdAcidentes += cidade.getNumAcidentes();
			}
		}
		// System.out.println("Media de acidentes em Goias: " + qtdAcidentes /
		// numCidadesGoias);
		return qtdAcidentes / numCidadesGoias;
	}
}