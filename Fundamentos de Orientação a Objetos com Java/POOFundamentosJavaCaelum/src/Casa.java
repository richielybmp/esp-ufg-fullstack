/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Casa {
	private String cor;
	public Porta porta1;
	public Porta porta2;
	public Porta porta3;

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	void pinta(String s) {
		setCor(s);
	}

	int quantasPortasEstaoAbertas() {
		int qtdAbertas = 0;
		if (this.porta1.estaAberta()) {
			qtdAbertas++;
		}
		if (this.porta2.estaAberta()) {
			qtdAbertas++;
		}
		if (this.porta3.estaAberta()) {
			qtdAbertas++;
		}
		return qtdAbertas;
	}
}
