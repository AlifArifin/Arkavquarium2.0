import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.ActionListener;

public class AquariumDisplay extends JPanel implements ActionListener {

  Arkavquarium arkav;
  
  public AquariumDisplay(Arkavquarium arkav) {
    
    // membuat focus
    setFocusable(true);
    this.arkav = arkav;

    // bermain
    boolean win = play();

    // mengecek apabila menang atau kalah
    if (win) {

    } else {

    }
  }

  /**
   * Membuat program berjalan
   * 
   * @return merupakan petunjuk dari menang atau kalah
   *         true untuk menang
   */
  public boolean play() {
    boolean quit = false;
    double now = getTime();
    double prev, elapsedTime;
    while(!quit) {
      prev = now;
      now = getTime();
      
      // perbedaan waktu setelah pergerakan terakhir
      elapsedTime = now - prev;

      // removeAll image
      arkav.getAquarium().moveAll(elapsedTime);
      paintComponent(getGraphics());

      // check win or lose
      if (arkav.getAquarium().win()) {
        return true;
      } else if (arkav.getAquarium().lose()) {
        return false;
      }
    }
  }

  /**
   * Mendapatkan waktu saat ini dari system
   * 
   * @return merupakan waktu saat ini
   */
  public double getTime() {
    return System.nanoTime/1000000000.0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // menggambar aquarium
    g.drawImage(arkav.getAquarium(), arkav.getScreenWidth() / 2, arkav.getScreenHeight() / 2);

    // menggambar snail
    ListObj<Snail> listSnail = arkav.getAquarium().getListSnail();
    for (int i = 0; i < listSnail.size(); i++) {
      g.drawImage(listSnail.get(i).getImage(), listSnail.get(i).getPosition().getX(), 
      listSnail.get(i).getPosition().getY());
    }
    
    // menggambar piranha
    ListObj<Piranha> listPiranha = arkav.getAquarium().getListPiranha();
    for (int i = 0; i < listPiranha.size(); i++) {
      g.drawImage(listPiranha.get(i).getImage(), listPiranha.get(i).getPosition().getX(), 
      listPiranha.get(i).getPosition().getY());
    }
    
    // menggambar guppy
    ListObj<Guppy> listGuppy = arkav.getAquarium().getListGuppy();
    for (int i = 0; i < listGuppy.size(); i++) {
      g.drawImage(listGuppy.get(i).getImage(), listGuppy.get(i).getPosition().getX(), 
      listGuppy.get(i).getPosition().getY());
    }
  
    // menggambar food
    ListObj<Food> listFood = arkav.getAquarium().getListFood();
    for (int i = 0; i < listFood.size(); i++) {
      g.drawImage(listFood.get(i).getImage(), listFood.get(i).getPosition().getX(), 
      listFood.get(i).getPosition().getY());
    }
    
    // menggambar coin
    ListObj<Coin> listCoin = arkav.getAquarium().getListCoin();
    for (int i = 0; i < listCoin.size(); i++) {
      g.drawImage(listCoin.get(i).getImage(), listCoin.get(is).getPosition().getX(), 
      listCoin.get(i).getPosition().getY());
    } 
  }
}