/**
 * Kelas yang menggambarkan keadaan sebuah akuraium dalam permainan
 * @author Iqrar Aminullah 13516126
 */
public class Aquarium{
    /**
     * Matriks yang menggambarkan posisi tiap - tiap objek dalam akuarium
     */
    private Matrix aquariumMatrix;
    /**
     * Akun player yang dapat mengendalikan akuarium ini
     */
    private Account player;
    /**
     * Daftar guppy yang ada dalam akuarium
     */
    private ListObj<Guppy> listGuppy = new ListObj<>();
    /**
     * Daftar piranha yang ada dalam akuarium
     */
    private ListObj<Piranha> listPiranha = new ListObj<>();
    /**
     * Daftar siput yang ada dalam akuarium
     */
    private ListObj<Snail> listSnail = new ListObj<>();
    /**
     * Daftar koin yang ada dalam akuarium
     */
    private ListObj<Coin> listCoin = new ListObj<>();
    /**
     * Daftar makanan ikan yang ada dalam akuarium
     */
    private ListObj<Food> listFood = new ListObj<>();
    
    /**
     * Mengambil daftar guppy pada akuarium
     * @return listGuppy
     */
    public ListObj<Guppy> getListGuppy(){return listGuppy;}
    /**
     * Mengambil daftar Piranha pada akuarium
     * @return listPiranha
     */
    public ListObj<Piranha> getListPiranha(){return listPiranha;}
    /**
     * Mengambil daftar siput pada akuarium
     * @return listSnail
     */
    public ListObj<Snail> getListSnail(){return listSnail;}
    /**
     * Mengambil daftar koin pada akuarium
     * @return listCoin
     */
    public ListObj<Coin> getListCoin(){return listCoin;}
    /**
     * Mengambil daftar makanan ikan pada akuarium
     * @return listFood
     */
    public ListObj<Food> getListFood(){return listFood;}
    /**
     * Mengambil matriks posisi pada akuarium
     * @return aquariumMatrix
     */
    public Matrix getMatrix(){return aquariumMatrix;}
    /**
     * Mengambil akun pemain yang mengendalikan akuarium
     * @return player
     */
    public Account getAccount(){return player;}
    
    //setter
    /**
     * Mengubah list guppy dengan sebuah list guppy baru
     * @param newList 
     */
    public void setListGuppy(ListObj<Guppy> newList){listGuppy=newList;}
    /**
     * Mengubah list piranha dengan sebuah list piranha baru
     * @param newList 
     */
    public void setListPiranha(ListObj<Piranha> newList){listPiranha=newList;}
    /**
     * Mengubah list snail dengan sebuah list snail baru
     * @param newList 
     */
    public void setListSnail(ListObj<Snail> newList){listSnail=newList;}
    /**
     * Mengubah list koin dengan sebuah list koin baru
     * @param newList 
     */
    public void setListCoin(ListObj<Coin> newList){listCoin=newList;}
    /**
     * Mengubah list makanan ikan dengan sebuah list makanan ikan baru
     * @param newList 
     */
    public void setListFood(ListObj<Food> newList){listFood=newList;}
    
    //Method
    /**
     * Menambahkan guppy baru ke dalam list guppy
     * @param newGuppy 
     */
    public void add(Guppy newGuppy){listGuppy.add(newGuppy);}
    /**
     * Menambahkan piranha baru ke dalam list piranha
     * @param newPiranha  
     */
    public void add(Piranha newPiranha){listPiranha.add(newPiranha);}
    /**
     * Menambahkan siput baru ke dalam list siput
     * @param newSnail 
     */
    public void add(Snail newSnail){listSnail.add(newSnail);}
    /**
     * Menambahkan koin baru ke dalam list koin
     * @param newCoin 
     */
    public void add(Coin newCoin){listCoin.add(newCoin);}
    /**
     * Menambahkan makanan ikan baru ke dalam list makanan ikan
     * @param newFood 
     */
    public void add(Food newFood){listFood.add(newFood);}
    
    /**
     * Menghapus sebuah guppy dari list guppy
     * @param exGuppy 
     */
    public void del(Guppy exGuppy){listGuppy.remove(exGuppy);}
    /**
     * Menghapus sebuah piranha dari list piranha
     * @param exPiranha
     */
    public void del(Piranha exPiranha){listPiranha.rempove(exPiranha);}
    /**
     * Menghapus sebuah siput dari list siput
     * @param exSnail
     */
    public void del(Snail exSnail){listSnail.remove(exSnail);}
    /**
     * Menghapus sebuah koin dari list koin
     * @param exCoin
     */
    public void del(Coin exCoin){listCoin.remove(exCoin);}
    /**
     * Menghapus sebuah makanan ikan dari list makanan ikan
     * @param exFood 
     */
    public void del(Food exFood){listFood.remove(exFood);}
    
    /**
     * Menampilkan seluruh ikan pada akuarium
     */
    public void showAll(){
    
    for (int i = 0; i < listSnail.size(); i++) {
		draw_image(listSnail.get(i).getImage(), listSnail.get(i).getPosition().getX(), listSnail.get(i).getPosition().getY());
	}
	
	for (int i = 0; i < listPiranha.size(); i++) {
		draw_image(listPiranha.get(i).getImage(), listPiranha.get(i).getPosition().getX(), listPiranha.get(i).getPosition().getY());
	}
	
	for (int i = 0; i < listGuppy.size(); i++) {
		draw_image(listGuppy.get(i).getImage(), listGuppy.get(i).getPosition().getX(), listGuppy.get(i).getPosition().getY());
	}

	for (int i = 0; i < listFood.size(); i++) {
		draw_image(listFood.get(i).getImage(), listFood.get(i).getPosition().getX(), listFood.get(i).getPosition().getY());
	}
	
	for (int i = 0; i < listCoin.size(); i++) {
		draw_image(listCoin.get(i).getImage(), listCoin.get(is).getPosition().getX(), listCoin.get(i).getPosition().getY());
	}}
    
    /**
     * Menggerakkan semua objek yang ada dalam akuarium
     * @param time
     */
    public void moveAll(double time){
       	
	for (int i = 0; i < listFood.size(); i++) {
		bool bottom = listFood.get(i).move(aquariumMatrix, time);

		if (bottom) {
			listFood.removeIdx(i);
			i--;
		}
	}
	
	for (int i = 0; i < listGuppy.size(); i++) {
		int idx = listGuppy.get(i).move(listFood, aquariumMatrix, time);

		if (idx == -2) {
			listGuppy.removeIdx(i);
			i--;
			continue;
		} else if (idx != -1) {
			listFood.removeIdx(idx);
			listGuppy.get(i).eat();
		}

		if (listGuppy.get(i).getCoin_Count() >= Guppy::getCoin_Time()) {
			Coin c = listGuppy.get(i).dropCoin();

			listCoin.add(c);
		}
	}
	
	for (int i = 0; i < listPiranha.size(); i++) {
		int idx = listPiranha.get(i).move(listGuppy, aquariumMatrix, time);

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
		listCoin.get(i).move(aquariumMatrix, time);
	}

	for (int i = 0; i < listSnail.size(); i++) {
		int idx = listSnail.get(i).move(listCoin, time);

		if (idx != -1) {
			Coin c = listCoin.get(idx);
			listCoin.removeIdx(idx);

			Account.addMoney(c.getValue());
		}
	} 
    
    }
    
    
}
