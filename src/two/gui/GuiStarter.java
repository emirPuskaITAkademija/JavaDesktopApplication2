package two.gui;

import javax.swing.*;

public class GuiStarter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuiStarter::createGUI);
    }

    static void createGUI(){
        System.out.println(Thread.currentThread());
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GeekPanel geekPanel = new GeekPanel();
        frame.setContentPane(geekPanel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
