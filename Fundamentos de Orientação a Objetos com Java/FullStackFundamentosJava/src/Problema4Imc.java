import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Problema4Imc {
	public static void main(String[] args) {
		String Jpeso, Jaltura;
		float peso, altura;
		double imc;

		Jpeso = JOptionPane.showInputDialog("Informe peso em kg:");
		peso = Float.parseFloat(Jpeso);

		Jaltura = JOptionPane.showInputDialog("Informe a altura em metros:");
		altura = Float.parseFloat(Jaltura);

		imc = (peso / Math.pow(altura, 2));

		JOptionPane.showMessageDialog(null, "O índice de Massa Corporal (IMC) é: " + imc, "Cálculo do IMC",
				JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);
	}
}
