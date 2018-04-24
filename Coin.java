import java.lang.Comparable;

/**
 * Class Coin.
 * Coin is an object that produced by guppy.
 * Increases the points by the amount of value when collected by snail.
 * 
 * @author Rahmat Nur Ibrahim Santosa/13516009
 * @version 23 April 2018
 */
public class Coin extends Summonable implements Comparable<Coin> {
  private String image; // mencatat gambar coin
  private double count;
  private final int value; // harga coin
  private static final int speedCoin = 20; // kecepatan gerak coin
  private static final int radiusCoin = 12; // radius dari coin
  private static final String[] imageCoin = {
    "img/coin-1.png", "img/coin-2.png", "img/coin-3.png", "img/coin-4.png", "img/coin-5.png", 
    "img/coin-6.png", "img/coin-7.png", "img/coin-8.png", "img/coin-9.png", "img/coin-10.png", 
  };
  
  /**
   * User-defined coin constructor.
   * Set the direction of coin to bottom (270).
   * Set the inital coin position with Point p.
   * Set the value of coin to val.
   * 
   * @param p initial coin position
   * @param val the coin value
   */
  public Coin(Point p, int val) {
    super(speedCoin, p);
    value = val;
    direction = 270;
    count = 0;
    image = imageCoin[(int) Math.floor(count)];
  }

  /**
   * Change the position of the coin until it reaches the bottom.
   * If the coin reaches the bottom, stop movement.
   * 
   * @param time current time of the game since start
   */
  void move(double time) {
    count += time;
    count = count % 0.5;
    image = imageCoin[(int) Math.floor(count / 0.05)];
    if (!position.isOutBottom(radiusCoin)) {
      position.setY(position.getY() + speed * time);
      if (position.isOutBottom(radiusCoin)) {
        position.setY(Matrix.getRow() - 1 - radiusCoin);
      }
    }
  }

  /**
   * Getter of value.
   * 
   * @return the coin value.
   */
  public int getValue() {
    return value;
  }

  /**
   * Getter of speedCoin.
   * 
   * @return the speedcoin.
   */
  public static int getSpeedCoin() {
    return speedCoin;
  }

  /**
   * Getter of radiusCoin.
   * 
   * @return the radiuscoin.
   */
  public static int getRadiusCoin() {
    return radiusCoin;
  }

  /**
   * Getter of image.
   * 
   * @return the image.
   */
  public String getImage() {
    return image;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo(Coin c) {
    if (c.value == value && direction == c.direction
        && position.compareTo(c.position) == 0) {
      return 0;
    } else {
      return 1;
    }
  }
}