package bars;

import main.MainFrame;

import javax.swing.*;
import java.awt.*;

public class SouthBar extends JMenuBar {

    private JLabel coordinatesLabel;
    private MainFrame mainFrame;

    public SouthBar(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        initView();
        initActions();
    }

    private void initComponents(){
        coordinatesLabel = new JLabel("tt");
    }
    private void initView(){
        add(coordinatesLabel);
        setBackground(Color.LIGHT_GRAY);
    }
    private void initActions(){}

    public void setMouseLocation(int x, int y){
        coordinatesLabel.setText("X=" + x + ", Y=" + y);
    }

}
