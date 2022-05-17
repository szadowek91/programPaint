package maintools.tools.pack;


import java.awt.*;

public class ColorPipette {

    public static Color getClickedColor() {
        try {
            int xValue = MouseInfo.getPointerInfo().getLocation().x;
            int yValue = MouseInfo.getPointerInfo().getLocation().y;
            Robot robot = new Robot();
            return robot.getPixelColor(xValue, yValue);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }


}
