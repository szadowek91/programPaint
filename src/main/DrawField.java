package main;

import maintools.colorpicker.ColorPicker;
import maintools.tools.OtherTools;
import maintools.tools.pack.Pencil;
import maintools.tools.pack.Rubber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.SwingUtilities.isMiddleMouseButton;
import static maintools.tools.pack.ColorPipette.getClickedColor;

public class DrawField extends JPanel {

    private MainFrame mainFrame;


    public DrawField(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        initMouseMotions();
        setBackground(Color.WHITE);

    }


    public void initMouseMotions() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mouseClickedMethod(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                mouseDraggedMethod(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseMovedMethod(e);
            }
        });
    }

    private void mouseClickedMethod(MouseEvent e) {
        ColorPicker.setPickedColor(getClickedColor(e.getX(), e.getY()), e);
    }

    public void mouseDraggedMethod(MouseEvent e) {
        if (isMiddleMouseButton(e)) return;

        Graphics g = getGraphics();
        g.setColor(ColorPicker.getPickedColor(e));
        selectedShape(g, e);
        mainFrame.getSouthBar().setMouseLocation(e.getX(), e.getY());
    }

    private void selectedShape(Graphics g, MouseEvent e) {
        if (OtherTools.isPencil()) {
            Pencil.getShape(g, e);
        }
        else if (OtherTools.isRubber()) {
            Rubber.getShape(g, e);
        }
    }

    public void mouseMovedMethod(MouseEvent e) {
        mainFrame.getSouthBar().setMouseLocation(e.getX(), e.getY());
    }
}
