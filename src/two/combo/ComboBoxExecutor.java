package two.combo;

import two.radio.AnimalPanel;
import two.radio.RadioGuiExecutor;

import javax.swing.*;

public class ComboBoxExecutor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ComboBoxExecutor::createGUI);
    }

    static void createGUI(){
        System.out.println(Thread.currentThread());
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ComboBoxPanel comboBoxPanel = new ComboBoxPanel();
        frame.setContentPane(comboBoxPanel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

}
