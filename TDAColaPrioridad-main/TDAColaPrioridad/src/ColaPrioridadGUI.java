import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaPrioridadGUI {
    private JPanel pGeneral;
    private JTextField txtElemento;
    private JTextField txtPrioridad;
    private JTextArea txtResultado;
    private JButton añadirButton;
    private JButton mostrarButton;

    ColaPrioridad cola = new ColaPrioridad();

    public ColaPrioridadGUI() {
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cola.mostrar(txtResultado);
            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtElemento.getText();
                String priorityInput = txtPrioridad.getText();
                try {
                    int prioridad = Integer.parseInt(priorityInput);
                    cola.añadir(nombre, prioridad);
                    txtElemento.setText("");
                    txtPrioridad.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce una prioridad válida (número entero).");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColaPrioridadGUI");
        frame.setContentPane(new ColaPrioridadGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
