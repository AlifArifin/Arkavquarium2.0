import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

class GuppyTest {

  Point p1 = new Point(100, 100);
  Point p2 = new Point(200, 200);
  Guppy g1 = new Guppy(p1);
  Guppy g2 = new Guppy(p2);

  @Test
  void move() {
    ListObj<Food> listFood = new ListObj<>();
    Food f1 = new Food(new Point(50, 50));
    g1.setHungry(true);
    
    listFood.add(f1);

    g1.setCountMove(Fish.getDeadTime() + 2);
    g1.setNewInstance(false);

    int result = g1.move(listFood, 2);

    assertTrue(result == -2);
  }

  @Test
  void hungryMove() {
    ListObj<Food> listFood = new ListObj<>();
    Food f1 = new Food(new Point(50, 50));
    g1.setHungry(true);
    
    listFood.add(f1);

    g1.setNewInstance(false);

    int moveResult = g1.hungryMove(listFood, 0.1);

    assertTrue(moveResult == -1);
  }

  @Test
  void notHungryMove() {
    int direction = g1.getDirection();
    double rad = Math.PI / 180 * direction;
    g1.setNewInstance(false);

    p1.setX(p1.getX() + Fish.getSpeedfish() * 0.1 * Math.cos(rad));
    p1.setY(p1.getY() + Fish.getSpeedfish() * 0.1 * Math.sin(rad));

    int moveResult = g1.notHungryMove(0.1);
    assertTrue(moveResult == -1);
  }

  @Test
  void dropCoin() {
    Coin c1 = g1.dropCoin();

    assertTrue(g1.getCountCoin() == 0 && c1.getValue() == Guppy.getValueCoin() * g1.getPhase());
  }

  @Test
  void compareTo() {
    assertTrue(g1.compareTo(g2) != 0);
  }

  @Test
  void eat() {
    g1.eat();
    assertTrue(!g1.getHungry() && g1.getFoodCount() == 1);
    g1.eat();
    assertTrue(!g1.getHungry() && g1.getPhase()== 2);
  }
}