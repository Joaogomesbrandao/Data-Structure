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
        return head == null && tail == null;
    }

    public void addLast(int value){
        Node newNode = new Node(value);

        if (isEmpty()){
            head = newNode;
            tail = newNode;
        } else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
            tail = newNode;
        }
        this.size += 1;
    }

    public void addFirst(int value){
        Node newNode = new Node(value);

        if (isEmpty()){
            head = newNode;
            tail = newNode;
        } else{
            newNode.next = this.head;
            this.head.prev = newNode;
            head = newNode;
        }

        this.size += 1;
    }


    public void add(int index, int value){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(value);

        if (index == 0){
            addFirst(value);
        } else if(index == this.size-1){
            addLast(value);
        } else{

            Node aux = this.head;
            for (int i = 0; i < index -1; i++){
                aux = aux.next;
            }

            newNode.next = aux.next;
            aux.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = aux;
        }

        this.size += 1;
    }

    public int get(int index){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }

        Node aux = this.head;

        for (int j = 0; j < index; j++){
            aux = aux.next;
        }

        return aux.value;
    }

    public int indexOf(int value){
        Node aux = this.head;
        int i = 0;

        while(aux != null){
            if (aux.value == value) return i;
            aux = aux.next;
            i++;
        }

        return -1;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    public int getFirst(){
        if (isEmpty()) throw new RuntimeException();
        return this.head.value;
    }

    public int getLast(){
        if (isEmpty()) throw new RuntimeException();
        return this.tail.value;
    }

    public int removeFirst(){
        if (isEmpty()) throw new NoSuchElementException();

        int oldValue = this.head.value;

        if (this.head.next == null){
            this.head = null;
            this.tail = null;
        } else{
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.size -= 1;
        return oldValue;
    }

    public int removeLast(){
        if (isEmpty()) throw new NoSuchElementException();

        int oldValue = this.tail.value;

        if (this.head.next == null){
            this.head = null;
            this.tail = null;
        } else{
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.size -= 1;
        return oldValue;
    }

    public int remove(int index){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) removeFirst();
        if (index == this.size - 1) removeLast();

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