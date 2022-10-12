package main;

import bars.NorthBar;
import bars.SouthBar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private DrawField drawField;
    private SouthBar southBar;
    private NorthBar northBar;
    private static int width = 800;
    private static int height = 600;

    public MainFrame() {


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(width, height);
        setLayout(new BorderLayout());
        initComponents();
        initView();
    }

    private void initComponents() {
        drawField = new DrawField(this);
        southBar = new SouthBar(this);
        northBar = new NorthBar( this,drawField);
    }

    private void initView() {
        add(drawField, BorderLayout.CENTER);
        add(southBar, BorderLayout.SOUTH);
        add(northBar, BorderLayout.NORTH);
    }

    private void initActions() {

    }
    public SouthBar getSouthBar() {
        return southBar;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
