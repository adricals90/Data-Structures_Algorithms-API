
public interface AList<AnyType> extends Iterable<AnyType>{
	
	 void set(int i, AnyType object);
     AnyType get(int i );
     void add(AnyType obj);
     void add(int idx, AnyType object);
     AnyType remove(int idx);
     
     java.util.Iterator<AnyType> iterator();
     
    
     

}
