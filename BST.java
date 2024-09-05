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
