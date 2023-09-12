import javax.swing.JFrame;

public class StringCalculatorMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("String Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StringCalculator calculator = new StringCalculator();
        frame.getContentPane().add(calculator.getPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
