package maintools.tools.pack;

import maintools.sizepicker.SizePicker;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Pencil {

    private static void shape(Graphics g, MouseEvent e) {
        g.fillOval(e.getX(), e.getY(), SizePicker.getSelectedSize(), SizePicker.getSelectedSize());
    }

    public static void getShape(Graphics g, MouseEvent e) {
        shape(g,e);
    }
}
