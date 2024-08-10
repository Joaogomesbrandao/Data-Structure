import java.util.NoSuchElementException;

/**
 * This class represents the creation of an Stack
 * based on integers;
 */

public class Stack {
    
    private int top;
    private int[] stack;

    public Stack(int capacity){
        this.stack = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top + 1 == this.stack.length; 
    }

    public void push(int value){
        if (isFull()) throw new RuntimeException();
        this.stack[++this.top] = value;
    }

    public int pop(){
        if (isEmpty()) throw new NoSuchElementException();
        return this.stack[this.top--];
    }

    public int peek(){
        return this.stack[this.top];
    }

    public int size(){
        return this.top+1;
    }

    public String toString() {
        if (isEmpty()) return "";
        Stack aux = new Stack(size());
        StringBuffer sb = new StringBuffer();
        
        while (this.top > -1){
            aux.push(peek());
            sb.append(pop());
            if (size() > 0){
                sb.append(", ");
            }
        }

        while (!aux.isEmpty()){
            this.push(aux.pop());
        }

        return sb.toString();
    }

    public int indexOf(int valor) {
        if (isEmpty()) return -1;
        Stack aux = new Stack(size());
        int size = this.size();
        int i = 0;
        int k = -1;

        while (i < size){
            int current = this.pop();
            if (current == valor && k == -1) k = i;
            aux.push(current);
            i++;
        }

        while (!aux.isEmpty()){
            this.push(aux.pop());
        }

        return k;
    }
}
