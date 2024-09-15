package Structures;
public class BST{

	Node root;
	int size;

	public BST(){
		this.root = null;
		this.size = 0;
	}

	public boolean isEmpty(){
		return this.root == null;
	}

	/**
	 * This method adds the new Node interactively.
	 */
	public void add(int v){
		this.size += 1;
		
		if (isEmpty()){
			this.root = new Node(v);
		} else {
			Node aux = this.root;

			while(aux != null){
				if (v < aux.value){
					if (aux.left == null){
						Node newNode = new Node(v);
						aux.left = newNode;
						newNode.parent = aux;
						return;
					}
					aux = aux.left;
				} else {
					if (aux.right == null){
						Node newNode = new Node(v);
						aux.right = newNode;
						newNode.parent = aux;
						return;
					}
					aux = aux.right;
				}
			}
		}
	}

	public void recursiveAdd(int v){
		this.size += 1;
		if (isEmpty()){
			this.root = new Node(v);
		} else {
			recursiveAdd(this.root,v);
		}

	}
	private void recursiveAdd(Node current, int v){
		if (v < current.value){
			if (current.left == null){
				Node newNode = new Node(v);
				current.left = newNode;
				newNode.parent = current;
				return;
			}
			recursiveAdd(current.left, v);
		} else {
			if (current.right == null){
				Node newNode = new Node(v);
				current.right = newNode;
				newNode.parent = current;
				return;
			}
			recursiveAdd(current.right, v);
		}
	}

	public boolean contains(int v){
		if (isEmpty()) return false;
		Node aux = this.root;

		while (aux != null){
			if (v == aux.value) return true;
			else if (v < aux.value) aux = aux.left;
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

		return null;
	}

	public Node recursiveSearch(int elem){
		return recursiveSearch(this.root, elem);
	}
	private Node recursiveSearch(Node current, int elem){
		if (current == null) return null;
		if (elem == current.value) return current;
		if (elem < current.value) return recursiveSearch(current.left, elem);
		else return recursiveSearch(current.right, elem);
	}

	public Node min(){
		if (isEmpty()) return null;
		return min(this.root);
	}
	private Node min(Node aux){
		if (aux.left == null) return aux;
		else return min(aux.left);
	}

	public Node max(){
		if (isEmpty()) return null;
		return max(this.root);
	}
	private Node max(Node aux){
		if (aux.right == null) return aux;
		else return max(aux.right);
	}

	public int contaFolha(){
		return contaFolha(this.root);
	}
	private int contaFolha(Node current){
		if (current == null) return 0;
		int value = 0;

		if (current.left == null && current.right == null) value += 1;
		return value + contaFolha(current.left) + contaFolha(current.right);
	}

	public int height(){
		return height(this.root);
	}
	private int height(Node current){
		if (current == null) return -1;
		else return 1 + Math.max(height(current.left), height(current.right));
	}

	public Node sucessor(Node current){
		if (current == null) return null;
		if (current.right != null) return min(current.right);
		else{
			Node aux = current.parent;

			while(aux != null && aux.value < current.value){
				aux = aux.parent;
			}

			return aux;
		}
	}

	public Node predecessor(Node current){
		if (current == null) return null;
		if (current.left != null) return max(current.left);
		else {
			Node aux = current.parent;

			while(aux != null && aux.value > current.value){
				aux = aux.parent;
			}

			return aux;
		}
	}

}

class Node{
	Node left;
	Node right;
	Node parent;
	int value;

	public Node(int v){
		this.value = v;
		this.right = null;
		this.left = null;
		this.parent = null;
	}
}
