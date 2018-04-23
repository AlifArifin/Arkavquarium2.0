import java.lang.Comparable;

/**
 * Class Food.
 * Coin is an object that produced when clicking the mouse inside aquarium.
 * Reduces the points by the amount of value when created.
 * Destructed when eaten by hungry guppy.
 *
 * @author Rahmat Nur Ibrahim Santosa/13516009
 * @version 23 April 2018
 */
public class Food extends Summonable implements Comparable {
  private static final int valueFood = 10; // harga makanan
  private static final int speedFood = 20; // kecepatan gerak makanan
  private static final int radiusFood = 10; // radius dari makanan
  private static final String image = "img/Food.png"; // mencatat gambar Guppy

  /**
   * User-defined food constructor.
   * Set the direction of food to bottom (270).
   * Set the inital food position with Point p.
   *
   * @param p Initial food position.
   */
  public Food(Point p) {
    super(speedFood, p);
    direction = 270;
  }

  /**
   * Getter of valueFood.
   *
   * @return the valueFood.
   */
  public static int getValuefood() {
    return valueFood;
  }

  /**
   * Getter of speedFood.
   *
   * @return the speedFood.
   */
  public static int getSpeedfood() {
    return speedFood;
  }

  /**
   * Getter of radiusFood.
   *
   * @return the radiusFood.
   */
  public static int getRadiusfood() {
    return radiusFood;
  }

  /**
   * Getter of image.
   *
   * @return the image.
   */
  public static String getImage() {
    return image;
  }

  /**
   * Change the position of the food until it reaches the bottom.
   *
   * @param time current time of the game since start.
   * @return true if the food is at the bottom,
   *         false if the food is not at the bottom.
   */
  boolean move(double time) {
    if (!position.isOutBottom(radiusFood)) {
      position.setY(position.getY() + speed * time);
      return position.isOutBottom(radiusFood);
    } else {
      return false;
    }
  }

  /**
   * CompareTo for compare food.
   * 
   * {@inheritDoc}
   */
  @Override
  public int compareTo(Object f) {
    Food o = (Food)f;
    if (direction == o.direction && position.compareTo(o.position) == 0) {
      return 0;
    } else {
      return 1;
    }
  }
}