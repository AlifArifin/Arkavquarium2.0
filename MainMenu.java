import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.InterruptedException;
import java.lang.System;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class MainMenu.
 * kelas untuk visualisasi main menu
 * 
 * @author Muhammad Alif Arifin 13516078
 * @version 24 April 2018
 */
public class MainMenu extends JPanel {

  // atribut
  private Arkavquarium arkav;
  private boolean done = false;

  private static final long serialVersionUID = 1L;
  
  /**
   * Constructor Aquarium.
   * 
   * @param arkav menyimpan Arkavquarium
   */
  public MainMenu(Arkavquarium arkavNew) {
    // membuat focus
    setFocusable(true);
    this.arkav = arkavNew;

    addMouseListener(new MyMouseListenerMenu());
  }

  public boolean start() {
    while(!done) {
      System.out.println(done);
      if (done) {
        System.out.println("done");
        return true;
      }
    }
    return done;
  }

  @Override
  protected void paintComponent(Graphics g1) {
    Graphics2D g = (Graphics2D)g1;
    super.paintComponent(g);

    BufferedImage image;
    try {
      image = ImageIO.read(new File("img/mainmenu.png"));
      g.drawImage(image, 0, 0, this);
    } catch (IOException ex) {
      System.out.println(ex);
    }
  }

  /**
   * class MyMouseListener.
   * kelas untuk mengontrol input mouse
   * 
   * @author Muhammad Alif Arifin/13516078
   * @version 24 April 2018
   */
  public class MyMouseListenerMenu implements MouseListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseClicked(MouseEvent e) {
      if (e.getY() > 420 && e.getY() < 463 && e.getX() > 204 && e.getX() < 437) {
        done = true;
      }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
      
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
      
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
      
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
      
    }
  }
}