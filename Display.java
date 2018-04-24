import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.System;

public class Display {
    public static void main(String[] args) {
        Display a = new Display();
        /*
        a.drawImage("img/Coin.png", 50, 50);
        a.drawImage("img/Coin.png", 10, 10);        
        //a.drawText("HALLO", 100, 100);
        a.drawImage("img/Coin.png", 100, 100);        
        */
        a.makeVisible();
    }
    private JFrame frame;
    private static final int screenWidth = 640;
    private static final int screenHeight = 480;
    private static final String fontName = "fonts/OpenSans-Regular.ttf";
    private int count = 0;

    public long getNanoTime() {
        return System.nanoTime();
    }

    public double getTime(long nano) {
        return nano/1000000000.0;
    }

    public Display() {
        frame = new JFrame("Arkavquarium");
        frame.setSize(screenWidth, screenHeight);

        // membuat frame visible
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void drawImage(String path, int x, int y) {
        frame.add(new ImagePanel(path, x, y), BorderLayout.);
    }

    public void drawText(String message, int x, int y) {
        frame.add(new TextPanel(message, x, y), );
    }

    public void makeVisible() {
        frame.setVisible(true);
    }
}