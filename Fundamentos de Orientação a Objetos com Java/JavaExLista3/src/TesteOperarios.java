/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class TesteOperarios {
	public static void main(String[] args) {
		ListaDeOperarios operarios = new ListaDeOperarios();
		CategoriaA opA1 = new CategoriaA(0, 3, Sexo.FEMININO);
		CategoriaA opA2 = new CategoriaA(1, 6, Sexo.MASCULINO);
		CategoriaA opA3 = new CategoriaA(2, 2, Sexo.FEMININO);
		CategoriaA opA4 = new CategoriaA(3, 4, Sexo.MASCULINO);
		CategoriaA opA5 = new CategoriaA(4, 10, Sexo.FEMININO);

		operarios.adicionarOperario(opA1);
		operarios.adicionarOperario(opA2);
		operarios.adicionarOperario(opA3);
		operarios.adicionarOperario(opA4);
		operarios.adicionarOperario(opA5);

		CategoriaB opB1 = new CategoriaB(10, 22, Sexo.MASCULINO);
		CategoriaB opB2 = new CategoriaB(11, 13, Sexo.MASCULINO);
		CategoriaB opB3 = new CategoriaB(12, 27, Sexo.MASCULINO);
		CategoriaB opB4 = new CategoriaB(13, 18, Sexo.MASCULINO);
		CategoriaB opB5 = new CategoriaB(14, 34, Sexo.FEMININO);

		operarios.adicionarOperario(opB1);
		operarios.adicionarOperario(opB2);
		operarios.adicionarOperario(opB3);
		operarios.adicionarOperario(opB4);
		operarios.adicionarOperario(opB5);

		CategoriaC opC1 = new CategoriaC(110, 36, Sexo.FEMININO);
		CategoriaC opC2 = new CategoriaC(112, 79, Sexo.MASCULINO);
		CategoriaC opC3 = new CategoriaC(111, 43, Sexo.FEMININO);
		CategoriaC opC4 = new CategoriaC(113, 55, Sexo.MASCULINO);
		CategoriaC opC5 = new CategoriaC(114, 60, Sexo.FEMININO);

		operarios.adicionarOperario(opC1);
		operarios.adicionarOperario(opC2);
		operarios.adicionarOperario(opC3);
		operarios.adicionarOperario(opC4);
		operarios.adicionarOperario(opC5);

		for (Operario operario : operarios.getOperarios()) {
			System.out.println("Matricula: " + operario.getMatricula() + " - Sexo:" + operario.getSexo()
					+ " - Salário: " + operario.calcularSalario());
		}

		System.out.println();
		System.out.println("Total da folha de pagamento do mês: " + operarios.totalFolhaDePagamento());
		System.out.println("Total de peças fabricadas no mês: " + operarios.totalPecasFabricadas());
		System.out.println("Média de peças fabricadas pelos homens da Categoria A: " + operarios.mediaPecasHomemCatA());
		System.out.println(
				"Média de peças fabricadas pelas mulheres da Categoria C: " + operarios.mediaPecasMulheresCatC());
		System.out.println(operarios.operarioComMaiorSalario());
	}
}
