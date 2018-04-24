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

  /**
   * Harga telur untuk menambah fase telur.
   */
  private final int eggPrice = 1000;
  
  /**
   * Mengambil jumlah uang yang terdapat pada akun.
   * @return jumlah money pada akun ini
   */
  public int getMoney() {
    return money;
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
   * Membeli sebuah guppy.
   * @return status apakah pembelian berhasil atau tidak
   *         Jika jumlah uang cukup untuk membeli guppy, akan mengembalikan ture
   *         Kemudian membeli guppy
   *         Jika tidak, mengembalikan false
   */
  public boolean buyGuppy() {
    if (money >= Guppy.getValueGuppy()) {
      money -= Guppy.getValueGuppy();        
      return true;
    } else {
      return false;
    }
  }

  /**
   * Membeli sebuah Piranha.
   * @return status apakah pembelian berhasil atau tidak
   *         Jika jumlah uang cukup untuk membeli piranha, akan mengembalikan ture
   *         Kemudian membeli piranha
   *         Jika tidak, mengembalikan false
   */
  public boolean buyPiranha() {
    if (money >= Piranha.getValuePiranha()) {
      money -= Piranha.getValuePiranha();
      return true;
    } else {
      return false;
    }
  }

  /**
   * Membeli sebuah makanan ikan.
   * @return status apakah pembelian berhasil atau tidak
   *         Jika jumlah uang cukup untuk membeli makanan ikan, akan mengembalikan true
   *         Kemudian membeli makanan ikan
   *         Jika tidak, mengembalikan false
   */
  public boolean buyFood() {
    if (money >= Food.getValueFood()) {
      money -= Food.getValueFood();
      return true;
    } else {
      return false;
    }
  }

  /**
   * Membeli sebuah telur.
   * @return status apakah pembelian berhasil atau tidak
   *         Jika jumlah uang cukup untuk membeli telur, akan mengembalikan true
   *         Kemudian membeli telur, dan menambah jumlah telur yang dimiliki
   *         Jika tidak, mengembalikan false
   */
  public boolean buyEgg() {
    if (money >= eggPrice) { 
      money -= eggPrice;
      eggPhase = eggPhase + 1;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Mengambil jumlah telur yang sudah dibeli.
   * @return eggPhase
   */
  public int getEggPhase() {
    return eggPhase;
  }
}
