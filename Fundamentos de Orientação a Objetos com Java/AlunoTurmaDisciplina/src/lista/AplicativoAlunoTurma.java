package lista;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import comum.Aluno;
import comum.Disciplina;

public class AplicativoAlunoTurma {
	public static void main(String a[]) {

		final int TOTAL_ALUNOS = 1;

		Aluno aluno;

		String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina: ");
		Disciplina disciplina = new Disciplina(nomeDisciplina, "Disciplina da turma de POO", 48);

		Turma turma = new Turma(40, "Nova Turma de POO", 2018, disciplina);

		for (int i = 0; i < TOTAL_ALUNOS; i++) {

			int k = i + 1;

			String nome = JOptionPane.showInputDialog("Nome do " + k + "o. aluno: ");

			String matrAux = JOptionPane.showInputDialog("Matricula do " + k + "o. aluno: ");
			int matr = Integer.parseInt(matrAux);

			String nota1Aux = JOptionPane.showInputDialog("Nota 1 do " + k + "o. aluno: ");
			int nota1 = Integer.parseInt(nota1Aux);

			String nota2Aux = JOptionPane.showInputDialog("Nota 2 do " + k + "o. aluno: ");
			int nota2 = Integer.parseInt(nota2Aux);

			String nota3Aux = JOptionPane.showInputDialog("Nota 3 do " + k + "o. aluno: ");
			int nota3 = Integer.parseInt(nota3Aux);

			String faltasAux = JOptionPane.showInputDialog("Faltas do " + k + "o. aluno: ");
			int faltas = Integer.parseInt(faltasAux);

			// aluno = new Aluno(matr, nome, nota1, nota2, nota3);
			// turma.adicionaAluno(aluno);
			aluno = new Aluno(matr, nome, nota1, nota2, nota3, faltas);
			turma.adicionaAluno(aluno);
		}

		String result = "Media da Turma: " + turma.media() + "\nA maior media da turma e' do aluno "
				+ turma.maiorMedia().getNome() + "\nA menor media da turma e' do aluno " + turma.menorMedia().getNome();

		JOptionPane.showMessageDialog(null, result, "Estatisticas", JOptionPane.PLAIN_MESSAGE);

		LinkedList<Aluno> aprovados = turma.obtenhaAlunosAprovados(true, true);
		result = "";
		if (aprovados.size() > 0) {
			for (Aluno aprovado : aprovados) {
				result += aprovado.getNome() + " com media " + aprovado.media() + " e " + aprovado.getFaltas()
						+ " faltas.\n";
			}
		} else {
			result = "Nenhum aluno foi aprovado";
		}

		JOptionPane.showMessageDialog(null, result, "Lista de aprovados", JOptionPane.PLAIN_MESSAGE);

		System.exit(0);

	}
}