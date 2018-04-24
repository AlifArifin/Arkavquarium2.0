import java.awt.event.ActionListener;
import javax.swing.*;

public class AquariumDisplay extends JPanel implements ActionListener {

    Arkavquarium arkav;
    
    public AquariumDisplay(Arkavquarium arkav) {
        setFocusable(true);
        this.arkav = arkav;

        boolean win = play();
        if(win) {

        } else {

        }
    }

    public boolean play() {
        boolean quit = false;
        while(!quit) {
            arkav.getAquarium().moveAll();
            paintComponent(getGraphics());

            // check win or lose
            
        }
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public double getTime(long nano) {
        return nano/1000000000.0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ListObj<Snail> listSnail = arkav.getAquarium().getListSnail();
        for (int i = 0; i < listSnail.size(); i++) {
            g.drawImage(listSnail.get(i).getImage(), listSnail.get(i).getPosition().getX(), 
            listSnail.get(i).getPosition().getY());
        }
        
        ListObj<Piranha> listPiranha = arkav.getAquarium().getListPiranha();
        for (int i = 0; i < listPiranha.size(); i++) {
            g.drawImage(listPiranha.get(i).getImage(), listPiranha.get(i).getPosition().getX(), 
            listPiranha.get(i).getPosition().getY());
        }
        
        ListObj<Guppy> listGuppy = arkav.getAquarium().getListGuppy();
        for (int i = 0; i < listGuppy.size(); i++) {
            g.drawImage(listGuppy.get(i).getImage(), listGuppy.get(i).getPosition().getX(), 
            listGuppy.get(i).getPosition().getY());
        }
    
        ListObj<Food> listFood = arkav.getAquarium().getListFood();
        for (int i = 0; i < listFood.size(); i++) {
            g.drawImage(listFood.get(i).getImage(), listFood.get(i).getPosition().getX(), 
            listFood.get(i).getPosition().getY());
        }
        
        ListObj<Coin> listCoin = arkav.getAquarium().getListCoin();
        for (int i = 0; i < listCoin.size(); i++) {
            g.drawImage(listCoin.get(i).getImage(), listCoin.get(is).getPosition().getX(), 
            listCoin.get(i).getPosition().getY());
        } 
    }
}