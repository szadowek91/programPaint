package maintools.colorpicker.model;

import java.awt.*;

public enum PaintColor {

    WHITE(Color.WHITE),
    BLACK(Color.BLACK),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    RED(Color.RED);

    private Color color;

    public Color getColor() {
        return color;
    }

    PaintColor(Color color) {
        this.color = color;
    }
}
