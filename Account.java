/**
 * Kelas Account untuk menggambarkan akun player dalam permainan
 * @author Iqrar Aminullah 13516126
 * 
 */
public class Account{
    /**
     * Jumlah uang pada player
     */
    private static int money = 20000;
    /**
     * Harga telur untuk menambah fase telur
     */
    private final int egg_price = 1000;
    /**
     * Jumlah telur yang sudah dibeli
     */
    private static int egg_phase = 0;
    
    /**
     * Mengambil jumlah uang yang terdapat pada akun
     * @return jumlah money pada akun ini
     */
    public int getMoney(){return money;}
    /**
     * Merubah jumlah uang yang terdapat pada akun ini
     * @param money 
     * Jumlah uang baru untuk akun ini
     */
    public void setMoney(int money){this.money = money;}
    /**
     * Menambahkan sejumlah uang ke dalam jumlah uang pada akun ini
     * @param val 
     * Jumlah uang yang ingin ditambahkan ke akun ini
     */
    public void addMoney(int val){this.money+=val;}
    /**
     * Membeli sebuah guppy
     * @return status apakah pembelian berhasil atau tidak
     * Jika jumlah uang cukup untuk membeli guppy, akan mengembalikan ture
     * Kemudian membeli guppy
     * Jika tidak, mengembalikan false
     */
    public boolean buyGuppy(){
        if (money >= Guppy.getValue_Guppy()) {
            money -= Guppy.getValue_Guppy();        
            return true;
        } else {
            return false;
        }
    }
    /**
     * Membeli sebuah Piranha
     * @return status apakah pembelian berhasil atau tidak
     * Jika jumlah uang cukup untuk membeli piranha, akan mengembalikan ture
     * Kemudian membeli piranha
     * Jika tidak, mengembalikan false
     */
    public boolean buyPiranha() {
        if (money >= Piranha.getValue_Piranha()) {
            money -= Piranha.getValue_Piranha();
            return true;
        } else {
            return false;
        }
    }
    /**
     * Membeli sebuah makanan ikan
     * @return status apakah pembelian berhasil atau tidak
     * Jika jumlah uang cukup untuk membeli makanan ikan, akan mengembalikan true
     * Kemudian membeli makanan ikan
     * Jika tidak, mengembalikan false
     */
    public boolean buyFood() {
        if (money >= Food.getValue_Food()) {
            money -= Food.getValue_Food();
            return true;
        } else {
            return false;
        }
    }
    /**
     * Membeli sebuah telur
     * @return status apakah pembelian berhasil atau tidak
     * Jika jumlah uang cukup untuk membeli telur, akan mengembalikan true
     * Kemudian membeli telur, dan menambah jumlah telur yang dimiliki
     * Jika tidak, mengembalikan false
     */
    public boolean buyEgg(){
       if (money >= egg_price){ 
           money -= egg_price;
           egg_phase = egg_phase + 1;
           return true;
        } else {
            return false;
        }
    } 
    /**
     * Memenangkan permainan
     * @return status apakah sudah menang atau tidak
     * Jika jumlah telur yang sudah dibeli>=3, mengembalikan true
     * Jika tidak, mengembalikan false
     */
    public boolean win() {
        return egg_phase >= 3;
}
    /**
     * Mengambil jumlah telur yang sudah dibeli
     * @return egg_phase
     */
    public int getEgg_Phase() {
        return egg_phase;
    }
    
}
