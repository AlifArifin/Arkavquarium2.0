import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.System;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Kelas Arkavquarium.
 * Window dari game arkavquarium
 * 
 * @author Muhammad Alif Arifin/13516078
 * @version 24 April 2018
 */
public class Arkavquarium extends JFrame {
  
  /**
   * Main program.
   * 
   * @param args argumen dari main
   */
  public static void main(String[] args) {
    // make a new aquarium
    Aquarium aquarium = new Aquarium();
    
    // make a point
    Point point1 = new Point(200, 200 + 75);
    Point point2 = new Point(150, 200 + 75);
    Point point3 = new Point(400, 300 + 75);
    //Point point4 = new Point(200, 0 + 75);
    
    // make guppy and snail
    Guppy guppy1 = new Guppy(point1);
    Snail snail1 = new Snail(point2);
    Guppy guppy2 = new Guppy(point3);
    // Coin coin1 = new Coin(point4, 20);
    
    // add guppy dan snail
    aquarium.add(guppy1);
    aquarium.add(snail1);
    aquarium.add(guppy2);
    
    Arkavquarium arkav = new Arkavquarium(aquarium);
    AquariumDisplay aquariumDisplay = new AquariumDisplay(arkav);
    
    arkav.add(aquariumDisplay, BorderLayout.CENTER);
    arkav.setVisible(true);            
    aquariumDisplay.start();
    arkav.done();
  }

  private Aquarium aquarium;
  private static final int screenWidth = 640;
  private static final int screenHeight = 555;
  //private static final String fontName = "fonts/OpenSans-Regular.ttf";
  private static final long serialVersionUID = 1L;
  private static final String imageMenubar = "img/menubar.png";
  private static final String imageMbuttono = "img/mbuttonu1.png";
  
  /**
   * Konstruktor dari arkavquarium.
   */
  public Arkavquarium(Aquarium aquariumNew) {
    super("Arkavquarium");

    this.aquarium = aquariumNew;
    // membuat frame visible
    setVisible(true);        
    
    setSize(screenWidth, screenHeight);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * getter dari aquarium.
   * 
   * @return the aquarium
   */
  public Aquarium getAquarium() {
    return aquarium;
  }

  /**
   * getter dari screenHeight.
   * 
   * @return the screenHeight
   */
  public static int getScreenHeight() {
    return screenHeight;
  }

  /**
   * getter dari screenWidth.
   * 
   * @return the screenWidth
   */
  public static int getScreenWidth() {
    return screenWidth;
  }

  /**
   * getter imageMenubar.
   * 
   * @return the imageMenubar
   */
  public static String getImageMenubar() {
    return imageMenubar;
  }

  /**
   * getter imageMbuttono.
   * 
   * @return the imageMbuttono
   */
  public static String getImageMbuttono() {
    return imageMbuttono;
  }

  public void done() {
    System.out.println("done");
  }
}
