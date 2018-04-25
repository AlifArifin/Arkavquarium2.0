import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListObjTest {

  Point p1 = new Point(100, 100);
  Point p2 = new Point(200, 470);
  Point p3 = new Point(300, 350);

  ListObj<Coin> l1 = new ListObj<>();
  Coin c1 = new Coin(p1, 10);
  Coin c2 = new Coin(p2, 20);
  Coin c3 = new Coin(p3, 10);

  ListObj<Coin> l2 = new ListObj<>();

  @Test
  void find() {
    l1.add(c1);
    l1.add(c2);
    assertTrue(l1.find(c1) == 0);
    assertTrue(l1.find(c2) == 1);
  }

  @Test
  void isEmpty() {
    assertTrue(l2.isEmpty());
  }

  @Test
  void add() {
    l2.add(c1);
    assertTrue(l2.size() == 1);
  }

  @Test
  void remove() {
    l1.add(c1);
    l1.remove(c1);
    assertTrue(l1.isEmpty());
  }

  @Test
  void removeIdx() {
    l1.add(c1);
    l1.add(c2);
    l1.add(c3);
    l1.removeIdx(1);
    assertTrue(l1.find(c2) == -1);
  }

  @Test
  void deleteMid() {
    l1.add(c1);
    l1.add(c2);
    l1.add(c3);
    l1.deleteMid(c2);
    assertTrue(l1.find(c2) == -1);
  }

  @Test
  void deleteFirst() {
    l1.add(c1);
    l1.add(c2);
    l1.add(c3);
    l1.deleteFirst();
    assertTrue(l1.find(c1) == -1);
  }

  @Test
  void deleteLast() {
    l1.add(c1);
    l1.add(c2);
    l1.add(c3);
    l1.deleteLast();
    assertTrue(l1.find(c3) == -1);
  }

  @Test
  void get() {
    l1.add(c1);
    l1.add(c2);
    l1.add(c3);
    assertTrue(l1.get(1) == c2);
  }

  @Test
  void size() {
    l1.add(c1);
    l1.add(c2);
    l1.add(c3);
    assertTrue(l1.size() == 3);
  }
}