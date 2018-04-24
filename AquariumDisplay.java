import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Class AquariumDisplay.
 * kelas untuk visualisasi aquarium
 * 
 * @author Muhammad Alif Arifin 13516078
 * @version 24 April 2018
 */
public class AquariumDisplay extends JPanel {

  // atribut
  private Arkavquarium arkav;
  private boolean done;
  private boolean win;
  private static final long serialVersionUID = 1L;
  
  /**
   * Constructor Aquarium.
   * 
   * @param arkav menyimpan Arkavquarium
   */
  public AquariumDisplay(Arkavquarium arkav) {
    
    // membuat focus
    setFocusable(true);
    this.arkav = arkav;
    done = false;
    win = false;

    addKeyListener(new MyKeyListener());
  }

  /**
   * Membuat program berjalan.
   */
  public void start() {
    boolean quit = false;
    double now = getTime();
    double prev;
    double elapsedTime;

    while (!quit) {
      prev = now;
      now = getTime();
      
      // perbedaan waktu setelah pergerakan terakhir
      elapsedTime = now - prev;

      // removeAll image
      arkav.getAquarium().moveAll(elapsedTime);
      paintComponent(getGraphics());

      // check win or lose
      if (arkav.getAquarium().win()) {
        win = true;
        return;
      } else if (arkav.getAquarium().lose()) {
        win = false;
        return;
      }
    }
    return;
  }

  public void done() {
    paintComponent(getGraphics());
  }

  /**
   * Mendapatkan waktu saat ini dari system.
   * 
   * @return merupakan waktu saat ini
   */
  public double getTime() {
    return System.nanoTime() / 1000000000.0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // menggambar aquarium
    BufferedImage image;

    try {
      image = ImageIO.read(new File(Aquarium.getImageAquarium()));
      g.drawImage(image, Arkavquarium.getScreenWidth() / 2, Arkavquarium.getScreenHeight() / 2,
          this);
    } catch (IOException ex) {
      System.out.println(ex);
    }

    // menggambar snail
    ListObj<Snail> listSnail = arkav.getAquarium().getListSnail();
    for (int i = 0; i < listSnail.size(); i++) {
      try {
        image = ImageIO.read(new File(listSnail.get(i).getImage()));
        g.drawImage(image, (int) listSnail.get(i).getPosition().getX(), 
            (int) listSnail.get(i).getPosition().getY(), this);
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }
    
    // menggambar piranha
    ListObj<Piranha> listPiranha = arkav.getAquarium().getListPiranha();
    for (int i = 0; i < listPiranha.size(); i++) {
      try {
        image = ImageIO.read(new File(listPiranha.get(i).getImage()));
        g.drawImage(image, (int) listPiranha.get(i).getPosition().getX(), 
            (int) listPiranha.get(i).getPosition().getY(), this);
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }
    
    // menggambar guppy
    ListObj<Guppy> listGuppy = arkav.getAquarium().getListGuppy();
    for (int i = 0; i < listGuppy.size(); i++) {
      try {
        image = ImageIO.read(new File(listGuppy.get(i).getImage()));
        g.drawImage(image, (int) listGuppy.get(i).getPosition().getX(), 
            (int) listGuppy.get(i).getPosition().getY(), this);
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }
  
    // menggambar food
    ListObj<Food> listFood = arkav.getAquarium().getListFood();
    for (int i = 0; i < listFood.size(); i++) {
      try {
        image = ImageIO.read(new File(Food.getImage()));
        g.drawImage(image, (int) listFood.get(i).getPosition().getX(), 
            (int) listFood.get(i).getPosition().getY(), this);
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }
    
    // menggambar coin
    ListObj<Coin> listCoin = arkav.getAquarium().getListCoin();
    for (int i = 0; i < listCoin.size(); i++) {
      try {
        image = ImageIO.read(new File(Coin.getImage()));
        g.drawImage(image, (int) listCoin.get(i).getPosition().getX(), 
            (int) listCoin.get(i).getPosition().getY(), this);
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }
    
    if (done) {
      if (win) {
        try {
          image = ImageIO.read(new File(Aquarium.getImageWin()));
          g.drawImage(image, Arkavquarium.getScreenWidth(), Arkavquarium.getScreenHeight(), this);
        } catch (IOException ex) {
          System.out.println(ex);
        }
      } else {
        try {
          image = ImageIO.read(new File(Aquarium.getImageLose()));
          g.drawImage(image, Arkavquarium.getScreenWidth(), Arkavquarium.getScreenHeight(), this);
        } catch (IOException ex) {
          System.out.println(ex);
        }
      }
    }
  }

  /**
   * class MyKeyListener.
   * kelas untuk mengontrol input keyboard
   * 
   * @author Muhammad Alif Arifin/13516078
   * @version 24 April 2018
   */
  public class MyKeyListener implements KeyListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyReleased(KeyEvent e) {
      
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(KeyEvent e) {
      int keycode = e.getKeyCode();
      Random rand = new Random();
      Point tempPoint;
      int tempRadius;

      switch (keycode) {
        case '1':
          // beli Guppy
          if (arkav.getAquarium().getAccount().moneyEnough(Guppy.getValueGuppy())) {
            arkav.getAquarium().getAccount().buyGuppy();
            tempRadius = Guppy.getRadiusGuppy();
            tempPoint = new Point(
              rand.nextInt(Arkavquarium.getScreenWidth() - 2 * tempRadius) - 1 + tempRadius,
              rand.nextInt(Arkavquarium.getScreenHeight() - 2 * tempRadius) - 1 + tempRadius);
            Guppy tempGuppy = new Guppy(tempPoint);
            arkav.getAquarium().add(tempGuppy);
          }
          break;
        case '2':
          // beli Piranha
          if (arkav.getAquarium().getAccount().moneyEnough(Piranha.getValuePiranha())) {
            arkav.getAquarium().getAccount().buyPiranha();
            tempRadius = Piranha.getRadiusPiranha();
            tempPoint = new Point(
              rand.nextInt(Arkavquarium.getScreenWidth() - 2 * tempRadius) - 1 + tempRadius,
              rand.nextInt(Arkavquarium.getScreenHeight() - 2 * tempRadius) - 1 + tempRadius);
            Piranha tempPiranha = new Piranha(tempPoint);
            arkav.getAquarium().add(tempPiranha);
          }
          break;
        case '4':
          // beli Egg
          if (arkav.getAquarium().getAccount().moneyEnough(Account.getValueEgg())) {
            arkav.getAquarium().getAccount().buyEgg();
          }
          break;
        default:
          //do nothing
      }
    }
  }

  /**
   * class MyMouseListener.
   * kelas untuk mengontrol input mouse
   * 
   * @author Muhammad Alif Arifin/13516078
   * @version 24 April 2018
   */
  public class MyMouseListener implements MouseListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseClicked(MouseEvent e) {
      Point mouseLocation = new Point(e.getX(), e.getY());

      boolean find = false;

      ListObj<Coin> listCoin = arkav.getAquarium().getListCoin();
      for (int i = 0; i < listCoin.size(); i++) {
        if (mouseLocation.isInRadius(listCoin.get(i).getPosition(), Coin.getRadiusCoin())) {
          find = true;
          arkav.getAquarium().getListCoin().removeIdx(i);
          break;
        }
      }

      if (!find && arkav.getAquarium().getAccount().moneyEnough(Food.getValueFood())) {
        arkav.getAquarium().getAccount().buyFood();
        Point tempPoint = new Point(e.getX(), 0);
        Food tempFood = new Food(tempPoint);
        arkav.getAquarium().getListFood().add(tempFood);
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
