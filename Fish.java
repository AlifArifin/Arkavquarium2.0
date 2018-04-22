import java.util.Random;

/**
 * @author Muhammad Alif Arifin/13516078
 */
public abstract class Fish extends Summonable {
  //atribut
  protected boolean hungry; //status kelaparan ikan
  protected double countMove; //menghitung waktu pergerakan ikan setelah mengganti arah/makan
  protected double changeMove; //periode penggantian arah ikan
  protected final int value; //harga dari ikan
  protected static final int hungerTime = 6; //periode ikan lapar
  protected static final int deadTime = 12; //periode ikan mati
  protected static final int speedFish = 40; //kecepatan ikan

  /**
   * Sebuah konstruktor dari ikan.
   * 
   * @param value mengisi harga dari ikan
   * @param point untuk tempat ikan pertama kalinya
   */
  public Fish(int value, Point point) {
    super(speedFish, point);
    hungry = false;
    countMove = 0;
    this.value = value;
    //mengganti change move (ketika waktu sudah habis)
    changeChangeMove();
  }

  /**
   * Getter dari hungerTime.
   * 
   * @return the hungertime
   */
  public static int getHungertime() {
    return hungerTime;
  }

  /**
   * Getter dari changeMove. 
   * 
   * @return the changeMove
   */
  public double getChangeMove() {
    return changeMove;
  }

  /**
   * Getter dari countMove.
   * 
   * @return the countMove
   */
  public double getCountMove() {
    return countMove;
  }

  /**
   * Getter dari deadTime.
   * 
   * @return the deadTime
   */
  public static int getDeadTime() {
    return deadTime;
  }

  /**
   * Getter dari speedFish.
   * 
   * @return the speedfish
   */
  public static int getSpeedfish() {
    return speedFish;
  }

  /**
   * Getter dari Value.
   * 
   * @return the value
   */
  public int getValue() {
    return value;
  }


  /**
   * Getter dari Hungry.
   * 
   * @return the hungry
   */
  public boolean getHungry() {
    return hungry;
  }

  /**
   * Setter dari changeMove.
   * 
   * @param changeMove the changeMove to set
   */
  public void setChangeMove(double changeMove) {
    this.changeMove = changeMove;
  }

  /**
   * Setter dari countMove.
   * 
   * @param countMove the countMove to set
   */
  public void setCountMove(double countMove) {
    this.countMove = countMove;
  }

  /**
   * Setter dari hungry.
   * 
   * @param hungry the hungry to set
   */
  public void setHungry(boolean hungry) {
    this.hungry = hungry;
  }

  /**
   * Mengganti change move karena waktunya berganti posisi.
   */
  public void changeChangeMove() {
    Random rand = new Random();

    changeMove = (rand.nextInt(45) + 5) / 10.0;
    direction = rand.nextInt(360);
  }

  /**
   * Method untuk makan (menghubah hungry) dan mengubah phase apabila punya.
   */
  public abstract void eat();
}