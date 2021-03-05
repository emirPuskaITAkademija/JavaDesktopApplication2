package two.radio;

import javax.swing.*;

public class RadioGuiExecutor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RadioGuiExecutor::createGUI);
    }

    static void createGUI(){
        System.out.println(Thread.currentThread());
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AnimalPanel animalPanel = new AnimalPanel();
        frame.setContentPane(animalPanel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
