package Structures;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class BST {
    
    Node root;
    int size;

    public BST(){
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int elem){
        this.size += 1;

        if (isEmpty()){
            this.root = new Node(elem);
        } else {
            Node aux = this.root;

            while(aux != null){
                if (elem < aux.value){
                    if (aux.left == null){
                        Node newNode = new Node(elem);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.left;
                } else {
                    if (aux.right == null){
                        Node newNode = new Node(elem);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }

    public void recursiveAdd(int elem){
        this.size += 1;
        if (isEmpty()){
            this.root = new Node(elem);
        } else {
            recursiveAdd(root, elem);
        }
    }
    private void recursiveAdd(Node current, int elem){
        if (elem < current.value){
            if (current.left == null){
                Node newNode = new Node(elem);
                current.left = newNode;
                newNode.parent = current;
                return;
            }
            recursiveAdd(current.left, elem);
        } else {
            if (current.right == null){
                Node newNode = new Node(elem);
                current.right = newNode;
                newNode.parent = current;
                return;
            }
            recursiveAdd(current.right, elem);
        }
    }

    public void remove(int k){
        Node node = this.search(k);

        if (node == null) return;
        
        if (node.isLeaf()){
            //é folha e só tem um elemento na árvore.
            if (node == this.root){
                this.root = null;
            } else {
                Node parent = node.parent;

                //verifica se o nó está a esq. ou dir. do pai.
                if (node.value < parent.value){
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        //Nó com dois filhos
        else if (node.hasSonLeft() && node.hasSonRight()){
            //Procura-se o sucessor para manter a regra de valores menores a esq. e maiores a dir.
            int value = this.sucessor(k).value;
            remove(value);
            node.value = value;
        }
        //Nó com apenas um filho
        else {
            //Procura-se o filho do nó, a esq. ou dir.
            Node child = (node.left != null) ? node.left : node.right;
            
            //Se for a raiz o nó q desejamos remover, eu atualizo a raiz com o child.
            if (node == this.root){
                this.root = child;
                this.root.parent = null;
            } else {

                //Verifico se o pai tem valor menor ou maior-igual do que o filho e realizo a remoção.
                Node parent = node.parent;
                if (node.value < parent.value) parent.left = child;
                else parent.right = child;
                
                child.parent = parent;
            }
        }
        this.size -= 1;
    }

    public boolean contains(int elem){
        if (isEmpty()) return false;
        Node aux = this.root;

        while (aux != null){
            if (elem == aux.value) return true;
            else if (elem < aux.value) aux = aux.left;
            else aux = aux.right;
        }

        return false;
    }

    public Node search(int elem){
        if (isEmpty()) return null;
        Node aux = this.root;

        while (aux != null){
            if (elem == aux.value) return aux;
            else if (elem < aux.value) aux = aux.left;
            else aux = aux.right;
        }

        return aux;
    }

    public Node recursiveSearch(int elem){
        return recursiveSearch(root, elem);
    }
    private Node recursiveSearch(Node current, int elem){
        if (current == null) return null;
        if (elem == current.value) return current;
        else if (elem < current.value) return recursiveSearch(current.left, elem);
        else return recursiveSearch(current.right, elem);
    }

    //Retorno o mín. da árvore.
    public Node min(){
        return min(this.root);
    }
    //Retorno o min. baseado no nó desejado.
    private Node min(Node current){
        if (current.left == null) return current;
        else return min(current.left); 
    }

    //Retorno o máx. da árvore.
    public Node max(){
        return max(root);
    }
    //Retorno o máx. baseado no nó desejado.
    private Node max(Node current){
        if (current == null) return null;
        else return max(current.right);
    }

    //Retorna a qtd. de folhas de uma árvore.
    public int countLeaf(){
        return countLeaf(this.root);
    }
    private int countLeaf(Node current){
        if (current == null) return 0;
        int value = 0;

        if (current.left == null && current.right == null) value += 1;
        return value + countLeaf(current.left) + countLeaf(current.right);
    }

    //Retorna a altura da árvore
    public int height(){
        return height(this.root);
    }
    //Retorna a altura baseado no nó desejado.
    private int height(Node current){
        if (current == null) return -1;
        return 1 + Math.max(height(current.left), height(current.right));
    }

    public Node sucessor(int k){
        Node current = this.search(k);
        if (current == null) return null;
        if (current.right != null) return min(current.right);
        else {
            Node aux = current.parent;

            while (aux != null && aux.value < current.value) aux = aux.parent;
            
            return aux;
        }
    }

    public Node predecessor(int k){
        Node node = this.search(k);

        if (node == null) return null;
        if (node.left != null) return max(node.left);
        else {
            Node aux = node.parent;

            while (aux != null && aux.value > node.value) aux = aux.parent;
            
            return aux;
        }
    }

    //Nó, esquerda, direita
    public ArrayList<Integer> preOrder(){
        return preOrder(this.root);
    }
    private ArrayList<Integer> preOrder(Node current){
        ArrayList<Integer> path = new ArrayList<>();
        if (current != null){
            path.add(current.value);
            path.addAll(preOrder(current.left));
            path.addAll(preOrder(current.right));
        }
        return path;
    }

    //Esquerda, nó, direita
    public ArrayList<Integer> inOrder(){
        return inOrder(this.root);
    }
    private ArrayList<Integer> inOrder(Node current){
        ArrayList<Integer> path = new ArrayList<>();
        if (current != null){
            path.addAll(inOrder(current.left));
            path.add(current.value);
            path.addAll(inOrder(current.right));
        }
        return path;
    }

    //Esquerda, direita, nó
    public ArrayList<Integer> posOrder(){
        return posOrder(this.root);
    }
    private ArrayList<Integer> posOrder(Node current){
        ArrayList<Integer> path = new ArrayList<>();
        if (current != null){
            path.addAll(posOrder(current.left));
            path.addAll(posOrder(current.right));
            path.add(current.value);
        }
        return path;
    }


    public int size(){
        return this.size;
    }

    public Deque<Integer> bsfTree(){
        Deque<Node> queue = new LinkedList<Node>();
        Deque<Integer> out = new LinkedList<Integer>();

        if (!isEmpty()){
            queue.addLast(this.root);
            while(!queue.isEmpty()){
                Node aux = queue.removeFirst();

                out.addLast(aux.value);

                if (aux.left != null)
                    queue.addLast(aux.left);

                if (aux.right != null)
                    queue.addLast(aux.right);
            }
        }

        return out;
    }

    public void inverteBST(){
        inverteBST(root);
    }
    private void inverteBST(Node node){
        if (node != null){
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            inverteBST(node.left);
            inverteBST(node.right);
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;
    Node parent;

    public Node(int elem){
        this.value = elem;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    boolean isLeaf(){
        if (left == null && right == null) return true;
        return false;
    }

    boolean hasSonLeft(){
        if (left != null) return true;
        return false;
    }

    boolean hasSonRight(){
        if (right != null) return true;
        return false;
    }
}