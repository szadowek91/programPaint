package bars.controllers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NorthBarCtrl {

    public NorthBarCtrl() {
    }

    public BufferedImage loadFile() {
        String imagePath = "outputFile.png";
        try {
            BufferedImage myPicture = ImageIO.read(new File(imagePath));
            System.out.println("IMAGE LOADED");
            return myPicture;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile(JPanel panel) {

        BufferedImage bufferedImage = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        panel.paint(bufferedImage.getGraphics());
        try {
            ImageIO.write(bufferedImage, "jpg", new File("outputFile.png"));
            System.out.println("IMAGE SAVED");
        } catch (IOException e) {
            System.out.println("Not saved" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
