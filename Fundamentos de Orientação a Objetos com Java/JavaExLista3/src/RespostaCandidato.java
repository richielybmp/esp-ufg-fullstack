/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class RespostaCandidato {
	private String[] respostas;
	private int numeroInscricao;

	public RespostaCandidato(String[] respostas, int numeroInscricao) {
		this.respostas = respostas;
		this.numeroInscricao = numeroInscricao;
	}

	public String[] getRespostas() {
		return respostas;
	}

	public void setRespostas(String[] respostas) {
		this.respostas = respostas;
	}

	public int getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(int numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}
}
