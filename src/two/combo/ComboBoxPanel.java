package two.combo;

import two.gui.common.ImageIconLoader;
import two.radio.AnimalEnum;
import two.radio.AnimalPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComboBoxPanel extends JPanel {

    private JLabel pictureLabel;
    private JComboBox<String> animalComboBox;

    public ComboBoxPanel() {
        super(new BorderLayout());
        pictureLabel = new JLabel();
        pictureLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pictureLabel.setHorizontalAlignment(JLabel.CENTER);
        AnimalEnum[] animals = AnimalEnum.values();
        String[] animalPictureNames = Stream.of(animals)//Stream<AnimalEnum>
                .map(AnimalEnum::getAnimalName)//Stream<String>
                .collect(Collectors.toList())
                .toArray(String[]::new);
        animalComboBox = new JComboBox<>(animalPictureNames);
        animalComboBox.addActionListener(this::onComboBoxItemSelect);
        animalComboBox.setSelectedIndex(0);

        updatePicture();

        add(animalComboBox, BorderLayout.NORTH);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private void updatePicture() {
        ImageIconLoader imageIconLoader = new ImageIconLoader(AnimalPanel.class);
        String animalName =(String) animalComboBox.getSelectedItem();
        String pictureName = animalName+".gif";
        ImageIcon imageIcon = imageIconLoader.load(pictureName);
        pictureLabel.setIcon(imageIcon);
    }

    public void onComboBoxItemSelect(ActionEvent actionEvent) {
        updatePicture();
    }
}
