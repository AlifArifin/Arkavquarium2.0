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
public class Food extends Summonable implements Comparable<Food> {
  private String image; // mencatat gambar Guppy
  private double count;
  private static final int valueFood = 10; // harga makanan
  private static final int speedFood = 20; // kecepatan gerak makanan
  private static final int radiusFood = 12; // radius dari makanan
  private static final String[] imageFood = {
    "img/food-1.png", "img/food-2.png", "img/food-3.png", "img/food-4.png", "img/food-5.png",
    "img/food-6.png", "img/food-7.png", "img/food-8.png", "img/food-9.png", "img/food-10.png", 
  };

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
    count = 0;
    image = imageFood[(int) Math.floor(count)];
  }

  /**
   * Getter of valueFood.
   *
   * @return the valueFood.
   */
  public static int getValueFood() {
    return valueFood;
  }

  /**
   * Getter of speedFood.
   *
   * @return the speedFood.
   */
  public static int getSpeedFood() {
    return speedFood;
  }

  /**
   * Getter of radiusFood.
   *
   * @return the radiusFood.
   */
  public static int getRadiusFood() {
    return radiusFood;
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
   * Change the position of the food until it reaches the bottom.
   *
   * @param time current time of the game since start.
   * @return true if the food is at the bottom,
   *         false if the food is not at the bottom.
   */
  boolean move(double time) {
    count += time;
    count = count % 0.5;
    image = imageFood[(int) Math.floor(count / 0.05)];
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
  public int compareTo(Food o) {
    if (direction == o.direction && position.compareTo(o.position) == 0) {
      return 0;
    } else {
      return 1;
    }
  }

  /**
   * getter count.
   * 
   * @return the count
   */
  public double getCount() {
    return count;
  }

  /**
   * setter count.
   * 
   * @param count the count to set
   */
  public void setCount(double count) {
    this.count = count;
  }
}