package Views;

import javax.swing.*;

public class NowyProwadzacyView {
    private JTextField idField;
    private JTextField hasloField;
    private JTextField mailField;
    private JTextField imieField;
    private JTextField nazwiskoField;
    private JLabel idLabel;
    private JLabel hasloLabel;
    private JLabel mailLabel;
    private JLabel imieLabel;
    private JLabel nazwiskoLabel;
    private JButton acceptButton;
    private JPanel contentPane;
    private final JFrame frame;
    public NowyProwadzacyView(){
        frame = new JFrame("indeks.Prowadzacy");
        idLabel.setVisible(true);
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JTextField getNazwiskoField() {
        return nazwiskoField;
    }

    public JTextField getMailField() {
        return mailField;
    }

    public JTextField getImieField() {
        return imieField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getHasloField() {
        return hasloField;
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }
}
