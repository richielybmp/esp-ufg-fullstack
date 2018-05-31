/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class TesteGabaritoProva {
	public static void main(String[] args) {

		ListaDeCandidatos candidatos = new ListaDeCandidatos();

		// O TRECHO DE CODIGO A SEGUIR ESTÁ COMENTADO POIS O TESTE FOI REALIZADO
		// INICIALIZANDO OS OBJETOS SEM SER NECESSÁRIA A ENTRADA DOS DADOS.

		// CASO QUEIRA FAZER A ENTRADA DOS DADOS MANUALMENTE, DESCOMENTE O CODIGO A
		// SEGUIR E AJUSTE A POPULACAO DA LISTA DE CANDIDATOS, GABARITO E RESPOSTA.

		// String[] gabarito = new String[10];
		// Scanner sc = new Scanner(System.in);
		//
		// System.out.println("Informe os dados dos candidatos: ");
		// for (int i = 0; i < 10; i++) {
		// System.out.println("Inscricao do candidato #" + i);
		// int inscricao = sc.nextInt();
		//
		// System.out.println("Nome do candidato #" + i);
		// String nome = sc.next();
		//
		// System.out.println("Telefone do candidato #" + i);
		// String telefone = sc.next();
		// Candidato candidato = new Candidato(inscricao, nome, telefone);
		// candidatos.adicionarCandidato(candidato);
		// }
		//
		// System.out.println();
		// System.out.println("Infome o gabarito da prova");
		// for (int i = 0; i < 10; i++) {
		// System.out.println("Resposta da questão #" + i);
		// gabarito[i] = sc.next();
		// }
		//
		// System.out.println();
		// System.out.println("Informe as respostas dos candidatos");
		// for (int i = 0; i < candidatos.getCandidatos().size(); i++) {
		// String[] respostas = new String[10];
		// System.out.println("Informe a inscrição do candidato para inserir as
		// respostas: ");
		// int inscricao = sc.nextInt();
		// for (int j = 0; i < 10; i++) {
		// System.out.println("Resposta da questão #" + j);
		// respostas[j] = sc.next();
		// }
		// RespostaCandidato resp = new RespostaCandidato(respostas, inscricao);
		// candidatos.adicionarRespostas(resp);
		// }

		// Para facilitar os testes, já estou inicializando os objetos para testar o
		// funcionamento das operações

		// objetos candidatos
		Candidato c1 = new Candidato(1, "C1", "111111111");
		Candidato c2 = new Candidato(2, "C2", "222222222");
		Candidato c3 = new Candidato(3, "C3", "333333333");
		Candidato c4 = new Candidato(4, "C4", "444444444");
		Candidato c5 = new Candidato(5, "C5", "555555555");
		Candidato c6 = new Candidato(6, "C6", "666666666");
		Candidato c7 = new Candidato(7, "C7", "777777777");
		Candidato c8 = new Candidato(8, "C8", "888888888");
		Candidato c9 = new Candidato(9, "C9", "999999999");

		// resposta das questões
		String[] gabaritoP1 = new String[] { "a", "c", "d", "b", "a", "c", "b", "b", "d", "a" };

		// resposta dos candidatos
		RespostaCandidato resp1 = new RespostaCandidato(
				new String[] { "a", "a", "c", "b", "a", "c", "b", "a", "c", "a" }, 1);

		RespostaCandidato resp2 = new RespostaCandidato(
				new String[] { "a", "c", "d", "b", "a", "c", "b", "b", "d", "a" }, 2);

		RespostaCandidato resp3 = new RespostaCandidato(
				new String[] { "a", "a", "a", "d", "c", "c", "a", "c", "b", "c" }, 3);

		RespostaCandidato resp4 = new RespostaCandidato(
				new String[] { "a", "a", "c", "c", "b", "b", "a", "a", "c", "a" }, 4);

		RespostaCandidato resp5 = new RespostaCandidato(
				new String[] { "a", "c", "d", "b", "a", "c", "b", "b", "c", "a" }, 5);

		RespostaCandidato resp6 = new RespostaCandidato(
				new String[] { "a", "a", "a", "a", "c", "b", "b", "b", "d", "a" }, 6);

		RespostaCandidato resp7 = new RespostaCandidato(
				new String[] { "a", "c", "d", "b", "a", "c", "b", "b", "d", "a" }, 7);

		RespostaCandidato resp8 = new RespostaCandidato(
				new String[] { "d", "c", "d", "a", "b", "c", "a", "d", "a", "c" }, 8);

		RespostaCandidato resp9 = new RespostaCandidato(
				new String[] { "c", "b", "a", "a", "c", "c", "b", "a", "d", "a" }, 9);

		candidatos.adicionarCandidato(c1);
		candidatos.adicionarCandidato(c2);
		candidatos.adicionarCandidato(c3);
		candidatos.adicionarCandidato(c4);
		candidatos.adicionarCandidato(c5);
		candidatos.adicionarCandidato(c6);
		candidatos.adicionarCandidato(c7);
		candidatos.adicionarCandidato(c8);
		candidatos.adicionarCandidato(c9);
		candidatos.adicionarRespostas(resp1);
		candidatos.adicionarRespostas(resp2);
		candidatos.adicionarRespostas(resp3);
		candidatos.adicionarRespostas(resp4);
		candidatos.adicionarRespostas(resp5);
		candidatos.adicionarRespostas(resp6);
		candidatos.adicionarRespostas(resp7);
		candidatos.adicionarRespostas(resp8);
		candidatos.adicionarRespostas(resp9);

		candidatos.corrigirProvas(gabaritoP1);

		candidatos.dadosCandidatos();

		System.out.println();

		candidatos.percentualAprovados();
	}
}
