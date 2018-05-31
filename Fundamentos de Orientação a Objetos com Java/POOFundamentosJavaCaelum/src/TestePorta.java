/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class TestePorta {
	public static void main(String[] args) {
		Porta p = new Porta();
		p.abre();
		p.fecha();
		p.pinta("Azul");
		p.pinta("Amarelo");
		p.pinta("Verde");
		p.setDimensaoX(3.5);
		p.setDimensaoY(2.5);
		p.setDimensaoZ(1.25);

		if (p.estaAberta()) {
			System.out.println("A porta está aberta.");
		} else {
			System.out.println("A porta está fechada.");
		}

	}
}
