package comum;

public class Disciplina {
	private String nome;
	private String descricao;
	private int cargaHoraria;
	private String professor;
	
	//construtor 1
	public Disciplina(String nome) {
		setNome(nome);
		setDescricao(null); 
	}
	
	//construtor 2
	public Disciplina(String nome, String descricao) {
		setNome(nome);
		setDescricao(descricao);
	}
	
	//construtor 3
	public Disciplina(String nome, String descricao, int carga) {
		setNome(nome);
		setDescricao(descricao);
		setCargaHoraria(carga);
	}
	
	//construtor 4
	public Disciplina(String nome, String descricao, int carga, String professor) {
		setNome(nome);
		setDescricao(descricao);
		setCargaHoraria(carga);
		setProfessor(professor);
	}	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setCargaHoraria(int carga) {
		this.cargaHoraria = carga;
	}
	
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}
	
	public void setProfessor(String nome) {
		this.professor = nome;
	}
	
	public String getProfessor() {
		return this.professor;
	}
	
	public void setDescricao(String descricao) {
		if(descricao != null)
			this.descricao = descricao;
		else
			this.descricao = "Disciplina - " + this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
