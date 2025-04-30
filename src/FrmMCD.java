import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FrmMCD extends JFrame {

    JTextField txtNumero1, txtNumero2, txtResultado, txtResultadoR;

    public FrmMCD() {
        setSize(400, 300);
        setTitle("MCD");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNumero1 = new JLabel("Número 1");
        lblNumero1.setBounds(10, 10, 100, 25);
        getContentPane().add(lblNumero1);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(110, 10, 100, 25);
        getContentPane().add(txtNumero1);

        JLabel lblNumero2 = new JLabel("Número 2");
        lblNumero2.setBounds(10, 40, 100, 25);
        getContentPane().add(lblNumero2);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(110, 40, 100, 25);
        getContentPane().add(txtNumero2);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(10, 70, 100, 25);
        getContentPane().add(btnCalcular);
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });

        txtResultado = new JTextField();
        txtResultado.setBounds(110, 70, 100, 25);
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);

        txtResultadoR = new JTextField();
        txtResultadoR.setBounds(110, 100, 100, 25);
        txtResultadoR.setEditable(false);
        getContentPane().add(txtResultadoR);

    }

    private void calcular() {
        // obtener los datosde entrada
        int numero1 = Integer.parseInt(txtNumero1.getText());
        int numero2 = Integer.parseInt(txtNumero2.getText());

        // version iterativa
        int residuo = numero1 % numero2;
        while (residuo != 0) {
            numero1 = numero2;
            numero2 = residuo;
            residuo = numero1 % numero2;
        }

        txtResultado.setText(String.valueOf(numero2));

        // version recursiva
        txtResultadoR.setText(String.valueOf(mcd(numero1, numero2)));
    }

    private int mcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        } else {
            return mcd(n2, n1 % n2);
        }
    }

}
