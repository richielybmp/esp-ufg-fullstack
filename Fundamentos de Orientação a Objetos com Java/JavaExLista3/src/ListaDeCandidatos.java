import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class ListaDeCandidatos {
	private List<Candidato> candidatos;
	private List<RespostaCandidato> respostas;

	public ListaDeCandidatos() {
		this.candidatos = new LinkedList<Candidato>();
		this.respostas = new LinkedList<RespostaCandidato>();
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public List<RespostaCandidato> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaCandidato> respostas) {
		this.respostas = respostas;
	}

	public void adicionarCandidato(Candidato candidato) {
		this.candidatos.add(candidato);
	}

	public void adicionarRespostas(RespostaCandidato respostas) {
		this.respostas.add(respostas);
	}

	public void corrigirProvas(String[] gabarito) {
		for (int i = 0; i < candidatos.size(); i++) {
			final int j = i;
			int nota = 0;
			RespostaCandidato respCandidatoX = respostas.stream()
					.filter(r -> r.getNumeroInscricao() == candidatos.get(j).getNumeroInscricao()).findFirst()
					.orElse(null);
			String[] respostasX = respCandidatoX.getRespostas();
			for (int z = 0; z < respostasX.length; z++) {
				if (respostasX[z].equals(gabarito[z])) {
					nota++;
				}
			}
			candidatos.get(j).setNota(nota);
		}
	}

	public void maiorNota() {
		Candidato maior = candidatos.get(0);
		for (int i = 1; i < candidatos.size(); i++) {
			Candidato temp = candidatos.get(i);
			if (temp.getNota() > maior.getNota()) {
				maior = temp;
			}
		}
	}

	public void dadosCandidatos() {
		for (Candidato candidato : candidatos) {
			System.out.println("Inscrição #" + candidato.getNumeroInscricao());
			System.out.println("Nome: " + candidato.getNome());
			System.out.println("Nota: " + candidato.getNota());
		}
	}

	public void percentualAprovados() {
		double totalAprovados = 0;
		double aprovadosMaiorQueNove = 0;
		System.out.println("Confira a seguir a lista dos candidatos aprovados");
		for (Candidato candidato : candidatos) {
			if (candidato.getNota() >= 6) {
				if (candidato.getNota() >= 9) {
					aprovadosMaiorQueNove++;
				}
				totalAprovados++;
				System.out.println("Inscrição #" + candidato.getNumeroInscricao());
				System.out.println("Nome: " + candidato.getNome());
				System.out.println("Telefone: " + candidato.getTelefone());
				System.out.println();
			}
		}
		System.out.println("Total de candidatos aprovados: " + totalAprovados);
		System.out.println(
				"Percentual de candidatos aprovados: " + (double) ((totalAprovados / candidatos.size()) * 100));
		System.out.println("Percentual de candidatos aprovados com nota maior ou igual a 9.0: "
				+ (double) ((aprovadosMaiorQueNove / candidatos.size()) * 100));
	}
}
