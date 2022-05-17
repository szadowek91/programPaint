package main;

import bars.NorthBar;
import bars.SouthBar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private DrawField drawField;
    private SouthBar southBar;
    private NorthBar northBar;

    public MainFrame() {


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        initComponents();
        initView();
    }

    private void initComponents() {
        drawField = new DrawField(this);
        southBar = new SouthBar(this);
        northBar = new NorthBar(this);
    }

    private void initView() {
        add(drawField, BorderLayout.CENTER);
        add(southBar, BorderLayout.SOUTH);
        add(northBar, BorderLayout.NORTH);
    }

    private void initActions() {
    }

    public DrawField getDrawField() {
        return drawField;
    }

    public SouthBar getSouthBar() {
        return southBar;
    }
}
