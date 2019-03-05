
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AList <Integer> list = new MyArrayList<>();
		
		
		//list.set(2, 3);		
		//System.out.println(list.get(2));

		for(int i=0; i<40 ; i++) {
			list.add(i);
			
			System.out.println(list.get(i));

		}
		
		//list.remove(20);
		list.set(5, 90);
		
		
		for(int x: list) {
			
			System.out.println(x);
			
		}
		
		AList<String> myStrings = new MyArrayList<>();
		
		for(int i =0; i <30; i++) {
			myStrings.add("item"+ i);
		}
		
		for(String s : myStrings) {
			
			System.out.println(s);
			
		}
		
		
		AList <String> sList = new MyLinkedList<>();
		
		for(int i=0 ; i<20 ; i++) {
		sList.add("This is awesome and works : " +i);
		}
		
		
		/*for(int i=0 ; i<20 ; i++) {
			System.out.println(sList.get(i));
			}
			*/
		
		for(String s : sList) {
			System.out.println(s);
			
		}
			

	}

}
