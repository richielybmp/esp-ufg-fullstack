/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class TesteCasa {
	public static void main(String[] args) {
		Casa c = new Casa();
		c.pinta("Azul");

		c.porta1 = new Porta();
		c.porta2 = new Porta();
		c.porta3 = new Porta();

		c.porta1.abre();
		c.porta1.fecha();
		c.porta2.abre();
		// c.porta2.fecha();
		c.porta3.abre();
		// c.porta3.fecha();
		System.out.println(c.quantasPortasEstaoAbertas() + " portas estão abertas");
	}
}
