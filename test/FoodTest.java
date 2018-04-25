import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

  Point p1 = new Point(100,100);
  Point p2 = new Point(200, 470);
  Food f1 = new Food(p1);
  Food f2 = new Food(p2);
  Food f3 = new Food(p1);

  @Test
  void move() {
    f1.move(2);
    assertTrue(f1.getPosition().getY() == 100 + f1.getSpeed() * 2);
  }

  @Test
  void compareTo() {
    assertTrue(f1.compareTo(f2) != 0);
    assertTrue(f1.compareTo(f3) == 0);
  }
}