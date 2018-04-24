/**
 * Kelas Account untuk menggambarkan akun player dalam permainan.
 * @author Iqrar Aminullah 13516126
 * 
 */
public class Account {
  
  /**
   * Jumlah uang pada player.
   */
  private int money = 90;
  
  /**
   * Jumlah telur yang sudah dibeli.
   */
  private int eggPhase = 0;

  /**
   * Harga telur untuk menambah fase telur.
   */
  private static final int valueEgg = 1000;
  
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
  }

  /**
   * Mengambil jumlah telur yang sudah dibeli.
   * @return eggPhase
   */
  public int getEggPhase() {
    return eggPhase;
  }
}
