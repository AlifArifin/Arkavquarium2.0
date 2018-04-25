import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquariumTest {

  Aquarium a = new Aquarium();

  @Test
  void add() {
    assertTrue(a.getListGuppy().isEmpty());
    Guppy g = new Guppy(new Point(100, 100));
    a.add(g);
    assertTrue(!a.getListGuppy().isEmpty());    
  }

  @Test
  void del() {
    Guppy g = new Guppy(new Point(100, 100));
    a.add(g);
    assertTrue(!a.getListGuppy().isEmpty());    
    a.del(g);
    assertTrue(a.getListGuppy().isEmpty());
  }

  @Test
  void moveAll() {
    Food f = new Food(new Point(100, 100));
    Coin c = new Coin(new Point(200, 200), 10);

    a.add(f);
    a.add(c);

    a.moveAll(0.1);

    assertTrue(a.getListFood().get(0).getPosition().getY() == 100 + Food.getSpeedFood() * 0.1);
    assertTrue(a.getListCoin().get(0).getPosition().getY() == 200 + Coin.getSpeedCoin() * 0.1);
  }

  @Test
  void win() {
    a.getAccount().setEggPhase(3);

    assertTrue(a.win());
  }

  @Test
  void lose() {
    assertTrue(!a.lose());
  }
}