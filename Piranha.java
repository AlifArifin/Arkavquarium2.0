import java.lang.Comparable;
import java.lang.Math;
import java.util.Random;

/**
 * Class Piranha.
 * Piranha is a fish in aquarium that eat Guppy
 * 
 * @author Muhammad Alif Arifin/13516078
 * @version 23 April 2018
 */
public class Piranha extends Fish implements Comparable<Piranha> {
  // Atribut
  protected String image; // image menyimpan gambar dari ikan piranha saat itu
  protected static final int valuePiranha = 300; // harga ikan piranha
  protected static final int radiusPiranha = 35; // radius dari ikan piranha
  protected static final String[] imagePiranha = { // list dari gambar ikan piranha
    "img/LPiranha.png", "img/RPiranha.png", "img/LHungryPiranha.png", "img/RHungryPiranha.png"
  };
  
  /**
   * Konstruktor piranha.
   * mengeset image piranha menjadi imagePiranha[0]
   * 
   * @param point point akan menjadi lokasi dari piranha ketika diinstantiasi
   */
  public Piranha(Point point) {
    super(valuePiranha, point);
    this.image = imagePiranha[0];
  }
  
  /**
   * Getter dari image.
   * 
   * @return the image
   */
  public String getImage() {
    return image;
  }

  /**
   * Getter dari imagePiranha.
   * 
   * @return the imagePiranha
   */
  public static String[] getImagePiranha() {
    return imagePiranha;
  }

  /**
   * Getter dari radiusPiranha.
   * 
   * @return the radiusPiranha
   */
  public static int getRadiusPiranha() {
    return radiusPiranha;
  }

  /**
   * Getter dari valuePiranha.
   * 
   * @return the valuePiranha
   */
  public static int getValuePiranha() {
    return valuePiranha;
  }

  /**
   * Setter dari image.
   * 
   * @param image the image to set
   */
  public void setImage(String image) {
    this.image = image;
  }
  
  /**
   * Merupakan method untuk menggerakkan Piranha.
   * 
   * @param listGuppy merupakan list dari Guppy di aquarium
   * @param time merupakan perbedaan waktu dari move sebelumnya
   * @return yang menyatakan apabila
   *         -1 maka tidak ada makanan yang dimakan
   *         -2 maka ikan mati
   *         selain itu maka merupakan index dari Guppy pada listGuppy
   */
  public int move(ListObj<Guppy> listGuppy, double time) {
    // mencatat perubahan waktu countMove mencatat waktu setelah makan terakhir
    // changeMove akan berkurang hingga < 0 (kalau kurang ikan akan berubah arah)
    countMove += time;
    changeMove -= time;
  
    // apabila pergerakan setelah makan terakhir telah melebihi hungerTime
    if (countMove >= hungerTime && !hungry) {
      hungry = true;
    // apabila pergerakan setelah makan terakhir telah melebihi deadTime
    } else if (countMove >= deadTime) {
      return -2;
    // apabila changeMove telah 0 (akan dikurangi setiap pergerakan) 
    } else if (changeMove <= 0 && !hungry) {
      changeChangeMove();
    }
  
    if (hungry && !listGuppy.isEmpty()) {
      return hungryMove(listGuppy, time);
    } else {
      return notHungryMove(time);
    }
  } 
  
  /**
   * Method untuk pergerakan Piranha ketika sedang tidak lapar/
   * lapar namun tidak ada makanan.
   * 
   * @param time time untuk menunjukkan waktu setelah pergerakan terakhir
   * @return int yang menunjukkan apabila -1 maka tidak ada makanan 
   *         yang dimakan
   */
  public int notHungryMove(double time) {
    Random rand = new Random();
    double rad = Math.PI / 180 * direction;
    
    // mengeset X dan Y yang beru dengan rumus
    // x' = x + v * cos(rad) * time
    // y' = y + v * sin(rad) * time
    position.setX(position.getX() + speedFish * Math.cos(rad) * time);
    position.setY(position.getY() + speedFish * Math.sin(rad) * time);
    
    // jika Piranha keluar dari radius maka akan memutar arah Piranha
    if (position.isOutLeft(radiusPiranha)) {
      position.setX(radiusPiranha);
      direction = (rand.nextInt(180) - 90) % 360;
    } else if (position.isOutRight(radiusPiranha)) {
      position.setX(Matrix.getColumn() - 1 - radiusPiranha);
      direction = rand.nextInt(180) + 90;
    }
    if (position.isOutTop(radiusPiranha)) {
      position.setY(radiusPiranha);
      direction = rand.nextInt(180);
    } else if (position.isOutBottom(radiusPiranha)) {
      position.setY(Matrix.getRow() - 1 - radiusPiranha);
      direction = rand.nextInt(180) + 180;
    }
    
    setDirection(direction);    
    
    return -1;
  }

  /**
   * Method untuk pergerakan Guppy ketika sedang lapar 
   * dan saat itu ada makanan.
   * 
   * @param listGuppy merupakan list dari Guppy yang ada di aquarium
   * @param time time untuk menunjukkan waktu setelah pergerakan terakhir
   * @return int yang menunjukkan apabila -1 maka tidak ada makanan yang 
   *         dimakan namun apabila bukan -1 menujukkan index Guppy (makanan) 
   *         pada listGuppy yang telah dimakan
   */
  public int hungryMove(ListObj<Guppy> listGuppy, double time) {
    double closestFood = listGuppy.get(0).getPosition().distanceTo(position);
    int idxFood = 0;
    // mencari index Guppy yang paling dekat dengan Piranha
    for (int i = 0; i < listGuppy.size(); i++) {
      double temp = listGuppy.get(i).getPosition().distanceTo(position);
      if (temp < closestFood) {
        closestFood = temp;
        idxFood = i;
      }
    }

    Guppy guppy = listGuppy.get(idxFood);
    double a = position.patan2(guppy.getPosition());
    int dir = ((int)(a * 180.0 / Math.PI) % 360 + 360) % 360;
    setDirection(dir); 
    
    int temp = Guppy.getRadiusGuppy() * guppy.getPhase();

    // apabila makanan berada di dalam radius dari guppy
    if (guppy.getPosition().isInRadius(position, radiusPiranha + temp)) {
      countMove = 0;
      return listGuppy.find(guppy);
    } else {
      // mengeset X dan Y yang beru dengan rumus
      // x' = x + v * cos(rad) * time
      // y' = y + v * sin(rad) * time
      position.setX(position.getX() + speedFish * Math.cos(a) * time);
      position.setY(position.getY() + speedFish * Math.sin(a) * time);
      return -1;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void eat() {
    this.hungry = false;
  }
  
  /**
   * Method untuk menghasilkan Coin.
   * 
   * @param guppy guppy yang dimakan oleh piranha
   * @return objek coin dari hasil Guppy
   */
  public Coin dropCoin(Guppy guppy) {
    int val = (guppy.getPhase() + 1) * guppy.getValue();
    Coin coin = new Coin(position, val);
  
    return coin;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo(Piranha p) {
    if (p.hungry == hungry && position.compareTo(p.position) == 0 && direction == p.direction) {
      return 0;
    } else {
      return 1;
    }
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void setDirection(int d) {
    direction = d;
    if (!hungry) {
      if (d >= 90 && d <= 270) {
        image = imagePiranha[0];
      } else {
        image = imagePiranha[1];
      }
    } else {
      if (d >= 90 && d <= 270) {
        image = imagePiranha[2];
      } else {
        image = imagePiranha[3];
      }
    }
  }
}