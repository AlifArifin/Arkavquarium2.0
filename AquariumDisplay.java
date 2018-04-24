import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
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
 * Class AquariumDisplay.
 * kelas untuk visualisasi aquarium
 * 
 * @author Muhammad Alif Arifin 13516078
 * @version 24 April 2018
 */
public class AquariumDisplay extends JPanel {

  // atribut
  private Arkavquarium arkav;
  private boolean menu;
  private boolean done;
  private boolean win;
  private static final long serialVersionUID = 1L;
  
  /**
   * Constructor Aquarium.
   * 
   * @param arkavNew menyimpan Arkavquarium
   */
  public AquariumDisplay(Arkavquarium arkavNew) {
    super();
    // membuat focus
    setFocusable(true);
    this.arkav = arkavNew;
    done = false;
    win = false;
    menu = true;

    addKeyListener(new MyKeyListener());
    addMouseListener(new MyMouseListener());
  }

  /**
   * Membuat program berjalan.
   */
  public void start() {
    boolean quit = false;
    double now = getTime();
    double prev;
    double elapsedTime;
    // Timer timer = new Timer(40, this);

    while (!quit) {
      if (menu) {
        repaint();
      } else {
        prev = now;
        now = getTime();
        
        // perbedaan waktu setelah pergerakan terakhir
        elapsedTime = now - prev;
        
        // removeAll image
        arkav.getAquarium().moveAll(elapsedTime);
        //paintComponent(getGraphics());

        // check win or lose
        if (arkav.getAquarium().win()) {
          done = true;
          win = true;
          repaint();
          return;
        } else if (arkav.getAquarium().lose()) {
          done = true;
          win = false;
          repaint();
          return;
        } else {
          repaint();
        }
      }
    }
    return;
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
  protected void paintComponent(Graphics g1) {
    Graphics2D g = (Graphics2D)g1;
    super.paintComponent(g);

    // menggambar aquarium
    BufferedImage image;
    
    if (menu) {
      try {
        image = ImageIO.read(new File("img/mainmenu.png"));
        g.drawImage(image, 0, 0, this);
      } catch (IOException ex) {
        System.out.println(ex);
      }  
    } else {
      
      try {
        image = ImageIO.read(new File(Arkavquarium.getImageMenubar()));
        g.drawImage(image, 0, 0, this);
      } catch (IOException ex) {
        System.out.println(ex);
      }

      try {
        image = ImageIO.read(new File(Arkavquarium.getImageMbuttono()));
        g.drawImage(image, 23, 3, this);
        image = ImageIO.read(new File(Arkavquarium.getImageMbuttono()));
        g.drawImage(image, 92, 3, this);
        image = ImageIO.read(new File(Arkavquarium.getImageMbuttono()));
        g.drawImage(image, 441, 3, this);
      } catch (IOException ex) {
        System.out.println(ex);
      }

      try {
        image = ImageIO.read(new File(Guppy.getImageGuppy()[0][0]));
        g.drawImage(image, 25, 5, this);
        image = ImageIO.read(new File("img/Piranhamini.png"));
        g.drawImage(image, 94, 5, this);
        image = ImageIO.read(new File(arkav.getAquarium().getAccount().getImage()));
        g.drawImage(image, 450, 5, this);
      } catch (IOException ex) {
        System.out.println(ex);
      }
      
      Font font = new Font("Courier New", Font.PLAIN, 12);
      setFont(font);

      g.setColor(Color.GREEN);
      g.drawString(Integer.toString(Guppy.getValueGuppy()), 36, 58);
      g.drawString(Integer.toString(Piranha.getValuePiranha()), 105, 58);
      g.drawString(Integer.toString(Account.getValueEgg()), 451, 58);
      g.drawString(Integer.toString(arkav.getAquarium().getAccount().getMoney()), 550, 55);

      try {
        image = ImageIO.read(new File(Aquarium.getImageAquarium()));
        g.drawImage(image, 0, 75, this);
      } catch (IOException ex) {
        System.out.println(ex);
      }

      // menggambar snail
      ListObj<Snail> listSnail = arkav.getAquarium().getListSnail();
      for (int i = 0; i < listSnail.size(); i++) {
        try {
          image = ImageIO.read(new File(listSnail.get(i).getImage()));
          g.drawImage(image, (int) listSnail.get(i).getPosition().getX() - image.getWidth() / 2, 
              (int) listSnail.get(i).getPosition().getY() - image.getHeight() / 2, this);
        } catch (IOException ex) {
          System.out.println(ex);
        } catch (NullPointerException ex) {
          System.out.println(ex);
        }
      }
      
      // menggambar piranha
      ListObj<Piranha> listPiranha = arkav.getAquarium().getListPiranha();
      for (int i = 0; i < listPiranha.size(); i++) {
        try {
          image = ImageIO.read(new File(listPiranha.get(i).getImage()));
          g.drawImage(image, (int) listPiranha.get(i).getPosition().getX() - image.getWidth() / 2,
              (int) listPiranha.get(i).getPosition().getY() - image.getHeight() / 2, this);
        } catch (IOException ex) {
          System.out.println(ex);
        } catch (NullPointerException ex) {
          System.out.println(ex);
        }
      }
      
      // menggambar guppy
      ListObj<Guppy> listGuppy = arkav.getAquarium().getListGuppy();
      for (int i = 0; i < listGuppy.size(); i++) {
        try {
          image = ImageIO.read(new File(listGuppy.get(i).getImage()));
          g.drawImage(image, (int) listGuppy.get(i).getPosition().getX() - image.getWidth() / 2, 
              (int) listGuppy.get(i).getPosition().getY() - image.getHeight() / 2, this);
        } catch (IOException ex) {
          System.out.println(ex);
        } catch (NullPointerException ex) {
          System.out.println(ex);
        }
      }
    
      // menggambar food
      ListObj<Food> listFood = arkav.getAquarium().getListFood();
      for (int i = 0; i < listFood.size(); i++) {
        try {
          image = ImageIO.read(new File(Food.getImage()));
          g.drawImage(image, (int) listFood.get(i).getPosition().getX() - image.getWidth() / 2, 
              (int) listFood.get(i).getPosition().getY() - image.getHeight() / 2, this);
        } catch (IOException ex) {
          System.out.println(ex);
        } catch (NullPointerException ex) {
          System.out.println(ex);
        }
      }
      
      // menggambar coin
      ListObj<Coin> listCoin = arkav.getAquarium().getListCoin();
      for (int i = 0; i < listCoin.size(); i++) {
        try {
          image = ImageIO.read(new File(Coin.getImage()));
          g.drawImage(image, (int) listCoin.get(i).getPosition().getX() - image.getWidth() / 2, 
              (int) listCoin.get(i).getPosition().getY() - image.getHeight() / 2, this);
        } catch (IOException ex) {
          System.out.println(ex);
        } catch (NullPointerException ex) {
          System.out.println(ex);
        } 
      }
      
      if (done) {
        if (win) {
          try {
            image = ImageIO.read(new File(Aquarium.getImageWin()));
            g.drawImage(image, Arkavquarium.getScreenWidth() / 2 - image.getWidth() / 2,
                Arkavquarium.getScreenHeight() / 2 - image.getHeight() / 2 + 75, this);
          } catch (IOException ex) {
            System.out.println(ex);
          }
        } else {
          try {
            image = ImageIO.read(new File(Aquarium.getImageLose()));
            g.drawImage(image, Arkavquarium.getScreenWidth() / 2 - image.getWidth() / 2,
                Arkavquarium.getScreenHeight() / 2 - image.getHeight() / 2 + 75, this);
          } catch (IOException ex) {
            System.out.println(ex);
          }
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

      switch (keycode) {
        case '1':
          // beli Guppy
          if (!menu) {
            wantGuppy();
          }
          break;
        case '2':
          // beli Piranha
          if (!menu) {
            wantPiranha();
          }
          break;
        case '4':
          // beli Egg
          if (!menu) {
            wantEgg();
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
      if (menu) {
        if (menu && e.getY() > 420 && e.getY() < 463 && e.getX() > 204 && e.getX() < 437) {
          menu = false;
        }
      } else {
        if (e.getY() >= 75) {
          ListObj<Coin> listCoin = arkav.getAquarium().getListCoin();
          for (int i = 0; i < listCoin.size(); i++) {
            if (mouseLocation.isInRadius(listCoin.get(i).getPosition(), Coin.getRadiusCoin())) {
              find = true;
              arkav.getAquarium().getListCoin().removeIdx(i);
              break;
            }
          }

          if (!find && arkav.getAquarium().getAccount().moneyEnough(Food.getValueFood())) {
            Point tempPoint = new Point(e.getX(), 75);
            Food tempFood = new Food(tempPoint);
            arkav.getAquarium().getListFood().add(tempFood);
            arkav.getAquarium().getAccount().buyFood();
          }
        } else {
          // buy guppy
          if (e.getX() > 23 && e.getX() < 73 && e.getY() > 3 && e.getY() < 46) {
            wantGuppy();
          } else if (e.getX() > 92 && e.getX() < 140 && e.getY() > 3 && e.getY() < 46) {
            wantPiranha();
          } else if (e.getX() > 441 && e.getX() < 489 && e.getY() > 3 && e.getY() < 46) {
            wantEgg();
          }
        }
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

  /**
   * Untuk apabila ingin membeli guppy, melakukan validasi juga di dalam.
   */
  public void wantGuppy() {
    Random rand = new Random();
    Point tempPoint;
    int tempRadius;

    // beli Guppy
    if (arkav.getAquarium().getAccount().moneyEnough(Guppy.getValueGuppy())) {
      tempRadius = Guppy.getRadiusGuppy();
      tempPoint = new Point(
      rand.nextInt(Arkavquarium.getScreenWidth() - 2 * tempRadius) - 1 + tempRadius,
      rand.nextInt(Arkavquarium.getScreenHeight() - 2 * tempRadius) - 1 + tempRadius + 75);
      Guppy tempGuppy = new Guppy(tempPoint);
      arkav.getAquarium().add(tempGuppy);
      arkav.getAquarium().getAccount().buyGuppy();
    }
  }
  
  /**
   * apabila ingin membeli piranha, melakukan validasi di dalam.
   */
  public void wantPiranha() {
    // beli Piranha
    Random rand = new Random();
    Point tempPoint;
    int tempRadius;

    if (arkav.getAquarium().getAccount().moneyEnough(Piranha.getValuePiranha())) {
      tempRadius = Piranha.getRadiusPiranha();
      tempPoint = new Point(
      rand.nextInt(Arkavquarium.getScreenWidth() - 2 * tempRadius) - 1 + tempRadius,
      rand.nextInt(Arkavquarium.getScreenHeight() - 2 * tempRadius) - 1 + tempRadius + 75);
      Piranha tempPiranha = new Piranha(tempPoint);
      arkav.getAquarium().add(tempPiranha);
      arkav.getAquarium().getAccount().buyPiranha();
    }
  }

  /**
   * apabila ingin membeli telur, melakukan validasi di dalam.
   */
  public void wantEgg() {
    if (arkav.getAquarium().getAccount().moneyEnough(Account.getValueEgg())) {
      arkav.getAquarium().getAccount().buyEgg();
    }
  }
}

