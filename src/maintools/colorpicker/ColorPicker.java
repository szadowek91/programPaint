package maintools.colorpicker;

import maintools.colorpicker.model.PaintColor;
import utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import static javax.swing.SwingUtilities.*;

public class ColorPicker extends JPanel {

    private static Color pickedColorMouse1;

    private static Color pickedColorMouse3;

    private static JPanel selectedColorMouse1;

    private static JPanel selectedColorMouse3;

    public ColorPicker() {
        pickedColorMouse1 = Color.BLACK;
        pickedColorMouse3 = Color.WHITE;
        initView();
        setBorder(BorderFactory.createTitledBorder("Color Picker"));
    }

    private void initView() {
        setLayout(new SpringLayout());
        Arrays.asList(PaintColor.values()).forEach(pc -> {
            JButton colorButton = new JButton();
            colorButton.setBackground(pc.getColor());
            colorButton.addMouseListener(mouseListener(pc));
            add(colorButton);
        });
        JButton moreColors = new JButton("More colors");
        moreColors.addMouseListener(moreColors());
        add(moreColors);

        selectedColorMouse1 = new JPanel();
        selectedColorMouse1.setBackground(pickedColorMouse1);
        selectedColorMouse1.setName("Color 1");
        JLabel nameLabelColor1 = new JLabel();
        nameLabelColor1.setText(selectedColorMouse1.getName());
        selectedColorMouse1.add(nameLabelColor1);
        add(selectedColorMouse1);

        selectedColorMouse3 = new JPanel();
        selectedColorMouse3.setBackground(pickedColorMouse3);
        selectedColorMouse3.setName("Color 2");
        JLabel nameLabelColor3 = new JLabel();
        nameLabelColor3.setText(selectedColorMouse3.getName());
        selectedColorMouse3.add(nameLabelColor3);
        add(selectedColorMouse3);

        SpringUtilities.makeCompactGrid(this, 1, PaintColor.values().length + 3, 5, 5, 5, 5);
    }


    private MouseListener mouseListener(PaintColor pcm) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (isLeftMouseButton(e)) {
                    pickedColorMouse1 = pcm.getColor();
                    selectedColorMouse1.setBackground(pickedColorMouse1);
                }
                if (isRightMouseButton(e)) {
                    pickedColorMouse3 = pcm.getColor();
                    selectedColorMouse3.setBackground(pickedColorMouse3);
                }
            }
        };
    }

    private MouseListener moreColors() {
        return new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (isMiddleMouseButton(e)) {
                    return;
                }
                if (isLeftMouseButton(e)) {
                    pickedColorMouse1 = JColorChooser.showDialog(ColorPicker.this, "More colors", pickedColorMouse1);
                    selectedColorMouse1.setBackground(pickedColorMouse1);
                } else if (isRightMouseButton(e)) {
                    pickedColorMouse3 = JColorChooser.showDialog(ColorPicker.this, "More colors", pickedColorMouse3);
                    selectedColorMouse3.setBackground(pickedColorMouse3);
                }
            }
        };
    }

    private static Color getPickedColorMouse1() {
        return pickedColorMouse1;
    }

    private static Color getPickedColorMouse3() {
        return pickedColorMouse3;
    }

    private static void setPickedColorMouse1(Color pickedColorMouse1) {
        ColorPicker.pickedColorMouse1 = pickedColorMouse1;
    }

    private static void setPickedColorMouse3(Color pickedColorMouse3) {
        ColorPicker.pickedColorMouse3 = pickedColorMouse3;
    }

    public static void setPickedColor(Color clickedColor, MouseEvent e) {
        if (isLeftMouseButton(e)) {
            ColorPicker.setPickedColorMouse1(clickedColor);
            ColorPicker.selectedColorMouse1.setBackground(clickedColor);
        }
        else if (isRightMouseButton(e)) {
            ColorPicker.setPickedColorMouse3(clickedColor);
            ColorPicker.selectedColorMouse3.setBackground(clickedColor);
        }
    }

    public static Color getPickedColor(MouseEvent e){

        if (isLeftMouseButton(e)) return ColorPicker.getPickedColorMouse1();
        else if (isRightMouseButton(e)) return ColorPicker.getPickedColorMouse3();
        return null;
    }

}
