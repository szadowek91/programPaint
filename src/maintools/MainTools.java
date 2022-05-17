package maintools;

import maintools.colorpicker.ColorPicker;
import maintools.sizepicker.SizePicker;
import maintools.tools.OtherTools;

import javax.swing.*;

public class MainTools extends JPanel {

    private ColorPicker colorPicker;

    private SizePicker sizePicker;

    private OtherTools otherTools;

    public MainTools(){
        colorPicker = new ColorPicker();
        add(colorPicker);
        sizePicker = new SizePicker();
        add(sizePicker);
        otherTools = new OtherTools();
        add(otherTools);
    }
}
