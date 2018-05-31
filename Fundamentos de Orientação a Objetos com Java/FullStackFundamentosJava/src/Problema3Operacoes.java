import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Problema3Operacoes {
	public static void main(String[] args) {

		float var1, var2, resultado;
		String Joperacao, Jnum1, Jnum2;
		resultado = 0;

		Jnum1 = JOptionPane.showInputDialog("Insira o primeiro numero");
		var1 = Float.parseFloat(Jnum1);

		Jnum2 = JOptionPane.showInputDialog("Insita o segundo numero");
		var2 = Float.parseFloat(Jnum2);

		Joperacao = JOptionPane
				.showInputDialog("Qual operação deseja? \n + Soma \n - Subtracão \n * Multiplicação \n / Divisão ");

		switch (Joperacao) {
		case "+":
			resultado = var1 + var2;
			break;
		case "-":
			resultado = var1 - var2;
			break;
		case "*":
			resultado = var1 * var2;
			break;
		case "/":
			resultado = var1 / var2;
			break;
		}

		JOptionPane.showMessageDialog(null, var1 + " " + Joperacao + " " + var2 + " = " + resultado, "Resultado",
				JOptionPane.PLAIN_MESSAGE);

		System.exit(0);
	}
}
