
public interface IQueue <AnyType>  {
	
	void enqueue(AnyType item);
	AnyType dequeue();
	

}
