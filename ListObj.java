public class ListObj<T> {
    private Obj<T> first; //mencatat alamat dari first listobj
    private Obj<T> last; //mencatat alamat dari last5 listobj
        
    /*Sekawan*/
    public ListObj() {
        first = null;
        last = null;
    }

    /*Getter*/
    public Obj<T> getFirst() {
        return first;
    }
    public Obj<T> getLast()  {
        return last;
    }

    /*Setter*/
    public void setFirst(Obj<T> _first) {
        first = _first;
    }
    public void setLast(Obj<T> _last) {
        last = _last;
    }
    
    /*Method*/
    //mengembalikan indeks di mana T berada pada linked list, dan -1 jika tidak ada
    public int find(T _obj) {
        int idx = 0;
        boolean found = false;

        Obj<T> current = first;
        while (current != null && !found) {
            if (current.getInfo() == _obj) {
                found = true;
            } else {
                current = current.getNext();
                idx++;
            }
        }
        //current = Last Element or not found
        if (current == null) {
            return -1;
        } else {
            return idx;
        }
    }

    //mengembalikan nilai True jika linked list kosong
    public boolean isEmpty() {
        return first == null;
    } 
    
    // menambahkan elemen sebagai T paling belakang pada linked list
    public void add (T _obj) {
        Obj<T> temp = new Obj<T>(_obj);
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

    //membuang elemen dengan identitas sesuai parameter
    //asumsi elemen ada di dalam list
    public void remove (T _obj) {
        if (_obj == first.getInfo()) {
            deleteFirst();
        } else if (_obj == first.getInfo()) {
            deleteLast();
        } else {
            deleteMid(_obj);
        }
    }

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
    
    public void deleteMid (T _obj) {
        boolean found = false;
        Obj<T> current = first;
        Obj<T> previous = null;
        while (current != null && !found) {
            if (current.getInfo() == _obj) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        } 
        previous.setNext(current.getNext());
        current = null;
    } 

    public void deleteFirst() {
        Obj<T> temp = first;
        first = first.getNext();
        if (first == null) {
            last = null;
        }
        temp = null;
    }

    public void deleteLast() {
        Obj<T> current = first;
        Obj<T> previous = null;
        current = first;
        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        //current adalah last element
        last = previous;
        if (previous != null) {
            previous.setNext(null);
        } else {
            first = null;
        }
        current= null;
    }

    //mengembalikan elemen dengan tipe T pada indeks sesuai parameter
    //asumsi indeks posisi selalu valid
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

    //mengembalikan jumlah elemen dalam list
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

    public void printList() {
        Obj<T> current = first;
        while (current != null) {
            System.out.println(current.getInfo());
            current = current.getNext();
        }
    }

    public static void main(String[] args) {

    }
}