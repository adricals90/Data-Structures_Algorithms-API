import java.util.Iterator;

public class MySingleLinkedList<AnyType> implements AList<AnyType> {
	
	private Node<AnyType> head ;
	private int counter=0;
	private int theSize;
	
	MySingleLinkedList(){
		doClear();
	}
	
	public int size() {
		return theSize;
	}
	
	private void doClear() {
		//Node<AnyType> node = new Node<>(null,null);
		
		head = new Node<>(null,null);
		
		
		counter++;
		theSize=0;

	}
	

	@Override
	public void set(int i, AnyType object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AnyType get(int i) {
		// TODO Auto-generated method stub
		return getNode(i).next.data;
	}
	
	private Node<AnyType> getNode(int idx){
		return getNode(idx,0, size()-1);
		
	}
	
	private Node<AnyType> getNode(int idx, int lowerBound, int upperBound){
		Node<AnyType> temp;
		
		if (idx < lowerBound || idx > upperBound ) {
			throw new IndexOutOfBoundsException();

		}
		
		temp = head;
		for(int i = 0; i < idx ; i++) {
			temp = temp.next;
			
		}
		
		return temp;
		
	}
	
	private void addFront(Node<AnyType> p, AnyType x) {
		
		Node<AnyType> newNode = new Node<>(x,null);
		p.next = newNode;
		counter++;
		theSize++;
		
	}

	@Override
	public void add(AnyType obj) {
		// TODO Auto-generated method stub
		add(size(), obj);
		
	}

	@Override
	public void add(int idx, AnyType object) {
		// TODO Auto-generated method stub
		addFront(getNode(idx,0,size()), object);
		
	}

	@Override
	public AnyType remove(int idx) {
		// TODO Auto-generated method stub
		
		return remove(getNode(idx));
	}
	
	public AnyType remove(Node<AnyType> node) {
		AnyType temp;
		node.next = node.next.next;
		temp = node.data;
		return temp;
		
		
	}

	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new SingleListIterator();
	}
	
	
	
	private static class Node<AnyType>{
		
	    AnyType data;
		Node<AnyType> next;
		
		Node(AnyType d, Node<AnyType> n){
			data = d;
			next = n;	
		}
		
		
	}
	
	private class SingleListIterator implements java.util.Iterator<AnyType>{
		
		private Node<AnyType> current = head.next;
		private int expected = counter;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public AnyType next() {
			// TODO Auto-generated method stub
			if(counter!= expected) {
				throw new java.util.ConcurrentModificationException();
			}
			if(!hasNext()) {
				throw new java.util.NoSuchElementException();
				
			}
			
			AnyType temp;
			temp= current.data;
			current = current.next;
			
			return temp;
		}
		
		public void remove() {
			if (counter != expected) {
				throw new java.util.ConcurrentModificationException();	
			}
			
		//	MySingleLinkedList.this.remove(current);
			
		}
		
	}
	

}
