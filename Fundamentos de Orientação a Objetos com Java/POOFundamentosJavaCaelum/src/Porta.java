/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Porta {
	private boolean aberta;
	private String cor;
	private double dimensaoX;
	private double dimensaoY;
	private double dimensaoZ;

	public boolean getAberta() {
		return this.aberta;
	}

	public String getCor() {
		return this.cor;
	}

	public double getDimensaoX() {
		return this.dimensaoX;
	}

	public double getDimensaoY() {
		return this.dimensaoY;
	}

	public double getDimensaoZ() {
		return this.dimensaoZ;
	}

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setDimensaoX(double dX) {
		this.dimensaoX = dX;
	}

	public void setDimensaoY(double dY) {
		this.dimensaoY = dY;
	}

	public void setDimensaoZ(double dZ) {
		this.dimensaoZ = dZ;
	}

	void abre() {
		setAberta(true);
	}

	void fecha() {
		setAberta(false);
	}

	void pinta(String s) {
		setCor(s);
	}

	boolean estaAberta() {
		return getAberta() ? true : false;
	}

}
