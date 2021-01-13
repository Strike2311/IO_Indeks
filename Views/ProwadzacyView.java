package Views;

import javax.swing.*;

public class ProwadzacyView {
    private JLabel idLabel;
    private JButton wyswietlDaneSButton;
    private JTextField idStudentaField;
    private JButton aktualizujOcenyStudentaOButton;
    private JTextField kursField;
    private JLabel kursLabel;
    private JTextField ocenaField;
    private JLabel ocenaLabel;
    private JPanel contentPane;
    private JTextField idField;
    private final JFrame frame;
    public ProwadzacyView() {
        frame = new JFrame("Prowadzący");
        idLabel.setVisible(true);
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public JButton getAktualizujOcenyStudentaOButton() {
        return aktualizujOcenyStudentaOButton;
    }

    public JButton getWyswietlDaneSButton() {
        return wyswietlDaneSButton;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public JLabel getKursField() {
        return kursLabel;
    }
    public JLabel getOcenaLabel(){
        return ocenaLabel;
    }
    public JTextField getIdStudentaField(){
        return idStudentaField;
    }
    public JTextField getIdField(){
        return idField;
    }
}

