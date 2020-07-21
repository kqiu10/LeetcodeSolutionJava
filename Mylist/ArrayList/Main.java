package Mylist.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayListImpl arraylist = new ArrayListImpl();
        for (int i = 0; i < 9; i++) {
            arraylist.add(i);

        }
        arraylist.remove(0);
        arraylist.remove(0);
        arraylist.remove(0);
        arraylist.remove(0);
        arraylist.remove(0);
        arraylist.remove(0);
        arraylist.remove(0);



       arraylist.print();
    }
}
