package Views;

import javax.swing.*;

public class NowyAdministratorView {
    private JTextField hasloField;
    private JTextField mailField;
    private JTextField idField;
    private JLabel idLabel;
    private JLabel hasloLabel;
    private JLabel mailLabel;
    private JPanel contentPane;
    private JButton acceptButton;
    private JFrame frame;
    public NowyAdministratorView(){
        frame = new JFrame("indeks.Administrator");
        idLabel.setVisible(true);
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }

    public JTextField getHasloField() {
        return hasloField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getMailField() {
        return mailField;
    }
}
