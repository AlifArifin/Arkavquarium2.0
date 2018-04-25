/**
 * Kelas Obj.
 * merupakan elemen dari listobj
 * 
 * @author Rahmat Nur Ibrahim/13516009
 * @version 25 April 2018
 */
public class Obj<T> { //class dari elemen listobj
  /* Atribut */
  private T info; //mencatat informasi dari obj
  private Obj<T> next; //mencatat alamat next dari obj 

  /* Method */    
  /*Sekawan*/
  
  /**
   * Konstruktor Obj.
   * 
   * @param obj merupakan info dari Obj
   */
  public Obj(T obj) {
    info = obj;
    next = null;
  }

  /*Getter*/

  /**
   * getter dari info.
   * 
   * @return mengembalikan info
   */
  public T getInfo() {
    return info;
  }

  /**
   * getter dari next.
   * 
   * @return mengembalikan next
   */
  public Obj getNext() {
    return next;
  }

  /*Setter*/

  /**
   * setter dari info.
   * 
   * @param o merupakan info yang baru
   */
  public void setInfo(T o) {
    info = o;
  }

  /**
   * setter dari next.
   * 
   * @param n merupakan next yang baru
   */
  public void setNext(Obj<T> n) {
    next = n;
  }

  /**
   * mencetak info.
   */
  public void print() {
    Obj<T> p = this;
    while (p != null) {
      System.out.println(p.info);
      p = p.next;
    }
  }

  /**
   * hanya untuk testing saja.
   */
  public static void main(String[] args) {
    Obj<Integer> a1 = new Obj<Integer>(5);
    Obj<Integer> a2 = new Obj<Integer>(2);
    Obj<Integer> a3 = new Obj<Integer>(1);
    a1.setNext(a2);
    a2.setNext(a3);
    a1.print();
    System.out.println((a1.next).info);
  }
}
