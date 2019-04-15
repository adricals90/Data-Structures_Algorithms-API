
public class MyQueue<AnyType> implements IQueue<AnyType> {
	
	
	AList<AnyType> myList;
	
	int front=0;
	int back;
	int currentSize;
	
	
	MyQueue(AList <AnyType> list){
		
		this.myList = list;
		
		
	}
	
	@Override
	public void enqueue(AnyType item) {
		// TODO Auto-generated method stub
		
			back++;
			currentSize++;
			myList.add(back, item);
			
	
	}

	@Override
	public AnyType dequeue() {
		// TODO Auto-generated method stub
		AnyType temp = myList.remove(front);
		front++;
		currentSize--;
		 
	
		
		return temp;
	}
	
	private int size (int f, int b) {
		
		return b-f;
		
	}

}
