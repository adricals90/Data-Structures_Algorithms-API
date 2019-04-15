import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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
		
		
		AList<String> singleList = new MySingleLinkedList<>();
		singleList.add("this is gonna work amazingly 1");
		singleList.add("this is gonna work amazingly 2");
		singleList.add("this is gonna work amazingly 3");

		
		System.out.println(singleList.get(0));
		System.out.println(singleList.get(1));
		System.out.println(singleList.get(2));
		
		//singleList.remove(0);
		//System.out.println(singleList.get(0));
		//System.out.println(singleList.get(1));

		
		for(String s : singleList) {
			System.out.println(s);
		}
		
		
		iStack <String> stack = new MyStack<>(new MyArrayList<>());
		
		for (int i=0; i<100 ; i++) {
		stack.push("this is great :" + i);
		
		}
	
		for (int i=0; i<100 ; i++) {
			System.out.println(stack.pop());
			
			}
		
		stack = new MyStack<>(new MySingleLinkedList<>());
		
		for (int i=0; i<100 ; i++) {
			stack.push("this is great :" + i);
			
			}
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
			
			}
		
		 String [] data = {"(","[","(",")","]","[","(",")","]",")"};
		 iStack<String>  st= new MyStack<>(new MyLinkedList<>());
		 balanceSymbols(data,st);
		 
		 
		iStack<Double> sta = new MyStack<>(new MyLinkedList<>());
		String [] d = {"4.99","1.06","*","5.99","+","6.99", "1.06","*","+"};
		
		postfixCalc(d,sta);
		
		
		 BinarySearchTree<Integer> bTree = new BinarySearchTree<>();
		 
		 bTree.insert(6);
		 bTree.insert(2);
		 bTree.insert(1);
		 bTree.insert(5);
		 bTree.insert(3);
		 bTree.insert(4);
		 bTree.insert(8);
		 bTree.insert(7);
		 bTree.insert(12);
		 bTree.insert(11);

		 
		 System.out.println(bTree.find(7));
		// bTree.remove(8);
		 System.out.println(bTree.find(8));
		 
		 bTree.traverse();
		 
		 
		 Set<String> mySet = new TreeSet<>();
		 mySet.add("a");
		 mySet.add("a");
		 mySet.add("b");

		 System.out.println("size of the set: "+mySet.size());
		

		 
		 
			

	}
	public static void balanceSymbols( Object [] m, iStack<String> s) {
		
		for(int i =0 ; i< m.length ;i++){
			
			switch(m[i].toString()){
				case "(": s.push(m[i].toString());
							System.out.println(m[i].toString()+" pushed");
				          break;
				case ")": if(s.pop().toString().equals("(")) {
								System.out.println("PASS : "+m[i].toString());
							}else {
								throw new java.util.MissingFormatArgumentException(s.toString());
							}
						  break;
				case "[" : s.push(m[i].toString());
							System.out.println(m[i].toString()+" pushed");

						   break;
				case "]" :if(s.pop().toString().equals("[")) {
								System.out.println("PASS : "+m[i].toString());
							}else {
									throw new java.util.MissingFormatArgumentException(s.toString());
							}
							break;
			}
			
			
		}
		
		if(!s.isEmpty()) {
			System.out.println("Error: stack is not empty");
		}
		
	}
	
	public static void postfixCalc(Object [] arr, iStack<Double> l) {
		
		for(int i = 0; i< arr.length ; i++) {
			
			
			if (!isInteger(arr[i].toString())) {
				
			switch(arr[i].toString()) {
			case "+":  l.push((double)l.pop()+(double)l.pop());
					    break;
			case "-":  l.push((double)l.pop()-(double)l.pop());
						break;
			case "*": 
						l.push((double)l.pop()*(double)l.pop());
						break;
			 }
			}else {
			
				System.out.println((double)Double.parseDouble(arr[i].toString()));
			l.push((double)Double.parseDouble(arr[i].toString()));
			
			}
		}
		
	//	System.out.println("Answer : "+l.pop());

		
		if(!l.isEmpty()) {
			System.out.println("Answer : "+l.pop());
		}else {
			System.out.println("empty stack: Not enough operators");

		}
		
	}
	
	 public static boolean isInteger(String s) {
	      boolean isValidInteger = false;
	      try
	      {
	         Double.parseDouble(s);
	         // s is a valid integer
	         isValidInteger = true;
	      }
	      catch (NumberFormatException ex)
	      {
	         // s is not an integer
	      }
	 
	      return isValidInteger;
	   }
	 
	 
	 
	 
	 
	 

}
