import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LancamentoOblquo extends JFrame implements ActionListener {
    private JLabel lblV0, lblAngulo, lblG, lblResultado;
    private JTextField txtV0, txtAngulo, txtG, txtResultado;
    private JButton btnCalcularX, btnCalcularY;

    public LancamentoOblquo() {
        super("Calculadora de Lançamento Oblíquo");

        // Cria os componentes
        lblV0 = new JLabel("Velocidade Inicial (m/s):");
        lblAngulo = new JLabel("Ângulo de Lançamento (graus):");
        lblG = new JLabel("Aceleração da Gravidade (m/s²):");
        lblResultado = new JLabel("Resultado (m):");

        txtV0 = new JTextField(10);
        txtAngulo = new JTextField(10);
        txtG = new JTextField(10);
        txtResultado = new JTextField(10);
        txtResultado.setEditable(false);

        btnCalcularX = new JButton("Calcular no eixo X");
        btnCalcularX.addActionListener(this);

        btnCalcularY = new JButton("Calcular no eixo Y");
        btnCalcularY.addActionListener(this);

        // Cria o painel de entrada
        JPanel pnlEntrada = new JPanel(new GridLayout(4, 2, 5, 5));
        pnlEntrada.add(lblV0);
        pnlEntrada.add(txtV0);
        pnlEntrada.add(lblAngulo);
        pnlEntrada.add(txtAngulo);
        pnlEntrada.add(lblResultado);
        pnlEntrada.add(txtResultado);

        // Cria o painel de botão
        JPanel pnlBotoes = new JPanel();
        pnlBotoes.add(btnCalcularX);
        pnlBotoes.add(btnCalcularY);

        // Cria o painel principal
        JPanel pnlPrincipal = new JPanel(new BorderLayout(5, 5));
        pnlPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlPrincipal.add(pnlEntrada, BorderLayout.CENTER);
        pnlPrincipal.add(pnlBotoes, BorderLayout.SOUTH);

        // Configura a janela
        setContentPane(pnlPrincipal);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnCalcularX) {
        try {
            double v0 = Double.parseDouble(txtV0.getText());
            double angulo = Double.parseDouble(txtAngulo.getText());

            double resultado = classX.calcularObliquoX(v0, angulo);

            txtResultado.setText(String.format("%.2f", resultado) + " m/s");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.");
        }
    } else if (e.getSource() == btnCalcularY) {
        try {
            double v0 = Double.parseDouble(txtV0.getText());
            double angulo = Double.parseDouble(txtAngulo.getText());

            double resultado = classY.calcularObliquoY(v0, angulo);

            txtResultado.setText(String.format("%.2f", resultado) + " m/s");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.");
        }
    }
}

public static void main(String[] args) {
    LancamentoOblquo lo = new LancamentoOblquo();
    lo.setVisible(true);
    }
}