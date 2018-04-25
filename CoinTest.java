
class CoinTest {
  private Coin coin1;
  private Coin coin2;
  private Point point1;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    point1 = new Point(10, 10);
    coin1 = new Coin(point1, 10);
    coin2 = new Coin(point1, 20);
  }

  @org.junit.jupiter.api.Test
  void move() {
  }

  @org.junit.jupiter.api.Test
  void compareTo() {
  }
}