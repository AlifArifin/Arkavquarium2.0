/**
 * Kelas Account untuk menggambarkan akun player dalam permainan.
 * @author Iqrar Aminullah 13516126
 * 
 */
public class Account {
  
  /**
   * Jumlah uang pada player.
   */
  private int money = 20000;
  
  /**
   * Jumlah telur yang sudah dibeli.
   */
  private int eggPhase = 0;

  private String image;

  /**
   * Harga telur untuk menambah fase telur.
   */
  private static final int valueEgg = 1000;
  
  private static final String[] imageEgg = {
    "img/egg1.png", "img/egg2.png", "img/egg3.png", "img/egg3.png"};

  /**
   * Default Account Constructor.
   */
  public Account() {
    image = imageEgg[0];
  }

  /**
   * getter dari image.
   * 
   * @return the image
   */
  public String getImage() {
    return image;
  }

  /**
   * Mengambil jumlah uang yang terdapat pada akun.
   * @return jumlah money pada akun ini
   */
  public int getMoney() {
    return money;
  }

  /**
   * Getter valueEgg.
   * @return the valueEgg
   */
  public static int getValueEgg() {
    return valueEgg;
  }

  /**
   * Merubah jumlah uang yang terdapat pada akun ini.
   * @param m Jumlah uang baru untuk akun ini
   */
  public void setMoney(int m) {
    money = m;
  }

  /**
   * Menambahkan sejumlah uang ke dalam jumlah uang pada akun ini.
   * @param val Jumlah uang yang ingin ditambahkan ke akun ini
   */
  public void addMoney(int val) {
    money += val;
  }
  
  /**
   * Mengecek apakah uang cukup untuk membeli something (something itu udah harganya).
   *
   * @param  something harga suatu barang
   * @return status apakah pembelian berhasil atau tidak
   *         Jika jumlah uang cukup untuk membeli piranha, akan mengembalikan ture
   *         Kemudian membeli piranha
   *         Jika tidak, mengembalikan false
   */
  public boolean moneyEnough(int something) {
    return money >= something;
  }
  
  /**
   * Membeli sebuah guppy.
   */
  public void buyGuppy() {
    money -= Guppy.getValueGuppy();
  }
  
  /**
   * Membeli sebuah Piranha.
   */
  public void buyPiranha() {
    money -= Piranha.getValuePiranha();
  }

  /**
   * Membeli sebuah makanan ikan.
   */
  public void buyFood() {
    money -= Food.getValueFood();
  }

  /**
   * Membeli sebuah telur.
   */
  public void buyEgg() {
    money -= valueEgg;
    eggPhase = eggPhase + 1;
    image = imageEgg[eggPhase];
  }

  /**
   * Mengambil jumlah telur yang sudah dibeli.
   * @return eggPhase
   */
  public int getEggPhase() {
    return eggPhase;
  }

  /**
   * setter eggPhase.
   * 
   * @param eggPhase the eggPhase to set
   */
  public void setEggPhase(int eggPhase) {
    this.eggPhase = eggPhase;
  }

  /**
   * Setter image.
   * 
   * @param image the image to set
   */
  public void setImage(String image) {
    this.image = image;
  }
}
