package lista;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import comum.Aluno;
import comum.Disciplina;

public class Turma {
	LinkedList alunos;
	int max;
	Disciplina disciplina;
	String nomeDaTurma;
	int anoDaTurma;

	public Turma(int max) {
		this.max = max;
		alunos = new LinkedList();
	}

	// sobrecarga 4
	public Turma(int max, String nome, int ano, Disciplina disciplina) {
		this.max = max;
		alunos = new LinkedList();
		this.nomeDaTurma = nome;
		this.anoDaTurma = ano;
		this.disciplina = disciplina;
	}

	public boolean adicionaAluno(Aluno aluno) {

		boolean result;

		if (this.alunos.size() == this.max)
			result = false;
		else
			result = alunos.add(aluno);

		return result;
	}

	public boolean removeAluno(Aluno aluno) {

		return alunos.remove(aluno);

	}

	public Collection getAlunos() {
		return this.alunos;
	}

	public double media() {

		double soma = 0;

		Iterator i = this.alunos.iterator();
		while (i.hasNext()) {
			Aluno aluno = (Aluno) i.next();
			soma += aluno.media();
		}

		return (soma / alunos.size());

	}

	public Aluno maiorMedia() {

		Iterator i = alunos.iterator();

		Aluno melhorAluno = (Aluno) i.next();
		double maior = melhorAluno.media();

		while (i.hasNext()) {
			Aluno aluno = (Aluno) i.next();
			if (aluno.media() > maior) {
				melhorAluno = aluno;
				maior = aluno.media();
			}
		}

		return melhorAluno;
	}

	public Aluno menorMedia() {

		Iterator i = alunos.iterator();

		Aluno piorAluno = (Aluno) i.next();
		double menor = piorAluno.media();

		while (i.hasNext()) {
			Aluno aluno = (Aluno) i.next();
			if (aluno.media() > menor) {
				piorAluno = aluno;
				menor = aluno.media();
			}
		}

		return piorAluno;
	}

	// sobrecarga 1
	public LinkedList<Aluno> obtenhaAlunosAprovados(boolean considerarApenasFaltas) {
		LinkedList<Aluno> alunosAprovados = new LinkedList<Aluno>();
		Iterator i = alunos.iterator();

		while (i.hasNext()) {
			Aluno aluno = (Aluno) i.next();
			if (aluno.aprovado(considerarApenasFaltas)) {
				alunosAprovados.add(aluno);
			}
		}
		return alunosAprovados;
	}

	// sobrecarga 2
	public LinkedList<Aluno> obtenhaAlunosAprovados(boolean considerarFaltas, boolean considerarMedia) {
		LinkedList<Aluno> alunosAprovados = new LinkedList<Aluno>();
		Iterator i = alunos.iterator();

		while (i.hasNext()) {
			Aluno aluno = (Aluno) i.next();
			if (aluno.aprovado(considerarFaltas, considerarMedia)) {
				alunosAprovados.add(aluno);
			}
		}
		return alunosAprovados;
	}
}