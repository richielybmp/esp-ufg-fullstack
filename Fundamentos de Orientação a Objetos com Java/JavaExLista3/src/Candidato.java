/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Candidato {
	private int numeroInscricao;
	private String nome;
	private String telefone;
	private int nota;

	public Candidato(int numeroInscricao, String nome, String telefone) {
		this.numeroInscricao = numeroInscricao;
		this.nome = nome;
		this.telefone = telefone;
	}

	public int getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(int numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
