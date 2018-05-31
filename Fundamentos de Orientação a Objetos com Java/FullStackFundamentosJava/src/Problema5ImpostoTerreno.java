import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Problema5ImpostoTerreno {
	public static void main(String[] args) {
		String JareaTotal, JareaConstruida;
		float areaTotal, areaConstruida;
		double valorTotal;

		JareaTotal = JOptionPane.showInputDialog("Informe a área total do terreno em m^2:");
		areaTotal = Float.parseFloat(JareaTotal);

		JareaConstruida = JOptionPane.showInputDialog("Informe a área construída do terreno em m^2:");
		areaConstruida = Float.parseFloat(JareaConstruida);

		valorTotal = ((areaConstruida * 5) + ((areaTotal - areaConstruida) * 3.8));

		JOptionPane.showMessageDialog(null,
				"O valor total do imposto é: R$" + String.valueOf(valorTotal).replace(".", ","), "Cálculo do IMC",
				JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);
	}
}
