
public class BinarySearchTree <AnyType extends Comparable<? super AnyType>>{
	
	
	private Node<AnyType> root;
	
	BinarySearchTree(){
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int compare (AnyType object1, AnyType object2) {
		
		return object1.compareTo(object2);
		
	}
	
	public void insert(AnyType element) {
		root = insert(element, root);
	}
	
	private  Node<AnyType> insert(AnyType element, Node<AnyType> node) {
		
		if (node == null) {
			return new Node<>(element,null,null);
		}
		
		int c = compare(element, node.data);
		
		if (c > 0 ) {
			
			node.right = insert(element, node.right);
		}else if (c < 0) {
			node.left = insert(element, node.left);
		}else { System.out.println("duplicate");}
	
		return node;
	}
	
	public Node<AnyType> findMin(Node<AnyType> node) {
		if (node ==null) {
			return null;
		}
		
		while(node.left != null) {
			node= node.left;	
		}
		return node;
	}
	
	public Node<AnyType> findMax(Node<AnyType> node){
		
		if (node == null) {
			return null;
		}
		
		while(node.right!= null) {
			
			node = node.right;	
		}
		
		return node;
		
	}
	
	
	public void remove(AnyType element){
		
		remove(element,root);
		
	}
	
	private  Node<AnyType> remove(AnyType x, Node<AnyType> node){
		
		if(node == null) {
			return node;
		}
		
		int cmp = compare(x, node.data);
		
		if(cmp > 0) {
			node.right = remove(x,node.right);
		}else if (cmp < 0) {
			node.left = remove (x, node.left);
		}else if (node.left!=null && node.right!= null) {
			
			node.data = findMin(node).data;
			node.right = remove(node.data,node.right);
			
		}else {
			if (node.left!= null) {
				node = node.left;
				
			}else {
				node = node.right;
			}
		}
		
		return node;
		
	}
	
	public AnyType find(AnyType element) {
		
			try{
				
				return find(element,root).data ;
				
			}catch(Exception e){
				
			}
			
			return null;
		
	}
	
	private  Node<AnyType>find(AnyType x, Node<AnyType> node) {
		
		if (node == null) {
			return  node;
		}
		
		int cmp = compare(x, node.data);
		
		if(cmp > 0) {
			
			node = find(x, node.right);
			
		}else if (cmp < 0) {
			node = find(x, node.left);
		}else {
			
			System.out.println("found item :"+node.data);
			return node;
		}
	
		return node;
		
	}
	
	
	public void traverse() {
		traverse(root);
	}
	private  Node<AnyType> traverse(Node<AnyType>root){
		
		if(root == null) {
			return null;
		}else {
		
			traverse(root.left);
			System.out.println(root.data);
			traverse(root.right);
		
		}	
			
		
		return root;
		
	}
	
	
	private class Node<AnyType>{
		
		private AnyType data;
		private Node<AnyType> left;
		private Node<AnyType> right;
		
		Node(AnyType element){
			
			this(element, null, null);
	
		}
		
		Node(AnyType element, Node<AnyType> l, Node<AnyType> r){
			data = element;
			left = l;
			right = r;
			
		}
		
		
		
	}

}
