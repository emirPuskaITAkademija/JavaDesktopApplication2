package one.gui;

import two.gui.common.ImageIconLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

/**
 * 1. Kontejnerska komponenta -> ButtonPanel(JPanel)
 * 2. JButton -> UI kontrole
 * 3. LayoutManager -> FlowLayout
 * <p>
 * int number;
 */
public class ButtonPanel extends JPanel {
    private JButton leftButton;
    private JButton middleButton;
    private JButton rightButton;

    public ButtonPanel() {
        ActionListener buttonActionListener = new ButtonActionListener();
        ImageIconLoader iconLoader = new ImageIconLoader(ButtonPanel.class);

        this.leftButton = new JButton("Disable middle button");
        this.leftButton.setToolTipText("Ovo je moj lijevi dugmić");
        this.leftButton.setActionCommand("disable");
        this.leftButton.setMnemonic(KeyEvent.VK_D);
        ImageIcon rightIcon = iconLoader.load("right.gif");
        this.leftButton.addActionListener(buttonActionListener);
        this.leftButton.setHorizontalTextPosition(SwingConstants.LEADING);
        this.leftButton.setVerticalTextPosition(SwingConstants.CENTER);
        this.leftButton.setIcon(rightIcon);


        this.middleButton = new JButton("Victim");
        this.middleButton.setToolTipText("Ovo je moja žrtva");
        ImageIcon middleIcon = iconLoader.load("middle.gif");
        this.middleButton.setHorizontalTextPosition(SwingConstants.CENTER);
        this.middleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.middleButton.setIcon(middleIcon);

        this.rightButton = new JButton("Enable middle button");
        this.rightButton.setToolTipText("Ovo je moj desni dugmić");
        this.rightButton.setActionCommand("enable");
        this.rightButton.setMnemonic(KeyEvent.VK_E);
        this.rightButton.addActionListener(buttonActionListener);
        ImageIcon leftIcon = iconLoader.load("left.gif");
        this.rightButton.setIcon(leftIcon);

        add(leftButton);
        add(middleButton);
        add(rightButton);
    }


    //ButtonActionListener listener = new Button...();
    //leftButton.addActionListener(listener)
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if ("disable".equals(event.getActionCommand())) {
                middleButton.setEnabled(false);
            } else {
                middleButton.setEnabled(true);
            }
        }
    }


}
