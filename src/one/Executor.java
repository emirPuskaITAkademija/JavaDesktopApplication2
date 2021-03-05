package one;

import one.gui.ButtonPanel;

import javax.swing.*;
import java.awt.*;

/**
 * <li>1. Kontejner...JFrame, JPanel</li>
 * <li>2. UI kontrole(JButton,JCheckBox,...)</li>
 * <li>3. </li>
 */
public class Executor {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Prvi naš frejm");
        ButtonPanel buttonPanel = new ButtonPanel();
        frame.setContentPane(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
