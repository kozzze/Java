
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ColorAction implements ActionListener {
        private JPanel panel;
        private Color color;
    public ColorAction(JPanel panel, Color color) {
        this.panel = panel;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.setBackground(color);
    }
}