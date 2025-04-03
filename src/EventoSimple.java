import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventoSimple {
    public static void main(String[] args) {
        // Creamos la ventana principal (JFrame)
        JFrame frame = new JFrame("Ejemplo de GUI con Eventos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 250);
        frame.setResizable(false);
        
        // Centramos la ventana en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Creamos un panel principal con BoxLayout para distribuir verticalmente los sub-paneles
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Panel superior: contiene el campo de texto
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JTextField textField = new JTextField(20);
        topPanel.add(textField);
        
        // Panel central: contiene los botones "Mostrar Texto" y "Limpiar"
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JButton clearButton = new JButton("Limpiar pantalla");
        JButton showButton = new JButton("Mostrar Texto");
       
        centerPanel.add(clearButton);
        centerPanel.add(showButton);
        
        
        // Panel inferior: contiene la etiqueta para mostrar el resultado
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel label = new JLabel("Resultado: ");
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        bottomPanel.add(label);
        
        // Agregamos los sub-paneles al panel principal
        mainPanel.add(topPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(bottomPanel);
        
        // Controlador de eventos para el botón "Mostrar Texto"
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField.getText();
                // Cambia la fuente y color de la etiqueta para resaltar el mensaje
                label.setFont(new Font("Arial", Font.BOLD, 16));
                label.setForeground(new Color(0, 102, 204)); // Azul
                label.setText("Resultado: " + texto);
            }
        });
        
        // Controlador de eventos para el botón "Limpiar"
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpia el campo de texto y restablece la etiqueta a su estado inicial
                textField.setText("");
                label.setFont(new Font("Arial", Font.PLAIN, 14));
                label.setForeground(Color.BLACK);
                label.setText("Resultado: ");
            }
        });
        
        // Controlador de eventos para detectar pulsaciones de teclas en el campo de texto
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Tecla presionada: " + e.getKeyChar());
            }
        });
        
        // Agrega el panel principal a la ventana y la hace visible
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
