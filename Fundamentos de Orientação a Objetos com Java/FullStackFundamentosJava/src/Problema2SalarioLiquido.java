import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Richiely Batista
 *
 */
public class Problema2SalarioLiquido {
	public static void main(String[] args) {

		String JqtdHoras, JsalarioHora, JqtdDependentes;
		float qtdHoras, salarioHora, salarioBruto;
		double descontoINSS, descontoIR, salarioLiquido;
		int qtdDependentes;

		JqtdHoras = JOptionPane.showInputDialog("Informe a quantidade de horas trabalhadas:");
		qtdHoras = Float.parseFloat(JqtdHoras);

		JsalarioHora = JOptionPane.showInputDialog("Informe o valor salário hora:");
		salarioHora = Float.parseFloat(JsalarioHora);

		JqtdDependentes = JOptionPane.showInputDialog("Informe a quantidade de dependentes:");
		qtdDependentes = Integer.parseInt(JqtdDependentes);

		salarioBruto = ((qtdHoras * salarioHora) + (50 * qtdDependentes));

		JOptionPane.showMessageDialog(null, "Informação dos Cálculos: \nSalário Bruto: R$" + salarioBruto,
				"Informações", JOptionPane.INFORMATION_MESSAGE);

		// desconto INSS
		descontoINSS = 0;
		if (salarioBruto <= 1000) {
			descontoINSS = (salarioBruto * 0.085);
		} else if (salarioBruto > 1000) {
			descontoINSS = (salarioBruto * 0.09);
		}

		// desconto IR
		if (salarioBruto > 500 && salarioBruto <= 1000) {
			descontoIR = (salarioBruto * 0.05);
		} else if (salarioBruto > 1000) {
			descontoIR = (salarioBruto * 0.07);
		} else {
			descontoIR = 0;
		}

		salarioLiquido = salarioBruto - descontoINSS - descontoIR;

		JOptionPane.showMessageDialog(null, "Informação dos Cálculos: \nSalário Bruto: R$" + salarioLiquido,
				"Informações", JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);
	}
}
