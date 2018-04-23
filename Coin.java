/**
 * Class Coin.
 * Coin is an object that produced by guppy.
 * Increases the points by the amount of value when collected by snail.
 * 
 * @author Rahmat Nur Ibrahim Santosa/13516009
 * @version 23 April 2018
 */
public class Coin extends Summonable {
    private final int value; // harga coin
    private static final int speedCoin = 20; // kecepatan gerak coin
    private static final int radiusCoin = 10; // radius dari coin
    private static final String image = "img/Food.png"; // mencatat gambar coin
    
    /**
     * User-defined coin constructor.
     * Set the direction of coin to bottom (270).
     * Set the inital coin position with Point p.
     * Set the value of coin to
     * 
     * @param p initial coin position
     * @param val the coin value
     */
    public Coin(Point p, int val) {
        super(speedCoin, p);
        value = val;
        direction = 270;
    }

    /**
     * Change the position of the coin until it reaches the bottom.
     * If the coin reaches the bottom, stop movement.
     * 
     * @param time current time of the game since start
     */
    void move (double time) {
        if (!position.isOutBottom(radiusCoin)) {
            position.setY(position.getY() + speed * time);
            if (position.isOutBottom(radiusCoin)) {
                position.setY(Matrix.getRow() - 1 - radiusCoin);
            }
        }
    }

	/**
     * Getter of value
     * 
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
     * Getter of speedCoin
     * 
	 * @return the speedcoin
	 */
	public static int getSpeedcoin() {
		return speedCoin;
	}

	/**
     * Getter of radiusCoin
     * 
	 * @return the radiuscoin
	 */
	public static int getRadiuscoin() {
		return radiusCoin;
	}

	/**
     * Getter of image
     * 
	 * @return the image
	 */
	public static String getImage() {
		return image;
	}
}