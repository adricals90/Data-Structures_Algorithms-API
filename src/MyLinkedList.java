import java.util.Iterator;

public class MyLinkedList<AnyType> implements AList<AnyType>{
	
	private int listSize;
	private int modCount=0;
	private Node<AnyType> head;
	private Node<AnyType> tail;
	
	MyLinkedList() {
		doClear();
	}
	
	public void doClear() {
		head = new Node<>(null,null,null);
	    tail = new Node<>(null,head,null);
		head.next = tail;
		listSize=0;
		modCount++;
		
	}
	
	public int size() {
		return listSize;
	}
	

	@Override
	public void set(int i, AnyType object) {
		// TODO Auto-generated method stub
		
	}
	
	private Node<AnyType> getNode(int idx, int lowerBound , int upperBound){
		
		Node<AnyType> myNode;
		
		if(idx < lowerBound || idx > upperBound) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
		if (idx < (size()/2)) {
			myNode= head.next;
			
			for (int i = 0; i< idx; i++) {
				
				myNode = myNode.next;
				
			 }	
		}else {
				myNode = tail;
				for (int i = size(); i > idx; i--) {
					myNode = myNode.prev;	
				}
		}
		

		return myNode;
	}
	
	public Node<AnyType> getNode(int idx){
		
		return getNode(idx ,  0 , size()-1);	
		
	}

	@Override
	public AnyType get(int i) {
		// TODO Auto-generated method stub
		return getNode(i).data;
	}

	@Override
	public void add(AnyType obj) {
		// TODO Auto-generated method stub
		add(size(), obj);
	}

	@Override
	public void add(int idx, AnyType object) {
		// TODO Auto-generated method stub
		addBefore(getNode(idx,0,size()), object);
		
	}
	
	private void addBefore(Node<AnyType> p, AnyType x) {
		
		Node<AnyType> newNode = new Node<>(x,p.prev,p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		listSize++; 
		modCount++;  
	}

	@Override
	public AnyType remove(int idx) {
		// TODO Auto-generated method stub
		return remove(getNode(idx));
	}
	
	private AnyType remove(Node<AnyType> node){
		
		AnyType data;
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		data= node.data;
		listSize--;
		modCount--;
		
		return data;
			
	}

	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	
	private static class Node<AnyType> {
		
		AnyType data;
		Node<AnyType> prev;
		Node<AnyType> next;
		
		Node(AnyType d, Node<AnyType> p, Node<AnyType> n){
			this.data = d;
			this.prev =p;
			this.next = n;
		
		}	

	}
	
	private class LinkedListIterator implements java.util.Iterator<AnyType>{
		
		private Node<AnyType> current = head.next;
		private int expectedMod = modCount;
		private boolean safeToRemove = false;
		

		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != tail;
		}

		@Override
		public AnyType next() {
			// TODO Auto-generated method stub
			if( modCount != expectedMod ) {
				throw new java.util.ConcurrentModificationException();
			}
			
			if(!hasNext()) {
				throw new java.util.NoSuchElementException();
				
			}
			
			AnyType temp = current.data;
			current = current.next;
			safeToRemove = true;
			return temp;
		}
		
		
		public void remove() {
			if (modCount != expectedMod) {
				throw new java.util.ConcurrentModificationException();	
			}
			if (!safeToRemove) {
				throw new IllegalStateException();
			}
			
		//	MyLinkedList.remove(current.prev);
				expectedMod ++;
				safeToRemove = false;
				
			
		}
		
	}


}
