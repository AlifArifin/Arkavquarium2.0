/**
 * Class Matrix.
 * A matrix object consists of integer type row, column, and 
 * two dimensional data container.
 * A matrix object contains the position of all objects summoned in the Aquarium.
 * 
 * @author Rabbi Fijar Mayoza --13516081
 * @version 20 April 2018 
 */

class Matrix {
  private static final int row = 480;
  private static final int column = 640;
  private int[][] data;

  /**
  * Default Point Constructor.
  */
  public Matrix() {
    data = new int[row][column];
  }

  /**
  * Row getter.
  * @return this matrix row.
  */
  public static int getRow() {
    return row;
  }
    
  /**
  * Column getter.
  * @return this matrix column.
  */
  public static int getColumn() {
    return column;
  }

  /**
  * Value setter.
  * @param m row index.
  * @param n column index.
  * @param val value to set.
  */
  public void setVal(int m, int n, int val) {
    data[m][n] = val;
  }

  /**
  * Value getter.
  * @param m row index.
  * @param n column index.
  * @return value in data[m][n].
  */
  public int getVal(int m, int n) {
    return data[m][n];
  }
}