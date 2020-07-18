package src.mylist;

public class Main {
    public static void main(String[] args) {
        ArrayList arraylist = new ArrayList();
       arraylist.add(1);
       arraylist.add(2);
       arraylist.add(3);
       arraylist.add(1,10);
       arraylist.remove(2);
       arraylist.removeElement(1);
        System.out.println("what is get " + arraylist.get(1));
       arraylist.set(0,20);

       arraylist.print();
    }
}
