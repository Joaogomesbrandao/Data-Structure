package Structures;
/**
 * This class represents the creation of an arraylist
 * based on an array of integers.
 */

public class ArrayList{

    private int[] list;
    private static final int capacityDefault = 20;
    private int size;

    public ArrayList(){
        this.list = new int[capacityDefault];
        this.size = 0;
    }

    public ArrayList(int capacity){
        this.list = new int[capacity];
        this.size = 0;
    }

    private void resize(int newCapacity){
        int[] newList = new int[newCapacity];
        for (int i = 0; i < this.list.length; i++){
            newList[i] = this.list[i];
        }
        this.list = newList;
    }

    private void assegureCapacity(int newCapacity){
        if (newCapacity > this.list.length){
            resize(Math.max(newCapacity, this.list.length * 2));
        }
    }
    
    public boolean add(int value){
        assegureCapacity(this.size + 1);
        this.list[this.size++] = value;
        return true;
    }

    private void shiftRIGHT(int index){
        if (index == this.list.length - 1){
            throw new IndexOutOfBoundsException();
        }

        for (int i = this.size; i > index; i--){
            this.list[i] = this.list[i-1];
        }
    }

    public void add(int index, int value){
        if (index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }

        assegureCapacity(this.size + 1);
        shiftRIGHT(index);

        this.list[index] = value;
        this.size += 1;
    }

    public void set(int index, int value){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        this.list[index] = value;
    }

    public int get(int index){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        return this.list[index];
    }

    public int indexOf(int value){
        for (int i = 0; i < this.size; i++){
            if (this.list[i] == value){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    private void shiftLEFT(int index){
        for (int i = index; i < this.size; i++){
            this.list[i] = this.list[i+1];
        }
    }

    public int remove(int index){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }

        int value = this.get(index);
        shiftLEFT(index);

        this.size -= 1;
        return value;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
}