package ClaspSelectorAssistant;

import javax.swing.*;
import java.awt.*;

public class StaticArchLabel  extends JLabel{

    public StaticArchLabel(ImageIcon image) {
        super(image);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Integer index = 1; index < 33; index++) {
            ArchLabel.circleMap.get(index).paintCircle(g);
        }
    }
}
