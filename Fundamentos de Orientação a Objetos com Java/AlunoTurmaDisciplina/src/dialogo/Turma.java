package dialogo;

import comum.Aluno;
import comum.Disciplina;

public class Turma {
	Aluno[] aluno;
	Disciplina disciplina;
	String nomeDaTurma;
	int anoDaTurma;

	public Turma(Aluno[] aluno) {
		this.aluno = aluno;
		this.nomeDaTurma = "Nova Turma";
		this.anoDaTurma = 2018;
	}

	// construtor 2
	public Turma(Aluno[] aluno, String nome) {
		this.aluno = aluno;
		this.nomeDaTurma = nome;
		this.anoDaTurma = 2018;
	}

	// sobrecarga 4
	public Turma(Aluno[] aluno, String nome, int ano, Disciplina disciplina) {
		this.aluno = aluno;
		this.nomeDaTurma = nome;
		this.anoDaTurma = ano;
		this.disciplina = disciplina;
	}

	public double media() {
		double soma = 0;
		for (int i = 0; i < aluno.length; i++)
			soma += aluno[i].media();
		return (soma / aluno.length);
	}

	public Aluno maiorMedia() {
		Aluno melhorAluno = aluno[0];
		double maior = aluno[0].media();
		for (int i = 0; i < aluno.length; i++)
			if (aluno[i].media() > maior) {
				melhorAluno = aluno[i];
				maior = aluno[i].media();
			}
		return melhorAluno;
	}

	public Aluno menorMedia() {
		Aluno piorAluno = aluno[0];
		double menor = aluno[0].media();
		for (int i = 1; i < aluno.length; i++)
			if (aluno[i].media() < menor) {
				piorAluno = aluno[i];
				menor = aluno[i].media();
			}
		return piorAluno;
	}

	// novo metodo 'obtenhaAlunosAprovados'
	public Aluno[] obtenhaAlunosAprovados() {
		int[] indices = new int[aluno.length];
		int n_aprovados = 0;

		for (int i = 0; i < aluno.length; i++) {
			if (aluno[i].aprovado()) {
				indices[n_aprovados] = i;
				n_aprovados++;
			}
		}

		return normalizarListaAprovados(n_aprovados, indices);
	}

	// sobrecarga 1
	public Aluno[] obtenhaAlunosAprovados(boolean considerarApenasFaltas) {
		int[] indices = new int[aluno.length];
		int n_aprovados = 0;

		for (int i = 0; i < aluno.length; i++) {
			if (aluno[i].aprovado(considerarApenasFaltas)) {
				indices[n_aprovados] = i;
				n_aprovados++;
			}
		}

		return normalizarListaAprovados(n_aprovados, indices);
	}

	// sobrecarga 2
	public Aluno[] obtenhaAlunosAprovados(boolean considerarFaltas, boolean considerarMedia) {
		int[] indices = new int[aluno.length];
		int n_aprovados = 0;

		for (int i = 0; i < aluno.length; i++) {
			if (aluno[i].aprovado(considerarFaltas, considerarMedia)) {
				indices[n_aprovados] = i;
				n_aprovados++;
			}
		}

		return normalizarListaAprovados(n_aprovados, indices);
	}

	private Aluno[] normalizarListaAprovados(int n_aprovados, int[] indices) {
		int j = 0;
		Aluno[] listaAprovados = new Aluno[n_aprovados];

		if (n_aprovados > 0) {
			for (int index : indices) {
				listaAprovados[j] = aluno[index];
				j++;
			}
		}

		return listaAprovados;
	}
}
