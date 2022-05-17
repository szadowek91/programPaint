package maintools.tools;

import maintools.tools.pack.ColorPipette;

import javax.swing.*;

public class OtherTools extends JPanel {


    private JToggleButton isPencilSelected;
    private JToggleButton isRubberSelected;
    private JToggleButton isPipetteSelected;
    private static boolean isPencil = false;
    private static boolean isRubber = false;
    private static boolean isPipette = false;

    public static boolean isPencil() {
        return isPencil;
    }

    public static boolean isRubber() {
        return isRubber;
    }

    public static boolean isPipette() {
        return isPipette;
    }

    public OtherTools() {
        initComponents();
        initActions();
        setBorder(BorderFactory.createTitledBorder("Tools"));
    }

    private void initComponents() {

        isPencilSelected = new JToggleButton("Pencil", false);
        add(isPencilSelected);
        isRubberSelected = new JToggleButton("Rubber", false);
        add(isRubberSelected);
        isPipetteSelected = new JToggleButton("Pipette", false);
        add(isPipetteSelected);
    }

    private void initView() {
    }

    private void initActions() {
        isPencilSelected.addActionListener(e -> {
            isPencil = isPencilSelected.isSelected();
            isRubberSelected.setSelected(false);
            isRubber = false;
            isPipetteSelected.setSelected(false);
            isPipette = false;
        });
        isRubberSelected.addActionListener(e -> {
            isRubber = isRubberSelected.isSelected();
            isPencilSelected.setSelected(false);
            isPencil = false;
            isPipetteSelected.setSelected(false);
            isPipette = false;
        });
        isPipetteSelected.addActionListener(e -> {

            isPipette = isPipetteSelected.isSelected();
            isRubberSelected.setSelected(false);
            isRubber = false;
            isPencilSelected.setSelected(false);
            isPencil = false;
        });
    }
}
