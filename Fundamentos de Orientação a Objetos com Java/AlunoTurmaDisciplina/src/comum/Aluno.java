package comum;

public class Aluno {
	private int matr;
	private String nome;
	private double nota1;
	private double nota2;
	private double nota3;
	private int faltas;

	// construtor 1
	public Aluno(int matr, String nome) {
		setMatr(matr);
		setNome(nome);
		setNotas(0, 0, 0);
		setFaltas(0);
	}

	// construtor 2
	public Aluno(int matr, String nome, double nota1, double nota2, double nota3) {
		setMatr(matr);
		setNome(nome);
		setNotas(nota1, nota2, nota3);
		setFaltas(0);
	}

	// construtor 3
	public Aluno(int matr, String nome, double nota1, double nota2, double nota3, int faltas) {
		setMatr(matr);
		setNome(nome);
		setNotas(nota1, nota2, nota3);
		setFaltas(faltas);
	}

	// construtor 4
	public Aluno(int matr, String nome, double[] notas, int faltas) {
		setMatr(matr);
		setNome(nome);
		setNotas(notas);
		setFaltas(faltas);
	}

	public void setMatr(int matr) {
		this.matr = matr;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNotas(double nota1, double nota2, double nota3) {
		setNota1(nota1);
		setNota2(nota2);
		setNota3(nota3);
	}

	// sobrecarga 1
	public void setNotas(double[] notas) {
		setNota1(notas[0]);
		setNota2(notas[1]);
		setNota3(notas[2]);
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public int getMatr() {
		return matr;
	}

	public String getNome() {
		return nome;
	}

	public double getNota1() {
		return nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public double getNota13() {
		return nota3;
	}

	public int getFaltas() {
		return this.faltas;
	}

	public double maiorNota() {

		double maior = nota1;

		if (nota2 > maior)
			maior = nota2;
		if (nota3 > maior)
			maior = nota3;

		return maior;
	}

	public double media() {
		return ((nota1 + nota2 + nota3) / 3);
	}

	public boolean aprovado() {
		return (media() >= 7);
	}

	// sobrecarga aprovado
	public boolean aprovado(boolean considerarApenasFaltas) {
		if (considerarApenasFaltas) {
			return (this.faltas < 5);
		} else {
			return aprovado();
		}
	}

	// sobrecarga aprovado
	public boolean aprovado(boolean considerarFaltas, boolean considerarMedia) {
		boolean bFaltas = false;
		boolean bMedia = false;
		if (considerarFaltas) {
			bFaltas = aprovado(considerarFaltas);
		}
		if (considerarMedia) {
			bMedia = aprovado();
		}

		return (bFaltas && bMedia);
	}

}
