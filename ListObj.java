/**
 * Class of Generic Linked List ListObj.
 * ListObj is a dynamic list that record first and last element reference.
 * Elements T can be added and removed from list.
 * 
 * @author Rahmat Nur Ibrahim Santosa/13516009
 * @version 24 April 2018
 */

public class ListObj<T extends Comparable<T>> {
  private Obj<T> first; //mencatat alamat dari first listobj
  private Obj<T> last; //mencatat alamat dari last listobj
        
  /**
   * Default ListObj Constructor.
   * Initialize first and last reference with null.
   */  
  public ListObj() {
    first = null;
    last = null;
  }

  /**
   * Getter of first reference.
   * 
   * @return first.
   */
  public Obj<T> getFirst() {
    return first;
  }

  /**
   * Getter of last reference.
   * 
   * @return first reference.
   */
  public Obj<T> getLast() {
    return last;
  }

  /**
   * Setter of first reference.
   * 
   * @param first the reference of first element.
   */
  public void setFirst(Obj<T> first) {
    this.first = first;
  }

  /**
   * Setter of last reference.
   * 
   * @param last the reference of last element.
   */
  public void setLast(Obj<T> last) {
    this.last = last;
  }
  
  /*Method*/
  //mengembalikan indeks di mana T berada pada linked list, dan -1 jika tidak ada
  /**
   * Search object obj reference in list.
   * 
   * @param obj the object reference that will be searched.
   * @return the index of object in list,
   *         -1 if object not found.
   */
  public int find(T obj) {
    int idx = 0;
    boolean found = false;

    Obj<T> current = first;
    while (current != null && !found) {
      if (obj.compareTo(current.getInfo()) == 0) {
        found = true;
      } else {
        current = current.getNext();
        idx++;
      }
    }
    //current refer to the last element or not found
    if (current == null) {
      return -1;
    } else {
      return idx;
    }
  }

  /**
   * Check if a list is an empty list.
   * 
   * @return true if list is empty, or else return false.
   */
  public boolean isEmpty() {
    return first == null;
  } 
  
  /**
   * Add object as an element at the tail of the list.
   * 
   * @param obj the element that will be added to list.
   */
  public void add(T obj) {
    Obj<T> temp = new Obj<T>(obj);
    if (first == null) {
      first = temp;
      last = temp;
      temp = null;
    } else {
      last.setNext(temp);
      last = temp;
      temp.setNext(null);
    }
  }

  /**
   * Remove an element obj from the list.
   * Assumption: obj exist in the list.
   * Call deleteFirst, deleteLast, or deleteMid function.
   * 
   * @param obj the object that will be removed.
   */
  public void remove(T obj) {
    if (obj == first.getInfo()) {
      deleteFirst();
    } else if (obj == first.getInfo()) {
      deleteLast();
    } else {
      deleteMid(obj);
    }
  }

  /**
   * Remove element from the list using index.
   * Assume index is not out of bound.
   * 
   * @param id the index of elements that will be removed.
   */
  public void removeIdx(int id) {
    Obj<T> temp = first;
    int i;

    if (id == 0) {
      deleteFirst();
    } else {
      i = 1;
      Obj<T> prev = temp;
      temp = temp.getNext();

      while (id != i && temp != null) {
        prev = temp;
        temp = temp.getNext();
        i++;
      }

      if (temp != null) {
        if (temp.getNext() == null) {
          prev.setNext(null);
          last = prev;
        } else {
          prev.setNext(temp.getNext());
          temp.setNext(null);
        }
        temp = null;
      }
    }
  }
  
  /**
   * Remove an element obj that is located in the middle of the list.
   * obj is neither the first or the last element of the list.
   * Assume obj exists in the list.
   * 
   * @param obj the object that will be removed.
   */  
  public void deleteMid(T obj) {
    boolean found = false;
    Obj<T> current = first;
    Obj<T> previous = null;
    while (current != null && !found) {
      if (obj.compareTo(current.getInfo()) == 0) {
        found = true;
      } else {
        previous = current;
        current = current.getNext();
      }
    } 
    previous.setNext(current.getNext());
    current = null;
  } 

  /**
   * Remove an element obj that is located at the first of the list.
   */  
  public void deleteFirst() {
    Obj<T> temp = first;
    first = first.getNext();
    if (first == null) {
      last = null;
    }
    temp = null;
  }

  /**
   * Remove an element obj that is located at the last of the list.
   */  
  public void deleteLast() {
    Obj<T> current = first;
    Obj<T> previous = null;
    current = first;
    while (current.getNext() != null) {
      previous = current;
      current = current.getNext();
    }
    //current is last element
    last = previous;
    if (previous != null) {
      previous.setNext(null);
    } else {
      first = null;
    }
    current = null;
  }

  //mengembalikan elemen dengan tipe T pada indeks sesuai parameter
  //asumsi indeks posisi selalu valid
  /**
   * Get object at index pos.
   * Assume index is not out of bound.
   * 
   * @param pos the index position of object in the list.
   * @return the object with position pos.
   */
  public T get(int pos) {
    int idx = 0;
    Obj<T> current = first;
    while (current != null && idx < pos) {
      current = current.getNext();
      idx++;
    }
    //idx = pos
    return current.getInfo();
  }

  /**
   * Get the number of element in the list.
   * 
   * @return the size of the list.
   */
  public int size() {
    int count = 0;
    Obj<T> current = first;
    while (current != null) {
      current = current.getNext();
      count++;
    }
    //current == null
    return count;
  }

  /**
   * Print every object in the list.
   * Used for debug and testing.
   */
  public void printList() {
    Obj<T> current = first;
    while (current != null) {
      System.out.println(current.getInfo());
      current = current.getNext();
    }
  }
}