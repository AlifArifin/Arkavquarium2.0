public class Obj <T> { //class dari elemen listobj
    /* Atribut */
    private T info; //mencatat informasi dari obj
    private Obj<T> next; //mencatat alamat next dari obj 

    /* Method */    
    /*Sekawan*/
    
    public Obj(T obj){
        info = obj;
        next = null;
    }

    /*Getter*/
    public T getInfo() {
        return info;
    }

    public Obj getNext() {
        return next;
    }

    /*Setter*/
    public void setInfo(T o) {
        info = o;
    }

    public void setNext(Obj<T> n) {
        next = n;
    }

    public void print() {
        Obj<T> p = this;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Obj<Integer> a1 = new Obj<Integer> (5);
        Obj<Integer> a2 = new Obj<Integer> (2);
        Obj<Integer> a3 = new Obj<Integer> (1);
        a1.setNext(a2);
        a2.setNext(a3);
        a1.print();
        System.out.println((a1.next).info);
    }
}
