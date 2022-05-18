package bars;

import bars.controllers.NorthBarCtrl;
import main.DrawField;
import main.MainFrame;
import maintools.MainTools;

import javax.swing.*;
import java.awt.*;

public class NorthBar extends JMenuBar {

    private JMenu file;
    private JMenuItem load;
    private JMenuItem save;

    private MainFrame mainframe;
    private NorthBarCtrl northBarCtrl;

    private JTabbedPane northTP;

    private MainTools mainTools;

    private DrawField drawField;

    public NorthBar(MainFrame mainframe ,DrawField drawField) {
        this.mainframe = mainframe;
        this.drawField = drawField;
        this.northBarCtrl = new NorthBarCtrl();
        initComponents();
        initView();
        initActions();
    }

    private void initComponents() {
        file = new JMenu("File");
        load = new JMenuItem("Load");
        save = new JMenuItem("Save");
        northTP = new JTabbedPane();
        mainTools = new MainTools();
    }

    private void initView() {
        add(file);
        file.add(load);
        file.add(save);
        add(northTP);
        northTP.add("Main Tools", mainTools);
        northTP.add("View", new JPanel());
        file.setOpaque(true);
        file.setBackground(Color.CYAN);

    }

    private void initActions() {
        load.addActionListener(e -> northBarCtrl.loadFile());
        save.addActionListener(e -> northBarCtrl.saveFile(drawField)); //TODO - saving background only!

    }
}
