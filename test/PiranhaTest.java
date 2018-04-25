import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PiranhaTest {

  Point p1 = new Point(100, 100);
  Point p2 = new Point(200, 200);
  Piranha r1 = new Piranha(p1);
  Piranha r2 = new Piranha(p2);

  ListObj<Guppy> listGuppy = new ListObj<>();
  Guppy g1 = new Guppy(new Point(90, 90));
  Guppy g2 = new Guppy(new Point(200, 200));

  @Test
  void move() {
    listGuppy.add(g1);
    listGuppy.add(g2);

    r1.setCountMove(Fish.getDeadTime() + 1);
    r1.setHungry(true);
    r1.setNewInstance(false);
    int result = r1.move(listGuppy, 2);
    assertTrue(result == -2);
  }

  @Test
  void notHungryMove() {
    int direction = r1.getDirection();
    int moveResult = r1.notHungryMove(0.1);
    double rad = Math.PI / 180 * direction;

    p1.setX(p1.getX() + Fish.getSpeedfish() * 0.1 * Math.cos(rad));
    p1.setY(p1.getY() + Fish.getSpeedfish() * 0.1 * Math.sin(rad));

    assertTrue(moveResult == -1);
  }

  @Test
  void hungryMove() {
    listGuppy.add(g1);
    listGuppy.add(g2);

    r1.setHungry(true);
    int result = r1.hungryMove(listGuppy, 2);

    assertTrue(result == 0);
  }

  @Test
  void dropCoin() {
    Guppy g1 = new Guppy(new Point(100, 100));
    Coin c1 = r1.dropCoin(g1);

    assertTrue(c1.getValue() == (g1.getPhase() + 1) * Guppy.getValueGuppy());
  }

  @Test
  void compareTo() {
    assertTrue(r1.compareTo(r2) != 0);
  }
}