package two.radio;

import two.gui.common.ImageIconLoader;

import javax.swing.*;
import java.awt.event.KeyEvent;

public enum AnimalEnum {
    BIRD("Bird.gif", true, KeyEvent.VK_B),
    CAT("Cat.gif", false, KeyEvent.VK_C),
    DOG("Dog.gif", false, KeyEvent.VK_D),
    PIG("Pig.gif", false, KeyEvent.VK_P),
    RABBIT("Rabbit.gif", false, KeyEvent.VK_R),;


    private String pictureName;
    private boolean defaultSelected;
    private int mnemonic;

    private AnimalEnum(String pictureName, boolean defaultSelected, int mnemonic){
        this.pictureName = pictureName;
        this.defaultSelected = defaultSelected;
        this.mnemonic = mnemonic;
    }

    public String getPictureName() {
        return pictureName;
    }

    public String getAnimalName(){
        //.gif = 4 karakter
        String animalName = pictureName.substring(0, pictureName.length()-4);
        return animalName;
    }

    public boolean isDefaultSelected() {
        return defaultSelected;
    }

    public int getMnemonic() {
        return mnemonic;
    }

    public ImageIcon loadImage(){
        ImageIconLoader imageIconLoader = new ImageIconLoader(AnimalPanel.class);
        ImageIcon imageIcon = imageIconLoader.load(pictureName);
        return imageIcon;
    }
}
