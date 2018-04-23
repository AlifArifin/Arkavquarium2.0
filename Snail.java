/**
* Class Snail.
* A snail object has attribute integer type speed_snail and radius snail,
* String container type image_snail to save the image paths, and 
* String type image as the curent image path.
* A snail object is a creature summoned on the bottom of the aquarium.
* 
* @author Rabbi Fijar Mayoza --13516081
* @version 22 April 2018 
*/

class Snail extends Summonable {
  private static final int speed_snail = 15; //mencatat kecepatan untuk Snail
  private static final int radius_snail = 22;
  private static String[] image_snail = {"img/LSnail.png", "img/RSnail.png"}; 
  private String image;

  /*Sekawan*/

  /**
  * Parameterized Point Constructor.
  * 
  * @param pos - spawn position
  */
  public Snail(Point pos) {
    super(speed_snail, pos);
    image = image_snail[0];
  }
 
  /*Getter*/

  /**
  * speed_snail getter.
  * @return the speed of this snail.
  */
  public int getSpeed_Snail() {
    return speed_snail;
  }

  /**
  * radius_snail getter.
  * @return the radius of this snail.
  */
  public int getRadius_Snail() {
    return radius_snail;
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
    if (d >= 90 && d <= 270) {
      direction = 180;
      image = image_snail[0];
    } else {
      direction = 0;
      image = image_snail[1];
    }
  }

  /*Method*/

  /**
  * Snail mmovement.
  * Snail moves to the closest coin.
  * 
  * @param coinList list of coin.
  * @param time time counter.
  * @return index of the closest coin in list of coin if any, else return -1.  
  */
  public int move(ListObj<Coin> coinList , double time) {
    position.setY(480 - radius_snail - 1);
    if (!coinList.isEmpty()) {
      Point closestCoin = coinList.get(0).getPosition();
      int idxCoin = 0;
      for (int i = 0; i < coinList.size(); i++) {
        Point temp = coinList.get(i).getPosition();
        if (position.isInRadius(temp, Coin.getRadiusCoin() + radius_snail)) {
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
      setDirection(dir);
      if (position.isInRadius(c.getPosition(), Coin.getRadiusCoin() + radius_snail)) {
        return idxCoin;
      } else if ((int) position.getX() == (int) c.getPosition().getX()) {
        return -1;
      } else {
        position.setX(position.getX() + speed_snail * Math.cos(direction * PI / 180) * time);
        return -1;
      }
    } else {
      return -1;
    }
  }
} 
  