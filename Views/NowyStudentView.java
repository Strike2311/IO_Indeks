package Views;

import javax.swing.*;

public class NowyStudentView {
    private JLabel idLabel;
    private JLabel hasloLabel;
    private JLabel mailLabel;
    private JLabel imieLabel;
    private JLabel nazwiskoLabel;
    private JLabel wydzialLabel;
    private JLabel kierunekLabel;
    private JTextField idField;
    private JTextField hasloField;
    private JTextField mailField;
    private JTextField imieField;
    private JTextField nazwiskoField;
    private JTextField wydzialField;
    private JTextField kierunekField;
    private JButton acceptButtom;
    private JPanel contentPane;
    private final JFrame frame;
    public NowyStudentView(){
        frame = new JFrame("indeks.Student");
        idLabel.setVisible(true);
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getHasloField() {
        return hasloField;
    }

    public JTextField getImieField() {
        return imieField;
    }

    public JTextField getKierunekField() {
        return kierunekField;
    }

    public JTextField getMailField() {
        return mailField;
    }

    public JTextField getNazwiskoField() {
        return nazwiskoField;
    }

    public JTextField getWydzialField() {
        return wydzialField;
    }

    public JButton getAcceptButtom() {
        return acceptButtom;
    }
}
