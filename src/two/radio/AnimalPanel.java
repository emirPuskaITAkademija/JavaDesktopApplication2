package two.radio;

import two.gui.common.ImageIconLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AnimalPanel extends JPanel {

    private JLabel pictureLabel;

    public AnimalPanel() {
        super(new BorderLayout());
        pictureLabel = new JLabel();
        GridLayout gridLayout = new GridLayout(0, 1);
        JPanel radioButtonPanel = new JPanel(gridLayout);
        ButtonGroup buttonGroup = new ButtonGroup();
        AnimalEnum[] animalEnums = AnimalEnum.values();
        for (AnimalEnum animalEnum : animalEnums) {
            JRadioButton radioButton = new JRadioButton(animalEnum.getAnimalName());
            radioButton.setMnemonic(animalEnum.getMnemonic());
            //IME SLIKE mi je Action Commanda
            radioButton.setActionCommand(animalEnum.getPictureName());
            radioButton.setSelected(animalEnum.isDefaultSelected());
            buttonGroup.add(radioButton);
            if (animalEnum.isDefaultSelected()) {
                ImageIcon imageIcon = animalEnum.loadImage();
                pictureLabel.setIcon(imageIcon);
            }
            radioButton.addActionListener(this::onRadioButtonClick);
            radioButtonPanel.add(radioButton);
        }
        add(radioButtonPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    public void onRadioButtonClick(ActionEvent actionEvent) {
        String pictureName = actionEvent.getActionCommand();
        ImageIconLoader imageIconLoader = new ImageIconLoader(AnimalPanel.class);
        ImageIcon imageIcon = imageIconLoader.load(pictureName);
        pictureLabel.setIcon(imageIcon);
    }

    /*private class RadioButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String pictureName = actionEvent.getActionCommand();
            ImageIconLoader imageIconLoader = new ImageIconLoader(AnimalPanel.class);
            ImageIcon imageIcon = imageIconLoader.load(pictureName);
            pictureLabel.setIcon(imageIcon);
        }
    }*/

}
