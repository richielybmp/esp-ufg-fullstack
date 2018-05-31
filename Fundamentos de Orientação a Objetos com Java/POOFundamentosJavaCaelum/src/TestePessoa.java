/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class TestePessoa {
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("Bob");
		p.setIdade(17);

		p.fazAniversario();
		// 1 ano depois
		p.fazAniversario();
		// + 1 ano depois
		p.fazAniversario();

		System.out.println("Nome: " + p.getNome());
		System.out.println("Idade: " + p.getIdade());
	}
}
