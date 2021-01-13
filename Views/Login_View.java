package Views;

import javax.swing.*;
import java.awt.*;

public class Login_View {
    private final JFrame frame;
    private JPanel dataPane;
    private JPanel loginPane;
    private JLabel loginLabel;
    private JTextField loginField;
    private JPanel passwordPane;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JPanel buttonPane;
    private JButton loginButton;
    private JComboBox loginBox;

    public Login_View() {
        frame = new JFrame("Logowanie");
        loginBox.addItem("Student");
        loginBox.addItem("Prowadzacy");
        loginBox.addItem("Administrator");

        frame.setContentPane(dataPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
    public JComboBox getLoginBox(){return loginBox;}

    public void dispose() {
        frame.dispose();
    }
}
