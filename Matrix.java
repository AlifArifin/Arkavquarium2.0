import java.util.*;

class Matrix{
    private static int row = 480;
    private static int column = 640;
    private int[][] data;

    public Matrix(){
        data = new int[row][column];
    }
    
    public static int getRow(){
        return row;
    }
    
    public static int getColumn(){
        return column;
    }
    
    public void setVal(int m, int n, int val){
        data[m][n] = val;
    }

    public int getVal(int m, int n){
        return data[m][n];
    }
}