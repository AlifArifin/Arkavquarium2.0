import java.util.Random;

/**
 * Class Fish.
 * Fish is an abstract class that have 2 derived class that is Guppy and Piranha
 * Fish control about hungry and movement
 * 
 * @author Muhammad Alif Arifin/13516078
 * @version 21 April 2018
 */
public abstract class Fish extends Summonable {
  // atribut
  protected boolean hungry; // status kelaparan ikan
  protected boolean newInstance; // menunjukkan apakah ikan baru
  protected double countMove; // menghitung waktu pergerakan ikan setelah mengganti arah/makan
  protected double changeMove; // periode penggantian arah ikan
  protected int newY; // new Y bound
  protected final int value; // harga dari ikan
  protected static final int hungerTime = 6; // periode ikan lapar
  protected static final int deadTime = 12; // periode ikan mati
  protected static final int speedFish = 50; // kecepatan ikan

  /**
   * Sebuah konstruktor dari ikan yang userdefined.
   * Mengeset hungry menjadi false
   * Mengeset countMove menjadi 0
   * 
   * @param value mengisi harga dari ikan
   * @param point untuk tempat ikan pertama kalinya
   */
  public Fish(int value, Point point) {
    // memanggil konstruktor parent
    super(speedFish, point);
    hungry = false;
    countMove = 0;
    this.value = value;
    // mengganti change move (ketika waktu sudah habis)
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
   * getter dari newY.
   * 
   * @return the newY
   */
  public int getNewY() {
    return newY;
  }

  /**
   * getter dari newInstance.
   * 
   * @return the newInstance
   */
  public boolean getNewInstance() {
    return newInstance;
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
   * Setter dari newInstance.
   * 
   * @param newInstance the newInstance to set
   */
  public void setNewInstance(boolean newInstance) {
    this.newInstance = newInstance;
  }

  /**
   * Setter dari newY.
   * 
   * @param newY the newY to set
   */
  public void setNewY(int newY) {
    this.newY = newY;
  }

  /**
   * Mengganti change move karena waktunya berganti posisi.
   */
  public void changeChangeMove() {
    // Membangkitkan fungsi untuk meng-generate angka
    Random rand = new Random();

    changeMove = (rand.nextInt(45) + 5) / 10.0;
    direction = rand.nextInt(360);
  }

  /**
   * Method untuk makan (menghubah hungry) dan mengubah phase apabila punya.
   */
  public abstract void eat();
}