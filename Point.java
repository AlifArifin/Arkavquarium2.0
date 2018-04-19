import java.lang.Math;

class Point {
    private double x, y;
    /*Sekawan*/
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /*Getter*/
    public double getX(){
        return x;
    }
        
    public double getY(){
        return y;
    }

    /*Setter*/
    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    /*Method*/
    public Point Add(Point p){//menambah this->point dengan point pada parameter
        Point p_add = new Point(0, 0);

        p_add.x = this.x + p.x;
        p_add.y = this.y + p.y;
        
        return p_add;
    }

    public double distanceTo(Point p){//Menghitung jarak this-> point dengan point pada parameter
        return Math.sqrt((p.x  - this.x) * (p.x  - this.x) + (p.y  -  this.y) * (p.y  -  this.y));
    }

    public boolean isBottom(Matrix m, int r){//untuk mengecek apakah summonable terdapat di bawah aquarium
        return (int) y == m.getRow() - 1 - r;
    }
        
    public boolean isOutBottom(Matrix m, int r){//untuk mengecek apakah summonable terdapat di bawah aquarium
        return (int) y > m.getRow() - 1 - r;
    }
    
    public boolean isOutTop(Matrix m, int r){//untuk mengecek apakah summonable terdapat di atas aquarium
        return (int) y < r;
    }
        
    public boolean isOutRight(Matrix m, int r){//untuk mengecek apakah summonable terdapat di kanan aquarium
        return (int) x > m.getColumn() - 1 - r;
    }
        
    public boolean isOutLeft(Matrix m, int r){//untuk mengecek apakah summonable terdapat di kiri aquarium
        return (int) x < r;
    }
    
    public double patan2(Point p){
        return Math.atan2(p.y - y, p.x - x);
    }
    
    public boolean isEqual(Point p){
        int absis = (int) x;
        int ordinat = (int) y;
        return absis == (int) p.x && ordinat == (int)p.y;
    }
        
    public boolean isInRadius(Point p, int r){
        return (int) Math.sqrt((p.x  - this.x) * (p.x  - this.x) + (p.y  -  this.y) * (p.y  -  this.y)) <= r;
    }

}