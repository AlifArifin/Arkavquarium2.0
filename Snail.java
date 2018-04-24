import java.lang.Comparable;

/**
* Class Snail.
* A snail object has attribute integer type speedSnail and radius snail,
* String container type imageSnail to save the image paths, and 
* String type image as the curent image path.
* A snail object is a creature summoned on the bottom of the aquarium.
* 
* @author Rabbi Fijar Mayoza --13516081
* @version 22 April 2018 
*/

class Snail extends Summonable implements Comparable<Snail> {
  private String image;
  private static final String[] imageSnail = {"img/LSnail.png", "img/RSnail.png"}; 
  private static final int speedSnail = 15; //mencatat kecepatan untuk Snail
  private static final int radiusSnail = 22;

  /*Sekawan*/

  /**
  * Parameterized Point Constructor.
  * 
  * @param pos - spawn position
  */
  public Snail(Point pos) {
    super(speedSnail, pos);
    image = imageSnail[0];
  }
 
  /*Getter*/

  /**
  * speedSnail getter.
  * @return the speed of this snail.
  */
  public static int getSpeedSnail() {
    return speedSnail;
  }

  /**
  * radiusSnail getter.
  * @return the radius of this snail.
  */
  public static int getRadiusSnail() {
    return radiusSnail;
  }

  /**
  * image getter.
  * @return the image of this snail.
  */
  public String getImage() {
    return image;
  }

  /*Setter*/

  /**
  * direction setter.
  * @param d direction to set.
  */
  @Override
  public void setDirection(int d) {
    if (d >= 90 && d < 270) {
      direction = 180;
      image = imageSnail[0];
    } else {
      direction = 0;
      image = imageSnail[1];
    }
  }

  /*Method*/

  /**
  * compareTo method. 
  * Implementation of Comparable Interface.
  * Compare this snail with parameter snail.
  *
  * @param s Comparable Snail
  * @return 0 if equal, -1 if not.
  */

  public int compareTo(Snail s) {
    if (s.position.compareTo(position) == 0) {
      return 0;
    } else {
      return -1;
    }
  }

  /**
  * Snail mmovement.
  * Snail moves to the closest coin.
  * 
  * @param coinList list of coin.
  * @param time time counter.
  * @return index of the closest coin in list of coin if any, else return -1.  
  */
  public int move(ListObj<Coin> coinList , double time) {
    position.setY(Matrix.getRow() - 1 - radiusSnail);
    if (!coinList.isEmpty()) {
      Point closestCoin = coinList.get(0).getPosition();
      int idxCoin = 0;
      for (int i = 0; i < coinList.size(); i++) {
        Point temp = coinList.get(i).getPosition();
        if (position.isInRadius(temp, Coin.getRadiusCoin() + radiusSnail)) {
          return i;
        } else if ((int) temp.getY() > (int) closestCoin.getY()) {
          closestCoin = temp;
          idxCoin = i;
        } else if ((int) temp.getY() == (int) closestCoin.getY()) {
          if (position.distanceTo(temp) < position.distanceTo(closestCoin)) {
            closestCoin = temp;
            idxCoin = i;
          }
        }
      }
      Coin c = coinList.get(idxCoin);
      double a = position.patan2(c.getPosition());
      int dir = (int) ((a * 180.0 / PI) % 360 + 360) % 360;
      //System.out.printf("%d\n", dir);
      setDirection(dir);
      if (position.isInRadius(c.getPosition(), Coin.getRadiusCoin() + radiusSnail)) {
        return idxCoin;
      } else if ((int) position.getX() == (int) c.getPosition().getX()) {
        return -1;
      } else {
        if (Math.abs(position.getX() - c.getPosition().getX())
            <= Math.abs(speedSnail * Math.cos(direction * PI / 180) * time)) {
          position.setX(c.getPosition().getX());
        } else {
          position.setX(position.getX() + speedSnail * Math.cos(direction * PI / 180) * time);
        }
        return -1;
      }
    } else {
      return -1;
    }
  }
} 
  