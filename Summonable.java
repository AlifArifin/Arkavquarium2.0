import java.lang.Math;

/**
 * Abstract Class Summonable.
 * A Summonable class consists of Point type position, 
 * integer type direction and speed, and double type constant PI.
 * A Summonable class will represent all objects that can be summoned in the Aquarium.
 * 
 * @author Rabbi Fijar Mayoza --13516081
 * @version 21 April 2018 
 */
abstract class Summonable {
  protected Point position; //mencatat posisi dari summonable pada point
  protected int direction;  //direction harus berada pada angka 0 <= direction <= 360        
  protected int speed; //kecepatan dari Summonable
  protected static final double PI = 3.14159265;
    
  /*Sekawan*/

  /**
  * Parameterized Point Constructor.
  * 
  * @param speed - speed
  * @param pos - spawn position
  */
  public Summonable(int speed, Point pos) {
    position = new Point(pos.getX(), pos.getY());
    this.speed = speed;
    direction = (int) (Math.random() % 360);
  }

  /*Getter*/

  /**
  * Position getter.
  * @return this summonable position.
  */
  public Point getPosition() {
    return position;
  }
  
  /**
  * Direction getter.
  * @return this summonable direction.
  */
  public int getDirection() {
    return direction;
  }
  
  /**
  * Speed getter.
  * @return this summonable speed.
  */
  public int getSpeed() {
    return speed;
  }
  
  /*Setter*/

  /**
  * Position setter.
  * @param p Position to set.
  */
  public void setPosition(Point p) {
    position = p;
  }

  /**
  * Direction setter.
  * @param d direction to set.
  */
  public void setDirection(int d) {
    direction = d;
  }
}