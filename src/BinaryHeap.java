
public class BinaryHeap<AnyType> implements Comparable<AnyType> {
	private static final int DEFAULT_SIZE = 10;
	private int numberOfElements=0;
	AnyType [] array;
	
	BinaryHeap (){
		array = (AnyType []) new Object[DEFAULT_SIZE];
	}
	
	public void insert(AnyType item) {
		
		if ( numberOfElements == array.length) {
			resize((array.length-1)*2);
		}else {
			
		}
		
		
		
		numberOfElements++;
	}
	

	private void resize(int newSize) {
		// TODO Auto-generated method stub
		AnyType [] temp = (AnyType []) new Object[newSize];
		for(int i= 0; i< newSize;i++) {
			temp[i]= array[i];
		}
		
		array = temp;
	
		
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
