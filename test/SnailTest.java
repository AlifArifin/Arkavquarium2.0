import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnailTest {
  ListObj<Coin> CL = new ListObj<>();
  Point p1 = new Point(2,75);
  Point p2 = new Point(1,515);
  Coin c = new Coin(p1,515);

  Snail s = new Snail(p2);

  @Test
  public void move() {
    c.move(1);
    CL.add(c);
    assertTrue(s.move(CL,0.0001) == -1);
  }
}