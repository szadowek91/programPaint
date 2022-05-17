package maintools.sizepicker;

import javax.swing.*;
import java.util.stream.IntStream;

public class SizePicker extends JComboBox {

    private final int min = 3;
    private final int max = 40;

    private static int selectedSize = 8;

    public SizePicker() {
        setBorder(BorderFactory.createTitledBorder("Size"));
        IntStream.rangeClosed(min, max).boxed().forEach(this::addItem);
        setSelectedIndex(selectedSize-min);
        this.addActionListener(e -> {
            if (getSelectedIndex() > -1 ){
                selectedSize = (int)getSelectedItem();
            }
        });
    }

    public static int getSelectedSize() {
        return selectedSize;
    }
}
