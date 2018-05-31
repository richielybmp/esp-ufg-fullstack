package applet;

import comum.Aluno;
import comum.Disciplina;

public class Turma {
	Aluno[] aluno;
	int maximo;
	int atual = 0;
	Disciplina disciplina;
	String nomeDaTurma;
	int anoDaTurma;

	// construtor 1
	public Turma(int maximo) {
		this.maximo = maximo;
		this.atual = 0;
		this.aluno = new Aluno[maximo];
		this.nomeDaTurma = "Nova Turma";
		this.anoDaTurma = 2018;
	}

	// construtor 2
	public Turma(int maximo, String nome) {
		this.maximo = maximo;
		this.atual = 0;
		this.aluno = new Aluno[maximo];
		this.nomeDaTurma = nome;
	}

	// sobrecarga 3
	public Turma(int maximo, String nome, int ano) {
		this.maximo = maximo;
		this.atual = 0;
		this.aluno = new Aluno[maximo];
		this.nomeDaTurma = nome;
		this.anoDaTurma = ano;
	}

	// sobrecarga 4
	public Turma(int maximo, String nome, int ano, Disciplina disciplina) {
		this.maximo = maximo;
		this.atual = 0;
		this.aluno = new Aluno[maximo];
		this.nomeDaTurma = nome;
		this.anoDaTurma = ano;
		this.disciplina = disciplina;
	}

	public void adiciona(Aluno a) {
		turmaCheia();
		aluno[atual] = a;
		atual++;
	}

	public boolean turmaCheia() {
		if (atual >= maximo) {
			return true;
		}
		return false;
	}

	public double media() {
		double soma = 0;
		for (int i = 0; i < atual; i++)
			soma += aluno[i].media();
		return (soma / atual);
	}

	public Aluno maiorMedia() {
		Aluno melhorAluno = aluno[0];
		double maior = aluno[0].media();
		for (int i = 0; i < atual; i++)
			if (aluno[i].media() > maior) {
				melhorAluno = aluno[i];
				maior = aluno[i].media();
			}
		return melhorAluno;
	}

	public Aluno menorMedia() {
		Aluno piorAluno = aluno[0];
		double menor = aluno[0].media();
		for (int i = 1; i < atual; i++)
			if (aluno[i].media() < menor) {
				piorAluno = aluno[i];
				menor = aluno[i].media();
			}
		return piorAluno;
	}

	// novo metodo 'obtenhaAlunosAprovados'
	public Aluno[] obtenhaAlunosAprovados() {
		int[] indices = new int[atual];
		int n_aprovados = 0;

		for (int i = 0; i < atual; i++) {
			if (aluno[i].aprovado()) {
				indices[n_aprovados] = i;
				n_aprovados++;
			}
		}

		return normalizarListaAprovados(n_aprovados, indices);
	}

	// sobrecarga 1
	public Aluno[] obtenhaAlunosAprovados(boolean considerarApenasFaltas) {
		int[] indices = new int[atual];
		int n_aprovados = 0;

		for (int i = 0; i < atual; i++) {
			if (aluno[i].aprovado(considerarApenasFaltas)) {
				indices[n_aprovados] = i;
				n_aprovados++;
			}
		}

		return normalizarListaAprovados(n_aprovados, indices);
	}

	// sobrecarga 2
	public Aluno[] obtenhaAlunosAprovados(boolean considerarFaltas, boolean considerarMedia) {
		int[] indices = new int[atual];
		int n_aprovados = 0;

		for (int i = 0; i < atual; i++) {
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
