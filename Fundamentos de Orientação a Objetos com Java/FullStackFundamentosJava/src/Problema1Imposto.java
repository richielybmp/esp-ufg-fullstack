import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Problema1Imposto {

	public static void main(String[] args) {

		float valorDoProduto;
		int codigoDeAumento;

		valorDoProduto = Float.parseFloat(JOptionPane.showInputDialog(null, "Valor do produto", "Valor do produto",
				JOptionPane.QUESTION_MESSAGE));
		codigoDeAumento = Integer.parseInt(JOptionPane.showInputDialog(null, "Código de aumento", "Código de aumento",
				JOptionPane.QUESTION_MESSAGE));

		switch (codigoDeAumento) {
		case 1: // 10%
			valorDoProduto = valorDoProduto + (valorDoProduto * 0.1f);
			break;
		case 2: // 25%
			valorDoProduto = valorDoProduto + (valorDoProduto * 0.25f);
			break;
		case 3: // 30%
			valorDoProduto = valorDoProduto + (valorDoProduto * 0.3f);
			break;
		case 4: // 50%
			valorDoProduto = valorDoProduto + (valorDoProduto * 0.5f);
			break;
		default:
			break;
		}

		if ((valorDoProduto > 1000) && (valorDoProduto < 5000)) {
			// 1% de imposto
			JOptionPane.showMessageDialog(null,
					"Valor total com imposto de 1%: " + (valorDoProduto + (valorDoProduto * 0.01f)), "Valor total",
					JOptionPane.PLAIN_MESSAGE);
		} else if ((valorDoProduto > 5000.01) && (valorDoProduto < 10000)) {
			// 2% de imposto
			JOptionPane.showMessageDialog(null,
					"Valor total com imposto de 2%: " + (valorDoProduto + (valorDoProduto * 0.02f)), "Valor total",
					JOptionPane.PLAIN_MESSAGE);
		} else if (valorDoProduto > 10000.01) {
			// 3% de imposto
			JOptionPane.showMessageDialog(null,
					"Valor total com imposto de 3%: " + (valorDoProduto + (valorDoProduto * 0.03f)), "Valor total",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Produto sem imposto. Valor total: " + valorDoProduto, "Valor total",
					JOptionPane.PLAIN_MESSAGE);
		}
		System.exit(0);
	}
}
