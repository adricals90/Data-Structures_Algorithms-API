
public class MyStack <AnyType> implements iStack<AnyType>{
	
	AList<AnyType> list ;
	private int counter=-1;
	
	
	MyStack (AList<AnyType> l){
		list = l;
		
	}
	
	@Override
	public boolean isEmpty() {
		return counter == -1;
	}
	

	@Override
	public void push(AnyType item) {
		// TODO Auto-generated method stub
		list.add(item);
		counter++;
		
	}

	@Override
	public AnyType pop() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new java.util.EmptyStackException();
		}
	
		return list.remove(counter--);
	}

	@Override
	public AnyType peek() {
		// TODO Auto-generated method stub
		
		return list.get(counter);
	}

	
   
}
