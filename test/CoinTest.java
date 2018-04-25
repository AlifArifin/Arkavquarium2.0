import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

  Point p1 = new Point(100, 100);
  Point p2 = new Point(200, 470);
  Coin c1 = new Coin(p1, 10);
  Coin c2 = new Coin(p2, 10);

  @Test
  void move() {
    c1.move(2);
    c2.move(2);
    assertTrue(c1.getPosition().getY() == 100 + c1.speed * 2);
    assertTrue(c2.getPosition().isBottom(Coin.getRadiusCoin()));
  }

  @Test
  void compareTo() {
    assertTrue(c1.compareTo(c2) != 0);
  }
}