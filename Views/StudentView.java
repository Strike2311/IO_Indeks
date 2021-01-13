package Views;

import javax.swing.*;

public class StudentView {
    public JTextField IdField;
    private JPanel studentPanel;
    public JLabel idLabel;
    private JButton wyswietlDaneButton;
    private JTable table1;
    public final JFrame frame;
    public StudentView() {
        frame = new JFrame("Student");
        idLabel.setVisible(true);
        frame.setContentPane(studentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public JButton getWyswietlDaneButton() {
        return wyswietlDaneButton;
    }
    public JTable get_table1(){
        return table1;
    }
}

