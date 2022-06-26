
public class AVL<E extends Comparable<E>> {
	class Node{
		protected E data;
		protected Node left;
		protected Node right;
		protected int fb;
		
		public Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.fb = 0;
		}
		public Node(E data) {
			this(data, null, null);
		}
	}
	private Node root;
	private boolean height;
	
	public AVL() {
		this.root = null;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void insert (E x) throws ItemDuplicated {
		this.height = false;
		this.root = insertRec(x, this.root);
	}
	
	private Node insertRec(E x,Node current) throws ItemDuplicated{
		Node res = current;
		if(current == null) {
			this.height = true;
			res = new Node(x);
		}	
		else {
			int resC = current.data.compareTo(x);
			if(resC == 0)
				throw new ItemDuplicated("El dato " + x + "Ya fue insertado a ");
			if(resC < 0) {
				res.right = insertRec(x, current.right);
				if (this.height) {
					switch(res.fb) {
					case -1 : res.fb = 0; this.height = false; break;
					case 0 : res.fb = 1; this.height = true; break;
					case 1 : //res.fb = 2;
					           res = balanceToLeft(res);
					           this.height = false;
					}
				}
			}
			else {//falta
				res.left = insertRec(x, current.left);
			}
		}	
		return res;
	}
	
	private Node balanceToLeft(Node node) {
		Node son = node.right;
		switch(son.fb) {
		case 1 : node.fb = 0;
		         son.fb = 0;  
			     node = rotateSL(node); 
			     break;
		case -1: Node grandson = son.left;
		         switch(grandson.fb) {
		         case -1 : node.fb = 0; son.fb = -1; break;
		         case 0 : node.fb = 0; son.fb = 0; break;
		         case 1 : node.fb = 1; son.fb = 0; break;
		         }
		         grandson.fb = 0;
		         node.right = rotateSR(son);
		         node = rotateSL(node);
		         break;
		}
		return node;
	}
	
	private Node rotateSL(Node node) {
		Node son = node.right;
		node.right = son.left;
		son.left = node;
		node = son;
		return node;
	}
	
	private Node rotateSR(Node node) {
		Node son = node.left;
		node.left = son.right;
		son.right = node;
		node = son;
		return node;
	}
	
	public String toString() {
		if (isEmpty())
			return"Arbol vacio... ";
		return postOrden(this.root);
	}
	
	private String postOrden(Node current) {
		String str = "";
		if(current.left != null) str += postOrden(current.left);
		str += current.data + "[" + current.fb +"], ";
		if(current.right != null) str += postOrden(current.right);
		return str;
	}

}
