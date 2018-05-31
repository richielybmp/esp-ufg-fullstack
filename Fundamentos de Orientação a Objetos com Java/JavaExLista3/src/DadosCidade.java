
import java.util.Scanner;

/**
 *
 * @author Alunoinf_2
 */
public class DadosCidade {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ListaDeCidades listaDeCidades = new ListaDeCidades();

		// para testes estou lendo 3 cidades
		// for (int i = 0; i < 3; i++) {
		// System.out.println("Insira o cÃ³digo da cidade " + i + " :");
		// int codigo = sc.nextInt();
		//
		// System.out.println("Insira o nome da cidade " + i + " :");
		// String nome = sc.next();
		//
		// System.out.println("Insira o estado da cidade " + i + " :");
		// String estado = sc.next();
		//
		// System.out.println("Insira o numero de veiculos de passeio da cidade " + i +
		// " :");
		// int numVeiculos = sc.nextInt();
		//
		// System.out.println("Insira o numero de acidentes de transito da cidade " + i
		// + " :");
		// int numAcidentes = sc.nextInt();
		//
		// listaDeCidades.adicionarCidade(new Cidade(codigo, nome, estado, numVeiculos,
		// numAcidentes));
		// }

		listaDeCidades.adicionarCidade(new Cidade(0, "CidadeA", "GO", 123, 33));
		listaDeCidades.adicionarCidade(new Cidade(1, "CidadeB", "GO", 321, 79));
		listaDeCidades.adicionarCidade(new Cidade(2, "CidadeC", "SP", 213, 65));
		listaDeCidades.adicionarCidade(new Cidade(3, "CidadeD", "PR", 312, 28));
		listaDeCidades.adicionarCidade(new Cidade(4, "CidadeE", "rj", 132, 15));
		listaDeCidades.adicionarCidade(new Cidade(5, "CidadeF", "GO", 1000, 60));
		listaDeCidades.adicionarCidade(new Cidade(6, "CidadeG", "RJ", 963, 255));
		listaDeCidades.adicionarCidade(new Cidade(7, "CidadeH", "MG", 568, 132));
		listaDeCidades.adicionarCidade(new Cidade(8, "CidadeI", "SP", 5187, 686));
		listaDeCidades.adicionarCidade(new Cidade(9, "CidadeJ", "GO", 300, 55));

		// removendo no indice 1
		// listaDeCidades.removerCidade(1);
		// listaDeCidades.removerCidade(2);
		listaDeCidades.removerCidade(3);

		listaDeCidades.obtenhaCidadeComMaisAcidentes();
		listaDeCidades.obtenhaCidadeComMenosAcidentes();
		System.out.println("Media de veiculos: " + listaDeCidades.mediaDeVeiculos());
		System.out.println("Media de acidentes: " + listaDeCidades.mediaDeAcidentes());
		System.out.println("Media de acidentes em Goiás: " + listaDeCidades.mediaAcidentesGoias());
	}

}
