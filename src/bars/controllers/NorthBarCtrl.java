package bars.controllers;

import bars.NorthBar;
import main.DrawField;
import main.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NorthBarCtrl {

    private NorthBar northBar;
    private DrawField drawField;

    private MainFrame mainFrame;

    public NorthBarCtrl(NorthBar northBar, MainFrame mainFrame, DrawField drawField) {
        this.northBar = northBar;
        this.mainFrame = mainFrame;
        this.drawField = drawField;
    }

    public void loadFile() {
        System.out.println("LOAD");
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
