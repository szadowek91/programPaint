package maintools.tools.pack;


import java.awt.*;

public class ColorPipette {

    public static Color getClickedColor(int x, int y) {
        try {
            Robot r = new Robot();
            return r.getPixelColor(x, y);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }


}
