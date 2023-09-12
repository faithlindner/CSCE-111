import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StringCalculator {
    private JPanel panel;
    private JButton clearButton;
    private JButton addButton;
    private JButton subtractButton;
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resLabel;

    public StringCalculator() {
        panel = new JPanel(new GridBagLayout());

        // Set up components
        JLabel num1Label = new JLabel("Number 1:");
        JLabel num2Label = new JLabel("Number 2:");
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        clearButton = new JButton("Clear");
        resLabel = new JLabel();

        // Add components to panel
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(num1Label, c);
        c.gridx = 1;
        panel.add(num1Field, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(num2Label, c);
        c.gridx = 1;
        panel.add(num2Field, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(addButton, c);
        c.gridx = 1;
        panel.add(subtractButton, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(clearButton, c);
        c.gridx = 1;
        panel.add(resLabel, c);

        // Add action listeners to buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                String num1 = num1Field.getText();
                String num2 = num2Field.getText();
                try {
                    long res = add(num1, num2);
                    resLabel.setText(String.valueOf(res));
                } catch (NumberFormatException ex) {
                    resLabel.setText("NAN");
                }
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                String num1 = num1Field.getText();
                String num2 = num2Field.getText();
                try {
                    long res = subtract(num1, num2);
                    resLabel.setText(String.valueOf(res));
                } catch (NumberFormatException ex) {
                    resLabel.setText("NAN");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                num1Field.setText("");
                num2Field.setText("");
                resLabel.setText("");
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    private long add(String str1, String str2) {
        return Long.parseLong(str1) + Long.parseLong(str2);
    }

    private long subtract(String str1, String str2) {
        return Long.parseLong(str1) - Long.parseLong(str2);
    }
}
