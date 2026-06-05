import javax.swing.*;
import java.awt.event.*;

public class CalculadoraIMC extends JFrame {

    private JTextField txtPeso;
    private JTextField txtAltura;
    private JLabel lblResultado;

    public CalculadoraIMC() {

        setTitle("Calculadora de IMC");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblPeso = new JLabel("Peso (Kg):");
        lblPeso.setBounds(20, 20, 100, 25);
        add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(120, 20, 100, 25);
        add(txtPeso);

        JLabel lblAltura = new JLabel("Altura (Cm):");
        lblAltura.setBounds(20, 60, 100, 25);
        add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(120, 60, 100, 25);
        add(txtAltura);

        JButton btnCalcular = new JButton("Calcular IMC");
        btnCalcular.setBounds(90, 100, 140, 30);
        add(btnCalcular);

        lblResultado = new JLabel("");
        lblResultado.setBounds(20, 150, 300, 50);
        add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        setVisible(true);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(txtPeso.getText());
            double alturaCm = Double.parseDouble(txtAltura.getText());

            double alturaM = alturaCm / 100;
            double imc = peso / (alturaM * alturaM);

            String classificacao;

            if (imc < 18.5) {
                classificacao = "Magreza";
            } else if (imc < 25) {
                classificacao = "Peso normal";
            } else if (imc < 30) {
                classificacao = "Sobrepeso";
            } else if (imc < 35) {
                classificacao = "Obesidade Grau I";
            } else if (imc < 40) {
                classificacao = "Obesidade Grau II";
            } else {
                classificacao = "Obesidade Grau III";
            }

            lblResultado.setText(
                String.format("IMC: %.2f - %s", imc, classificacao)
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Digite valores válidos!",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new CalculadoraIMC();
    }
}
