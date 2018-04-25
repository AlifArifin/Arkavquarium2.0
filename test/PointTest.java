import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
  Point p1 = new Point(0,0);
  Point p2 = new Point(3,4);

  @Test
  void add() {
    Point p3 = new Point(0, 0);

    p3 = p1.add(p2);
    assertTrue(p3.getX() == 3);
    assertTrue(p3.getY() == 4);
  }

  @Test
  void distanceTo() {
    double d = p1.distanceTo(p2);
    assertTrue(d == 5);
  }

  @Test
  void compareTo() {
    assertTrue(p1.compareTo(p2) != 0);
  }

  @Test
  void isInRadius() {
    assertTrue(p1.isInRadius(p2,10));
  }
}