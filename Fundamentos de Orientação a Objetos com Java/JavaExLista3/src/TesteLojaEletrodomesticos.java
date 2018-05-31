import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class TesteLojaEletrodomesticos {
	public static void main(String[] args) {

		List<Vendedor> listaDeVendedores = new LinkedList<Vendedor>();
		double salarioMinimo = 400;

		// Scanner sc = new Scanner(System.in);
		// System.out.println("Informe o valor do salário minimo: ");
		// double salarioMinimo = sc.nextDouble();

		// 35 vendedores
		// for (int i = 0; i < 2; i++) {
		// System.out.println("Informe a inscrição do funionario #" + i + ": ");
		// int inscricao = sc.nextInt();
		//
		// System.out.println("Informe o número de televisores de tela plana vendidos
		// por #" + i);
		// int numTelaPlana = sc.nextInt();
		//
		// System.out.println("Informe o número de televisores de tela comum vendidos
		// por #" + i);
		// int numTelaComum = sc.nextInt();
		//
		// Vendedor vendedor = new Vendedor(inscricao, salarioMinimo, numTelaPlana,
		// numTelaComum);
		// listaDeVendedores.add(vendedor);
		// }

		// Para testes, estou instanciando os objetos Vendedor e alimentando a lista de
		// vendedores.
		Vendedor vendedor1 = new Vendedor(0, salarioMinimo, 5, 7);
		Vendedor vendedor2 = new Vendedor(1, salarioMinimo, 12, 22);
		Vendedor vendedor3 = new Vendedor(2, salarioMinimo, 3, 20);
		listaDeVendedores.add(vendedor1);
		listaDeVendedores.add(vendedor2);
		listaDeVendedores.add(vendedor3);

		for (Vendedor vendedor : listaDeVendedores) {
			vendedor.calcularComissao();
			vendedor.mostrarSalario();
			System.out.println();
		}
	}
}
