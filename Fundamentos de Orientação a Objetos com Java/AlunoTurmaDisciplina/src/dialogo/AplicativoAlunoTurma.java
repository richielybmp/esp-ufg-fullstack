package dialogo;

import javax.swing.JOptionPane;

import comum.Aluno;
import comum.Disciplina;

public class AplicativoAlunoTurma {
	public static void main(String a[]) {

		final int TOTAL_ALUNOS = 5;

		Aluno aluno[] = new Aluno[TOTAL_ALUNOS];

		String nomeTurma = JOptionPane.showInputDialog("Nome da turma: ");

		String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina: ");
		String cargaHorariaAux = JOptionPane.showInputDialog("Carga Horaria: ");
		int cargaHoraria = Integer.parseInt(cargaHorariaAux);
		String nomeProfessor = JOptionPane.showInputDialog("Nome do professor: ");

		for (int i = 0; i < aluno.length; i++) {

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

			String faltasAux = JOptionPane.showInputDialog("Quantidade de faltas do " + k + "o. aluno: ");
			int faltas = Integer.parseInt(faltasAux);

			aluno[i] = new Aluno(matr, nome, nota1, nota2, nota3, faltas);
		}

		// Turma t = new Turma(aluno);
		Disciplina d = new Disciplina(nomeDisciplina, "Disciplina da turma", cargaHoraria, nomeProfessor);
		Turma t = new Turma(aluno, nomeTurma, 2018, d);

		String result = "Media da Turma: " + t.media() + "\nA maior media da turma e' do aluno "
				+ t.maiorMedia().getNome() + "\nA menor media da turma e' do aluno " + t.menorMedia().getNome();

		JOptionPane.showMessageDialog(null, result, "Estatisticas", JOptionPane.PLAIN_MESSAGE);

		Aluno[] aprovados = t.obtenhaAlunosAprovados(true, true);
		result = "";
		if (aprovados.length > 0) {
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