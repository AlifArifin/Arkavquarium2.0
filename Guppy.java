import java.lang.Comparable;
import java.util.Random;

public class Guppy extends Fish implements Comparable {
  protected int phase; //tahap dari guppy 
  protected String image; //menyimpan gambar dari guppy
  protected int foodCount; //menghitung banyaknya makanan yang telah dimakan
  protected double coinCount; //menghitung jumlah waktu setelah mengeluarkan koin terakhir
  protected static final int coinTime = 8; //periode mengeluarkan koin
  protected static final int valueGuppy = 100; //harga guppy
  protected static final int valueCoin = 40; //value coin yang dihasilkan guppy
  protected static final int growTime = 2; //jumlah makanan yang dibutuhkan untuk tumbuh * phase
  protected static final int radiusGuppy = 15; //radius dari guppy
  protected static final String[][] imageGuppy = {
    {"img/LGuppy1.png", "img/RGuppy1.png", "img/LHungryGuppy1.png", "img/RHungryGuppy1.png"}, 
    {"img/LGuppy2.png", "img/RGuppy2.png", "img/LHungryGuppy2.png", "img/RHungryGuppy2.png"}, 
    {"img/LGuppy3.png", "img/RGuppy3.png", "img/LHungryGuppy3.png", "img/RHungryGuppy3.png"}
  };

  /**
   * Konstruktor Guppy.
   * 
   * @param point Posisi dari guppy
   */
  public Guppy(Point point) {
    super(valueGuppy, point);
    this.phase = 1;
    this.foodCount = 0;
    this.coinCount = 0;
    this.image = imageGuppy[0][0];
  }

  /**
   * Getter dari phase.
   * 
   * @return the phase
   */
  public int getPhase() {
    return phase;
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
   * Getter dari foodCount.
   * 
   * @return the foodCount
   */
  public int getFoodCount() {
    return foodCount;
  }

  /**
   * Getter dari coinCount.
   * 
   * @return the coinCount
   */
  public double getCoinCount() {
    return coinCount;
  }

  /**
   * Getter dari cointTime.
   * 
   * @return the coinTime
   */
  public static int getCoinTime() {
    return coinTime;
  }

  /**
   * Getter dari valueGuppy.
   * 
   * @return the valueGuppy
   */
  public static int getValueGuppy() {
    return valueGuppy;
  }

  /**
   * Getter dari valueCoin.
   * 
   * @return the valueCoin
   */
  public static int getValueCoin() {
    return valueCoin;
  }

  /**
   * Getter dari growTime.
   * 
   * @return the growTime
   */
  public static int getGrowTime() {
    return growTime;
  }

  /**
   * Getter dari radiusGuppy.
   * 
   * @return the radiusGuppy
   */
  public static int getRadiusGuppy() {
    return radiusGuppy;
  }

  /**
   * Getter dari imageGuppy.
   * 
   * @return the imageGuppy
   */
  public static String[][] getImageGuppy() {
    return imageGuppy;
  }

  /**
   * Setter dari phase.
   * 
   * @param phase the phase to set
   */
  public void setPhase(int phase) {
    this.phase = phase;
  }

  /**
   * Setter dari foodCount.
   * 
   * @param foodCount the foodCount to set
   */
  public void setFoodCount(int foodCount) {
    this.foodCount = foodCount;
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
   * Setter dari coinCount.
   * 
   * @param coinCount the coinCount to set
   */
  public void setCoinCount(double coinCount) {
    this.coinCount = coinCount;
  }

  /**
   * Merupakan method untuk menggerakkan Guppy.
   * 
   * @param listFood merupakan list dari food di aquarium
   * @param matrix merupakan matrix yang menyimpan ukuran aquarium
   * @param time merupakan perbedaan waktu dari move sebelumnya
   * @return yang menyatakan apabila
   *         -1 maka tidak ada makanan yang dimakan
   *         selain itu maka merupakan index dari food pada listFood
   */
  public int move(ListObj<Food> listFood, Matrix matrix, double time) {
    countTime += time;
    changeMove += time;
    cointCount += time;

    if (countMove >= hungerTime && !hungry) {
      hungry = true;
    } else if (countMove >= deadTime) {
      return -2;
    } else if (changeMove <= 0 && !hungry) {
      changeChangeMove();
    }

    if (hungry && !listFood.isEmpty()) {
      return hungryMove(listFood, matrix);
    } else {
      return notHungryMove(matrix);
    }
  }

  /**
   * Method untuk pergerakan Guppy ketika sedang lapar 
   * dan saat itu ada makanan.
   * 
   * @param matrix merupakan matrix untuk mencatat luas area aquarium
   * @return int yang menunjukkan apabila -1 maka tidak ada makanan yang 
   *         dimakan namun apabila bukan -1 menujukkan index food (makanan) 
   *         pada listFood yang telah dimakan
   */
  public int hungryMove(ListObj<Food> listFood, Matrix matrix) {
    double closestFood = listFood.get(0).getPosition().distanceTo(position);
    int idxFood = 0;
    for (int i = 0; i < listFood.size(); i++) {
      double temp = listFood.get(i).getPosition().distanceTo(position);
      if (temp < closestFood) {
        closestFood = temp;
        idxFood = i;
      }
    }

    Food food = listFood.get(idxFood);

    double a = position.patan2(food.getPosition());
    int newDirection = ((a * 180.0 / PI).intValue() % 360 + 360) % 360;
    setDirection(newDirection);

    double temp = radiusGuppy * phase + Food.getRadiusFood();
    if (food.getPosition().isInRadius(position, temp)) {
      countMove = 0;
      return listFood.find(food);
    } else {
      position.setX(position.getX() + speedFish * cos(a) * time);
      position.setY(position.getY() + speedFish * sin(a) * time);
      return -1;
    }
  }

  /**
   * Method untuk pergerakan Guppy ketika sedang tidak lapar/
   * lapar namun tidak ada makanan.
   * 
   * @param matrix merupakan matrix untuk mencatat luas area aquarium
   * @return int yang menunjukkan apabila -1 maka tidak ada makanan 
   *         yang dimakan
   */
  public int notHungryMove(Matrix matrix) {
    Random rand = new Random();
    double rad = PI / 180 * direction;
    setDirection(direction);
    
    position.setX(position.getX() + speedFish * cos(rad) * time);
    position.setY(position.getY() + speedFish * sin(rad) * time);

    if (position.isOutLeft(matrix, radiusGuppy * phase)) {
      position.setX(radiusGuppy * phase);
      direction = (rand.nextInt(180) - 90) % 360;
    } else if (position.isOutRight(matrix, radiusGuppy * phase)) {
      position.setX(matrix.getColumn() - 1 - radiusGuppy * phase);
      direction = rand.nextInt(180) + 90;
    }
    
    if (position.isOutTop(matrix, radiusGuppy * phase)) {
      position.setY(radiusGuppy * phase);
      direction = rand.nextInt(180);
    } else if (position.isOutBottom(matrix, radiusGuppy * phase)) {
      position.setY(matrix.getRow() - 1 - radiusGuppy * phase);
      direction = rand.nextInt(180) + 180;
    }

    setDirection(direction);
    return -1;
  }

  /**
   * Method untuk menghasilkan Coin.
   * 
   * @return objek coin dari hasil Guppy
   */
  public Coin dropCoin() {
    coinCount = 0;
    int valua = valueCoin * phase;
    Coin coin = new Coin(position, value);    

    return coin;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void eat() {
    hungry = false;
    foodCount++;
    
    if (foodCount == growTime * phase && phase != 3) {
      phase++;
      foodCount = 0;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo(Guppy g1) {
    if (g1.phase == phase && g1.foodCount == foodCount && g1.hungry == hungry
        && position.compareTo(g1.position) && direction == g1.direction) {
      return 0;
    } else {
      return 1;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDirection(int direction) {
    this.direction = direction;

    if (!hungry) {
      if (direction >= 90 && direction <= 270) {
        image = imageGuppy[phase - 1][0];
      } else {
        image = imageGuppy[phase - 1][1];
      }
    } else {
      if (direction >= 90 && direction <= 270) {
        image = imageGuppy[phase - 1][2];
      } else {
        image = imageGuppy[phase - 1][3];
      }
    }
  }
}