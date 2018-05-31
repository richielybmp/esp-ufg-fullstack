/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Complexo {
	private float parteReal;
	private float parteImaginaria;
	// private static float i = (float) Math.sqrt(-1);

	public Complexo() {
		this.parteReal = 0.0f;
		this.parteImaginaria = 0.0f;
	}

	public Complexo(float parteReal, float parteImaginaria) {

		this.parteReal = parteReal;
		this.parteImaginaria = parteImaginaria;
	}

	public float getParteReal() {
		return parteReal;
	}

	public void setParteReal(float parteReal) {
		this.parteReal = parteReal;
	}

	public float getParteImaginaria() {
		return parteImaginaria;
	}

	public void setParteImaginaria(float parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
	}

	public static Complexo somar(Complexo c1, Complexo c2) {
		return new Complexo((c1.parteReal + c2.parteReal), (c1.parteImaginaria + c2.parteImaginaria));
	}

	public static Complexo subtrair(Complexo c1, Complexo c2) {
		return new Complexo((c1.parteReal - c2.parteReal), (c1.parteImaginaria - c2.parteImaginaria));
	}

	public String mostrarComplexo() {
		return "(" + this.parteReal + ", " + this.parteImaginaria + ")";
	}
}
