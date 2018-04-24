import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.System;

public class Arkavquarium extends JFrame {
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

    private static final int screenWidth = 640;
    private static final int screenHeight = 480;
    private static final String fontName = "fonts/OpenSans-Regular.ttf";
    private Aquarium aquarium;

    public Arkavquarium() {
        super("Arkavquarium");
        aquarium = new Aquarium();
        setSize(screenWidth, screenHeight);
        AquariumDisplay aquariumDisplay = new AquariumDisplay(this);
        add(aquariumDisplay);
        aquarium.start();

        // membuat frame visible
        setVisible(true);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * @return the aquarium
     */
    public Aquarium getAquarium() {
        return aquarium;
    }
}