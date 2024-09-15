package Structures;
import java.util.*;

/**
 * This class represents the creation of an
 * Linked List based on integers.
 */
public class LinkedList{

    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.head == null && this.tail == null;
    }

    public int getFirst(){
        if (isEmpty()) throw new NoSuchElementException();
        return this.head.value;
    }

    public int getLast(){
        if (isEmpty()) throw new NoSuchElementException();
        return this.tail.value;
    }

    public int get(int index){
        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();

        Node aux = this.head;
        for (int i = 0; i < index; i++){
            aux = aux.next;
        }

        return aux.value;
    }

    public void addFirst(int number){
        Node newNode = new Node(number);
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }

        this.size += 1;
    }

    public void addLast(int number){
        Node newNode = new Node(number);
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        this.size += 1;
    }

    public void add(int index, int number){
        if (index < 0 || index > this.size) throw new IndexOutOfBoundsException();

        Node newNode = new Node(number);

        if (index == 0) addFirst(number);
        else if (index == this.size - 1) addLast(number);
        else {
            Node aux = this.head;

            for (int i = 0; i < index - 1; i++){
                aux = aux.next;
            }

            newNode.next = aux.next;
            aux.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = aux;
            
            this.size += 1;
        }
    }

    public int removeFirst(){
        if (isEmpty()) throw new NoSuchElementException();

        int oldValue = this.head.value;
        if (this.size == 1){
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.size -= 1;
        return oldValue;
    }

    public int removeLast(){
        if (isEmpty()) throw new NoSuchElementException();
        
        int oldValue = this.tail.value;
        if (this.size == 1){
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.size -= 1;
        return oldValue;
    }

    public int remove(int index){
        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();

        if (index == 0) return removeFirst();
        else if (index == this.size - 1) return removeLast();
        else {
            Node aux = this.head;
            for (int i = 0; i < index; i++){
                aux = aux.next;
            }

            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;

            this.size -= 1;
            return aux.value;
        }
    }

    public boolean removeByValue(int number){
        Node aux = this.head;

        for (int j = 0; j < this.size; j++){
            if (aux.value == number){
                if (j == 0){
                    removeFirst();
                    return true;
                } else if (j == this.size - 1){
                    removeLast();
                    return true;
                } else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;

                    this.size -= 1;
                    return true;
                }
            }
            aux = aux.next;
        }

        return false;
    }

    public int indexOf(int number){
        Node aux = this.head;

        for (int i = 0; i < this.size; i++){
            if (aux.value == number) return i;
            aux = aux.next;
        }

        return -1;
    }

    public boolean contains(int number){
        return indexOf(number) != 1;
    }

    public int lastIndexOf(int number){
        int k = -1;
        Node aux = this.head;

        for (int j = 0; j < this.size; j++){
            if (aux.value == number) k = j;
            aux = aux.next;
        }

        return k;
    }

    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }

    public int size(){
        return this.size;
    }
}

class Node{

    int value;
    Node next;
    Node prev;

    public Node(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}