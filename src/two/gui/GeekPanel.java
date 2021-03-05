package two.gui;

import two.gui.common.ImageIconLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//JPanel -> FlowLayout
public class GeekPanel extends JPanel {
    private JCheckBox chinCheckBox;
    private JCheckBox glassesCheckBox;
    private JCheckBox hairCheckBox;
    private JCheckBox teethCheckBox;

    private JLabel pictureLabel;
    private StringBuffer choices;// cght -> -ght -> --ht -> ----

    public GeekPanel() {
        super(new BorderLayout());
        choices = new StringBuffer("cght");
        pictureLabel = new JLabel();
        JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));
        chinCheckBox = createCheckBox("Chin", checkBoxPanel);
        glassesCheckBox = createCheckBox("Glasses", checkBoxPanel);
        hairCheckBox = createCheckBox("Hair", checkBoxPanel);
        teethCheckBox = createCheckBox("Teeth", checkBoxPanel);
        updatePicture();
        add(checkBoxPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private JCheckBox createCheckBox(String label, JPanel panel) {
        JCheckBox checkBox = new JCheckBox(label);
        checkBox.addItemListener(new CheckBoxItemListener());
        checkBox.setSelected(true);
        panel.add(checkBox);
        return checkBox;
    }


    private void updatePicture() {
        ImageIconLoader imageIconLoader = new ImageIconLoader(GeekPanel.class);
        String pictureName = "geek-" + choices + ".gif";
        ImageIcon imageIcon = imageIconLoader.load(pictureName);
        if (imageIcon != null) {
            pictureLabel.setIcon(imageIcon);
        } else {
            pictureLabel.setText("NEMA SLIKA s imenom : " + pictureName);
        }
    }

    private class CheckBoxItemListener implements ItemListener {

        //chinCheckBox, hairCheckBox, glassesCheckBox, teethCheckBox -> {   }
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            Object source = itemEvent.getSource();
            char c = '-';
            int index = 0;
            if (source == chinCheckBox) {
                index = 0;
                c = 'c';
            } else if (source == glassesCheckBox) {
                index = 1;
                c = 'g';
            } else if (source == hairCheckBox) {
                index = 2;
                c = 'h';
            } else if (source == teethCheckBox) {
                index = 3;
                c = 't';
            }
            if (itemEvent.getStateChange() == ItemEvent.DESELECTED) {
                c = '-';
            }
            //cght
            // 2 '-'
            choices.setCharAt(index, c);
            updatePicture();
        }
    }
}
