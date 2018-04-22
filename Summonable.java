import java.util.*;

abstract class Summonable {
    protected Point position; //mencatat posisi dari summonable pada point
    protected int direction;  //direction harus berada pada angka 0 <= direction <= 360        
    protected int speed; //kecepatan dari Summonable
    protected static double PI = 3.14159265;
    
    /*Sekawan*/
    public Summonable(int _s, Point _p){//menerima jenis, speed, dan lokasi spawn
        position = new Point(_p);
        speed = _s;
        direction = (int) Math.random() % 360;
    }

    /*Getter*/
    public Point getPosition(){
        return position;
    } 

    public int getDirection(){
        return direction;
    } 

    public int getSpeed(){
        return speed;
    }

    /*Setter*/
    public void setPosition(Point p){
        position = p;
    }
    public void setDirection(int d){
        direction = d;
    }
}