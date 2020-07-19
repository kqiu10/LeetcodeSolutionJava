package src.mylist;

public class ArrayList  implements  IMylist{
    private  int[] data;
    private int size;

    public ArrayList() {
        this(10);
    }

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
        if (this.size == this.data.length){
            resize(data.length *2);
        }
        this.data[this.size] = ele;
        this.size++;

    }

    @Override
    public void add(int index, int element) {
        if (this.size == this.data.length){
            resize(data.length *2);
        }
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("index wrong");
        }
        for (int i = this.size -1; i>= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }

    @Override
    public boolean contains(int element) {
        for (int i = 0; i <size; i++) {
            if(data[i] == element) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void set(int idx, int ele) {
        if (idx <0 || idx >= size) {
           throw new IllegalArgumentException("index exceed");
        }
        data[idx] = ele;

    }

    @Override
    public int get(int idx) {
        if (idx <0 || idx >= size) {
            throw new IllegalArgumentException("index exceed");
        }
        return data[idx];
    }

    @Override
    public int remove(int idx) {
        if(idx <0 || idx >= size) {
            throw new IllegalArgumentException("index exceed");
        }
        int temp = data[idx];
        for (int i = idx; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        if (data.length / 4 == size && data.length / 2 != 0){
            resize(data.length / 2 );
        }
        return temp;
    }

    @Override
    public void removeElement(int element) {
        int temp = -1;
        for (int i = 0; i < size; i++) {
           if (data[i] == element) {
               temp = data[i];
               for (int j = i+1; j < size; j++) {
                   data[j-1] = data[j];
               }
               size--;
           }
        }
        if(temp == -1) {
            throw new IllegalArgumentException("element not exist");
        }
    }

    @Override
    public void print() {
        System.out.println("size is " + size);
        System.out.println("capacity is " + data.length);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");

        }
    }

    @Override
    public void resize(int capacity) {
        int[] newArrayList = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArrayList[i] = data[i];
        }
        data = newArrayList;
    }


}
