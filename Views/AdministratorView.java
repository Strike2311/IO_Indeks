package Views;

import javax.swing.*;

public class AdministratorView {
    private JLabel idLabel;
    private JTextField idField;
    private JButton aktualizujDaneUzytkownikaButton;
    private JButton dodajStudentaButton;
    private JButton dodajProwadzacegoButton;
    private JButton dodajNowegoAdministratoraButton;
    private JPanel AdministratorPane;
    private JButton modyfikujStudentaButton;
    private JButton modyfikujProwadzacegoButton;
    private JButton modyfikujAdministratoraButton;
    private JLabel idUzytkownikaLabel;
    private JTextField idUzytkownikaField;
    private final JFrame frame;
    public AdministratorView(){
        frame = new JFrame("Administrator");
        idLabel.setVisible(true);
        frame.setContentPane(AdministratorPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getIdUzytkownikaField() {
        return idUzytkownikaField;
    }

    public JButton getModyfikujStudentaButton() {
        return modyfikujStudentaButton;
    }

    public JButton getModyfikujAdministratoraButton() {
        return modyfikujAdministratoraButton;
    }

    public JButton getModyfikujProwadzacegoButton() {
        return modyfikujProwadzacegoButton;
    }

    public JButton getDodajStudentaButton() {
        return dodajStudentaButton;
    }

    public JButton getDodajProwadzacegoButton() {
        return dodajProwadzacegoButton;
    }

    public JButton getDodajNowegoAdministratoraButton() {
        return dodajNowegoAdministratoraButton;
    }
}
