package two.gui.common;

import one.gui.ButtonPanel;

import javax.swing.*;
import java.net.URL;

public class ImageIconLoader {
    private final Class clazz;

    public ImageIconLoader(Class clazz) {
        this.clazz = clazz;
    }

    public ImageIcon load(String path) {
        //geek-cght.gif
        URL imageUrl = clazz.getResource(path);
        if (imageUrl != null) {
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            return imageIcon;
        } else {
            System.err.println("Nema ti slike na ovoj putanji: " + path);
            return null;
        }
    }
}