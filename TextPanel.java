import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;

public class TextPanel extends JPanel {
    private String message;
    private int x;
    private int y;

    public TextPanel(String message, int x, int y) {
        this.x = x;
        this.y = y;
        this.message = message;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(message, x, y);
    }
}