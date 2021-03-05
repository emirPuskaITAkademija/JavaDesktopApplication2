package two;

import javax.swing.*;
import java.awt.*;

/**
 * <li>1. Kontejnerska ...JFrame(BorderLayout), JPanel</li>
 * <li>2. UI controls .... JButton, JCheckBox, JRadioButton,
 * JComboBox, JTextField....</li>
 * <li>3. LayoutManager .... BorderLayout, FlowLayout, GridLayout, BoxLayout..</li>
 */
public class Executor {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton btn1 = new JButton("Hello");
        JButton btn2 = new JButton("World");
        SpringLayout springLayout = new SpringLayout();
        frame.setLayout(springLayout);
        frame.add(btn1);
        //frame.add(btn2);
        springLayout.putConstraint(SpringLayout.WEST, btn1, 50, SpringLayout.WEST, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, btn1, 100, SpringLayout.NORTH, frame.getContentPane());

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
