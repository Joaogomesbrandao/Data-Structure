package Structures;
import java.util.*;

public class Heap {
    
    private int[] heap;
    private int tail;

    public Heap(int capacity){
        this.heap = new int[capacity];
        this.tail = -1;
    }

    public Heap(int[] heap){
        this.heap = heap;
        this.tail = heap.length - 1;
        this.buildHeap();
    }

    public boolean isEmpty(){
        return this.tail == -1;
    }

    public int left(int i){
        int value = 2*i + 1;
        if (value > this.tail) return -1;
        return value;
    }

    public int right(int i){
        int value = 2*i + 2;
        if (value > this.tail) return -1;
        return value;
    }

    public int parent(int i){
        if (i == 0) return -1;
        return (int) (i-1)/2;
    }

    private void resize(){
        int[] newHeap = new int[2 * this.heap.length];
        for (int i = 0; i < this.tail; i++){
            newHeap[i] = this.heap[i];
        }
        this.heap = newHeap;
    }

    public void add(int n){
        if (this.tail + 1 == this.heap.length) resize();
        this.heap[++this.tail] = n;

        int i = this.tail;
        while(i > 0 && this.heap[parent(i)] < this.heap[i]){
            int aux = this.heap[i];
            this.heap[i] = this.heap[parent(i)];
            this.heap[parent(i)] = aux;
            i = parent(i);
        }
    }

    private void buildHeap(){
        for (int i =  parent(this.tail); i >= 0; i--){
            heapify(i);
        }
    }

    public int remove(){
        if (isEmpty()) throw new NoSuchElementException();
        int elem = this.heap[0];
        this.heap[0] = this.heap[this.tail];
        this.tail -= 1;

        heapify(0);
        return elem;
    }

    private boolean isLeaf(int i){
        return i > parent(tail) && i <= tail;
    }
    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }
    private int max_index(int index, int left, int right){
        if (this.heap[index] > this.heap[left]){
            if (isValidIndex(right)){
                if (this.heap[index] < this.heap[right]){
                    return right;
                }
            }
            return index;
        } else {
            if (isValidIndex(right)){
                if (this.heap[left] < this.heap[right]){
                    return right;
                }
            }
            return left;
        }
    }
    private void swap(int i1, int i2){
        int aux = this.heap[i1];
        this.heap[i1] = this.heap[i2];
        this.heap[i2] = aux;
    }
    private void heapify(int index){
        if (isLeaf(index) || !isValidIndex(index)) return;

        int i_max = max_index(index, left(index), right(index));

        if (i_max != index){
            swap(index, i_max);
            heapify(i_max);
        }
    }

    public int size(){
        return this.tail + 1;
    }

    public String toString(){
        return Arrays.toString(this.heap);
    }
}
