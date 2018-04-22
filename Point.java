import java.lang.Math;

/**
 * Class Point.
 * A point object consists of double type coordinate x and y.
 * A point object determines the position of all objects summoned in the Aquarium.
 * 
 * @author Rabbi Fijar Mayoza --13516081
 * @version 20 April 2018 
 */

class Point implements Comparable<Point> {
  private double abs;
  private double ord;

  /*Sekawan*/

  /**
  * Parameterized Point Constructor.
  * 
  * @param abs - abscissa
  * @param ord - ordinate
  */
  public Point(double abs, double ord) {
    this.abs = abs;
    this.ord = ord;
  }

  /*Getter*/

  /**
  * x getter.
  * @return the current x.
  */
  public double getX() {
    return abs;
  }

  /**
  * y getter.
  * @return the current y.
  */
  public double getY() {
    return ord;
  }

  /*Setter*/

  /**
  * x getter.
  * @param abs set this.abs with abs.
  */
  public void setX(double abs) {
    this.abs = abs;
  }

  /**
  * y setter.
  * @param ord set this.ord with ord.
  */
  public void setY(double ord) {
    this.ord = ord;
  }

  /*Method*/

  /**
  * Add (+) operation.
  * Add this.Point with parameter Point.
  * 
  * @param p the parameter Point as adder.
  * @return the new Point as the result of the add operation.  
  */
  public Point add(Point p) {
    Point addPoint = new Point(0, 0);

    addPoint.abs = this.abs + p.abs;
    addPoint.ord = this.ord + p.ord;
        
    return addPoint;
  }

  /**
  * Distance measurement.
  * Measure the distance from this-> point to parameter point.
  * 
  * @param p the parameter Point.
  * @return the distance value to p.  
  */
  public double distanceTo(Point p) {
    double tempX = (p.abs - this.abs) * (p.abs - this.abs);
    double tempY = (p.ord - this.ord) * (p.ord - this.ord);
    int result = (int) Math.sqrt(tempX + tempY);

    return result;
  }

  /**
  * Position checker.
  * Return true if this.point is on the bottom of the aquarium.
  * 
  * @param m Matrix.
  * @param r ordinate of aquarium's bottom.
  * @return boolean.  
  */
  public boolean isBottom(Matrix m, int r) {
    return (int) ord == m.getRow() - 1 - r;
  }

  /**
  * Position checker.
  * Return true if this.point is out of the bottom of the aquarium.
  *
  * @param m Matrix.
  * @param r ordinate of aquarium's bottom.
  * @return boolean.  
  */
  public boolean isOutBottom(Matrix m, int r) {
    return (int) ord > m.getRow() - 1 - r;
  }
    
  /**
  * Position checker.
  * Return true if this.point is out of the surface of the aquarium.
  *
  * @param m Matrix.
  * @param r ordinate of aquarium's surface.
  * @return boolean.  
  */
  public boolean isOutTop(Matrix m, int r) {
    return (int) ord < r;
  }
     
  /**
  * Position checker.
  * Return true if this.point is out of the right wall of the aquarium.
  *
  * @param m Matrix.
  * @param r abscissa of aquarium's surface.
  * @return boolean.  
  */
  public boolean isOutRight(Matrix m, int r) {
    return (int) abs > m.getColumn() - 1 - r;
  }
        
  /**
  * Position checker.
  * Return true if this.point is out of the left wall of the aquarium.
  *
  * @param m Matrix.
  * @param r abscissa of aquarium's surface.
  * @return boolean.  
  */
  public boolean isOutLeft(Matrix m, int r) {
    return (int) abs < r;
  }
    
  /**
  * Arc tan operation.
  * Count the arc tan of parameter Point  - this.point.
  *
  * @param p goal point
  * @return value of arctan(p.ord - this.ord, p.abs - this.abs).  
  */
  public double patan2(Point p) {
    return Math.atan2(p.ord - ord, p.abs - abs);
  }
    
  /**
  * compareTo method. 
  * Implementation of Comparable Interface.
  * Compare this.point with parameter point.
  *
  * @param p Comparable Point
  * @return 0 if equal, 1 if greater, and -1 if less.
  */
  @Override
  public int compareTo(Point p) {
    int absis1 = (int) abs;
    int ordinat1 = (int) ord;
    int absis2 = (int) p.abs;
    int ordinat2 = (int) p.ord;

    if (absis1 < absis2) {
      return -1;
    } else if (absis1 > absis2) { 
      return 1;
    } else { // abs == other.abs
      if (ordinat1 < ordinat2) {
        return -1;
      } else if (ordinat1 > ordinat2) {
        return 1;
      } else {
        return 0;
      }
    }
  }
        
  /**
  * Distance checker. 
  * Return true if this.point with parameter point are inside the radius.
  *
  * @param p parameter Point
  * @return boolean.
  */
  public boolean isInRadius(Point p, int radius) {
    return this.distanceTo(p) <= radius;
  }
}