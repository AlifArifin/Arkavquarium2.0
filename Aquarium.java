/**
 * Kelas yang menggambarkan keadaan sebuah akuraium dalam permainan.
 * @author Iqrar Aminullah 13516126
 */
public class Aquarium {

  /**
   * Matriks yang menggambarkan posisi tiap - tiap objek dalam akuarium.
   */
  private Matrix aquariumMatrix;
  
  /**
   * Akun player yang dapat mengendalikan akuarium ini.
   */
  private Account player;
  
  /**
   * Daftar guppy yang ada dalam akuarium.
   */
  private ListObj<Guppy> listGuppy = new ListObj<>();
  
  /**
   * Daftar piranha yang ada dalam akuarium.
   */
  private ListObj<Piranha> listPiranha = new ListObj<>();
  
  /**
   * Daftar siput yang ada dalam akuarium.
   */
  private ListObj<Snail> listSnail = new ListObj<>();
  
  /**
   * Daftar koin yang ada dalam akuarium.
   */
  private ListObj<Coin> listCoin = new ListObj<>();
  
  /**
   * Daftar makanan ikan yang ada dalam akuarium.
   */
  private ListObj<Food> listFood = new ListObj<>();
  
  private static final String imageAquarium = "img/Aquarium.jpg";
  private static final String imageWin = "img/win.png";
  private static final String imageLose = "img/lose.png";

  /**
   * Mengambil daftar guppy pada akuarium.
   * @return listGuppy
   */
  public ListObj<Guppy> getListGuppy() {
    return listGuppy;
  }
  
  /**
   * Mengambil daftar Piranha pada akuarium.
   * @return listPiranha
   */
  public ListObj<Piranha> getListPiranha() {
    return listPiranha;
  }
  
  /**
   * Mengambil daftar siput pada akuarium.
   * @return listSnail
   */
  public ListObj<Snail> getListSnail() {
    return listSnail;
  }
  
  /**
   * Mengambil daftar koin pada akuarium.
   * @return listCoin
   */
  public ListObj<Coin> getListCoin() {
    return listCoin;
  }
  
  /**
   * Mengambil daftar makanan ikan pada akuarium.
   * @return listFood
   */
  public ListObj<Food> getListFood() {
    return listFood;
  }
  
  /**
   * Mengambil matriks posisi pada akuarium.
   * @return aquariumMatrix
   */
  public Matrix getMatrix() {
    return aquariumMatrix;
  }
  
  /**
   * Mengambil akun pemain yang mengendalikan akuarium.
   * @return player
   */
  public Account getAccount() {
    return player;
  }

  /**
   * @return the imageAquarium
   */
  public static String getImageAquarium() {
    return imageAquarium;
  }

  /**
   * @return the imageLose
   */
  public static String getImageLose() {
    return imageLose;
  }

  /**
   * @return the imageWin
   */
  public static String getImageWin() {
    return imageWin;
  }
  
  //setter
  
  /**
   * Mengubah list guppy dengan sebuah list guppy baru.
   * @param newList newList baru untuk list yang baru
   */
  public void setListGuppy(ListObj<Guppy> newList) {
    listGuppy = newList;
  }
  
  /**
   * Mengubah list piranha dengan sebuah list piranha baru.
   * @param newList newList baru untuk list yang baru
   */
  public void setListPiranha(ListObj<Piranha> newList) {
    listPiranha = newList;
  }
  
  /**
   * Mengubah list snail dengan sebuah list snail baru.
   * @param newList newList baru untuk list yang baru
   */
  public void setListSnail(ListObj<Snail> newList) {
    listSnail = newList;
  }
  
  /**
   * Mengubah list koin dengan sebuah list koin baru.
   * @param newList newList baru untuk list yang baru
   */
  public void setListCoin(ListObj<Coin> newList) {
    listCoin = newList;
  }
  
  /**
   * Mengubah list makanan ikan dengan sebuah list makanan ikan baru.
   * @param newList newList baru untuk list yang baru
   */
  public void setListFood(ListObj<Food> newList) {
    listFood = newList;
  }
  
  //Method
  
  /**
   * Menambahkan guppy baru ke dalam list guppy.
   * @param newGuppy guppy baru
   */
  public void add(Guppy newGuppy) {
    listGuppy.add(newGuppy);
  }
  
  /**
   * Menambahkan piranha baru ke dalam list piranha.
   * @param newPiranha piranha baru
   */
  public void add(Piranha newPiranha) {
    listPiranha.add(newPiranha);
  }
  
  /**
   * Menambahkan siput baru ke dalam list siput.
   * @param newSnail snail baru
   */
  public void add(Snail newSnail) {
    listSnail.add(newSnail);
  }
  
  /**
   * Menambahkan koin baru ke dalam list koin.
   * @param newCoin coin baru
   */
  public void add(Coin newCoin) {
    listCoin.add(newCoin);
  }
  
  /**
   * Menambahkan makanan ikan baru ke dalam list makanan ikan.
   * @param newFood food baru
   */
  public void add(Food newFood) {
    listFood.add(newFood);
  }
  
  /**
   * Menghapus sebuah guppy dari list guppy.
   * @param exGuppy guppy yang ingin dihapus
   */
  public void del(Guppy exGuppy) {
    listGuppy.remove(exGuppy);
  }
  
  /**
   * Menghapus sebuah piranha dari list piranha.
   * @param exPiranha piranha yang ingin dihapus
   */
  public void del(Piranha exPiranha) {
    listPiranha.remove(exPiranha);
  }
  
  /**
   * Menghapus sebuah siput dari list siput.
   * @param exSnail snail yang ingin dihapus
   */
  public void del(Snail exSnail) {
    listSnail.remove(exSnail);
  }
  
  /**
   * Menghapus sebuah koin dari list koin.
   * @param exCoin coin yang ingin dihapus
   */
  public void del(Coin exCoin) {
    listCoin.remove(exCoin);
  }
  
  /**
   * Menghapus sebuah makanan ikan dari list makanan ikan.
   * @param exFood food yang ingin dihapus
   */
  public void del(Food exFood) {
    listFood.remove(exFood);
  }
  
  /**
   * Menggerakkan semua objek yang ada dalam akuarium.
   * @param time waktu setelah pergerakan sebelumnya
   */
  public void moveAll(double time) {
    for (int i = 0; i < listFood.size(); i++) {
      boolean bottom = listFood.get(i).move(time);

      if (bottom) {
        listFood.removeIdx(i);
        i--;
      }
    }
    
    for (int i = 0; i < listGuppy.size(); i++) {
      int idx = listGuppy.get(i).move(listFood, time);

      if (idx == -2) {
        listGuppy.removeIdx(i);
        i--;
        continue;
      } else if (idx != -1) {
        listFood.removeIdx(idx);
        listGuppy.get(i).eat();
      }

      if (listGuppy.get(i).getCountCoin() >= Guppy.getCoinTime()) {
        Coin c = listGuppy.get(i).dropCoin();

        listCoin.add(c);
      }
    }
    
    for (int i = 0; i < listPiranha.size(); i++) {
      int idx = listPiranha.get(i).move(listGuppy, time);

      if (idx == -2) {
        listPiranha.removeIdx(i);
        i--;
        continue;
      } else if (idx != -1) {
        Coin c = listPiranha.get(i).dropCoin(listGuppy.get(idx));
        listCoin.add(c);
        
        listGuppy.removeIdx(idx);

        listPiranha.get(i).eat();
      }
    }
    
    for (int i = 0; i < listCoin.size(); i++) {
      listCoin.get(i).move(time);
    }

    for (int i = 0; i < listSnail.size(); i++) {
      int idx = listSnail.get(i).move(listCoin, time);

      if (idx != -1) {
        Coin c = listCoin.get(idx);
        listCoin.removeIdx(idx);

        player.addMoney(c.getValue());
      }
    }     
  }

  /**
   * Memenangkan permainan.
   * @return status apakah sudah menang atau tidak
   *         Jika jumlah telur yang sudah dibeli>=3, mengembalikan true
   *         Jika tidak, mengembalikan false
   */
  public boolean win() {
    return player.getEggPhase() >= 3;
  }

  /**
   * Kalah dari permainan.
   * @return jika kalah maka return true
   */
  public boolean lose() {
    return listGuppy.isEmpty() && listPiranha.isEmpty() && listCoin.isEmpty()
      && player.getMoney() < Guppy.getValueGuppy();
  }
}