import java.util.Iterator;

public class MyArrayList<AnyType> implements AList<AnyType> {
	private static final int ARRAY_SIZE=10;
	private int actualSize;
	
	private AnyType [] myList ;

	public MyArrayList(){
		    actualSize=0;
			fixCapacity(ARRAY_SIZE);
	}
	
	public int size() {
		return actualSize;
	}


	@Override
	public void set(int i, AnyType object ) {
		
		if (i < 0 || i >= size() ) {
			  throw new ArrayIndexOutOfBoundsException();

		     
		}
			 this.myList[i]= object;
			
	}


	@Override
	public AnyType get(int i) {
		
		if(i < 0 || i >= size()) {
			
			throw new ArrayIndexOutOfBoundsException();

		}else {
			return myList[i];
		}	
	}


	@Override
	public void add(AnyType obj) {
		add(size(), obj);
		
		
	}


	@Override
	public void add(int idx, AnyType object) {
		// TODO Auto-generated method stub
		if (size() == myList.length) {
			fixCapacity(size()*2 +1);	
		}else {
			for(int i = size(); i > idx; i--) {
				myList[i]= myList[i-1];
			}
			
		}
		
			myList[idx]= object;
			actualSize++;
		
		
	}


	@Override
	public AnyType remove(int idx) {
		// TODO Auto-generated method stub
		
		AnyType item = myList[idx];
		
		for(int i =idx; i<size(); i++) {
			myList[i]= myList[i++];
		}
		
		actualSize --;
		 
	  return item;
	}


	
	
	public void fixCapacity(int newCapacity) {
			if (size() < newCapacity) {
				
				AnyType [] temp = myList;
				myList = (AnyType []) new Object[newCapacity];
				
				for(int i=0;i < size();i++) {
					myList[i]= temp[i];
					
				}
			
			}
		
	}

	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator();
	}
	
	
	private class ArrayIterator implements java.util.Iterator<AnyType> {
		
		private int current=0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current< size();
		}

		@Override
		public AnyType next() {
			// TODO Auto-generated method stub
			
			if(!hasNext()) {
				//throw java.util.NoSuchElementException();				
			}
			
			return (AnyType) myList[current++];
		}
		
		public void remove() {
			 MyArrayList.this.remove(--current);
		}
		
	}
	

}
