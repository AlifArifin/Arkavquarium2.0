import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private int x;
    private int y;

    public ImagePanel(String path, int x, int y) {
        this.x = x;
        this.y = y;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, this);
    }
}