/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class TesteFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		f1.nome = "Alan";
		f1.rg = "1234567";
		f1.departamento = "Testes integrados";
		f1.estaNaEmpresa = true;
		f1.salario = 2000;
		f1.recebeAumento(350);
		f1.possuiPlanoDeSaude = true;

		Data data = new Data();
		f1.dataDeEntrada = data;
		// System.out.print(f1.ToString());
		f1.mostra();

		System.out.println();
		System.out.println();

		// Funcionario f2 = new Funcionario();
		// f2.nome = "Alan";
		// f2.rg = "7654321";
		// f2.departamento = "Diretoria";
		// f2.estaNaEmpresa = true;
		// f2.salario = 6000;
		// f2.recebeAumento(754.68);
		// f2.possuiPlanoDeSaude = true;
		// System.out.print(f2.ToString());

		Funcionario f2 = f1;

		if (f1 == f2) {
			System.out.println("Objetos iguais");
		} else {
			System.out.println("Objetos diferentes");
		}

		// Funcionario.calculaGanhoAnual();
		// f2.mostra(); }
	}
}
