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
  private static String[] image_snail = new String[2];
  private String image;

  /*Sekawan*/
  public Snail(Point pos){
    super(speed_snail, pos);
    image = image_snail[0];
  }
  
  /*Getter*/
  public int getSpeed_Snail() {
    return speed_snail;
  }

  public int getRadius_Snail() {
    return radius_snail;
  }

  public String getImage() {
    return image;
  }

  /*Setter*/
  public void setDirection(int d) {

  }

  /*Method*/
  /*
  public int move(ListObj<Coin> , double); //untuk pergerakan snail
  bool operator==(const Snail&) const;
  */
   
}