package src.mylist;

public class ArrayList  implements  IMylist{
    private  int[] data;
    private int size;

    public ArrayList(int capacity) {
        this.data = new int[capacity];
        this.size = 0;

    }

    @Override
    public int capacity() {
        return this.data.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(int ele) {
        if(this.size == this.data.length){
            throw new IllegalArgumentException("list is full");
        }
        this.data[this.size] = ele;
        this.size++;

    }

    @Override
    public void add(int index, int element) {
        if(this.size == this.data.length){
            throw new IllegalArgumentException("list is full");
        }
        if(index < 0 || index >= this.size) {
            throw new IllegalArgumentException("index wrong");
        }
        for(int i = this.size -1; i>= this.size; i--) {
            data[i+1] = data[i];
            data[index] = element;
            size++;
        }
    }
}
