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
    Arkavquarium arkav = new Arkavquarium();
  }

  private Aquarium aquarium;
  private static final int screenWidth = 640;
  private static final int screenHeight = 480;
  //private static final String fontName = "fonts/OpenSans-Regular.ttf";
  private static final long serialVersionUID = 1L;
  
  /**
   * Konstruktor dari arkavquarium.
   */
  public Arkavquarium() {
    super("Arkavquarium");
    
    // make a new aquarium
    aquarium = new Aquarium();

    // make a point
    Point point1 = new Point(200, 200);
    Point point2 = new Point(150, 200);
    Point point3 = new Point(400, 300);

    // make guppy
    Guppy guppy1 = new Guppy(point1);
    Snail snail1 = new Snail(point2);
    Guppy guppy2 = new Guppy(point3);

    // add guppy
    aquarium.add(guppy1);
    aquarium.add(snail1);
    //aquarium.add(guppy2);

    setSize(screenWidth, screenHeight);

    //add(new JLabel(new ImageIcon("img/Aquarium.jpg")), BorderLayout.SOUTH);
    AquariumDisplay aquariumDisplay = new AquariumDisplay(this);
    add(aquariumDisplay, BorderLayout.CENTER);
    setVisible(true);        
    
    aquariumDisplay.start();


    // membuat frame visible
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
}
