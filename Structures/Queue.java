package Structures;
/**
 * This class represents he creation of an Queue
 * based on integers;
 */

public class Queue {
    
    private int[] fila;
    private int head;
    private int tail;

    public Queue(int capacidade) {
        this.fila = new int[capacidade];
        this.head = -1;
        this.tail = -1;
    }

    public boolean isEmpty() {
        return head == -1 && tail ==-1;
    }

    public boolean isFull() {
        return (tail+1)%this.fila.length == head;
    }

    public void addLast(int valor) {
        if (isFull()) throw new RuntimeException("Full Queue!");
        if (isEmpty()) head = 0;
        tail = (tail+1) % fila.length;
        fila[tail] = valor;
    }

    public int removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty Queue!");
        int k = fila[head];
        if (head == tail){
            head = -1;
            tail = -1;
        } else{
            head = (head+1)%fila.length;
        }
        return k;
    }

    public int getFirst() {
        if (isEmpty()) throw new RuntimeException("Empty Queue!");
        return fila[head];
    }

    public int getLast() {
        if (isEmpty()) throw new RuntimeException("Empty Queue!");
        return fila[tail];
    }

    public String toString() {
        if (isEmpty()) return "";
        Queue aux = new Queue(this.size());
        StringBuffer sb = new StringBuffer();

        while(size()>0){
            aux.addLast(this.getFirst());
            sb.append(this.removeFirst());
            if (this.size()>0){
                sb.append(", ");
            }
        }
        while(!aux.isEmpty()){
            this.addLast(aux.removeFirst());
        }

        return sb.toString();
    }
    
    public int indexOf(int valor) {
        if (isEmpty()) return -1;
        Queue aux = new Queue(this.size());
        int i = 0;
        int k = -1;
        int size = this.size();

        while(i < size){
            int current = this.removeFirst();
            if (current == valor && k == -1) {
                k = i;
            }
            aux.addLast(current);
            i++;
        }

        while (!aux.isEmpty()){
            this.addLast(aux.removeFirst());
        }

        return k;
    }

    public int lastIndexOf(int valor) {
        if (isEmpty()) return -1;
        Queue aux = new Queue(this.size());
        int i = 0;
        int k = -1;
        int size = this.size();

        while(i < size){
            int current = this.removeFirst();
            if (current == valor) {
                k = i;
            }
            aux.addLast(current);
            i++;
        }

        while (!aux.isEmpty()){
            this.addLast(aux.removeFirst());
        }

        return k;
    }
    
    public int size() {
        if (isEmpty()) return 0;
        return (tail >= head) ? (tail-head+1) : (fila.length - head + tail +1);
    }
}
