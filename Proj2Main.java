public class Proj2Main {

	public static void main(String[] args) throws QueueUnderflowException, OutOfRangeException{
		//Provide your tests below.
		            
LinkedDeque<String> l1  = new LinkedDeque<String>();

	LinkedDeque<Integer> l2  = new LinkedDeque<Integer>();

	System.out.println("l1 is empty "+  l2.isEmpty());
	l2.enqueueFront(1);
	l2.enqueueFront(2);
	l2.enqueueFront(3);
	System.out.println( "After enqueing front 3 elements: " +l2);
	l2.enqueueRear(4);
	l2.enqueueRear(5);
	l2.enqueueRear(6);
	System.out.println("After enqueing 3 rear elements: " + l2 );
	
	
	System.out.println("Deque the last element: "  + l2.dequeueRear());
	System.out.println("Printing the elements in Deque: " + l2);
	
	System.out.println("Deque the first element: "  + l2.dequeueFront());
	System.out.println("Printing the elements in Deque: " + l2);
	
	
	System.out.println("Size is :" + l2.size());
	
	/*
	//System.out.println( " Printing all elements" +l1.toString());
	System.out.println("Deque from rear is :"+l2.dequeueRear());
	System.out.println("Printing the elements in Deque: " + l2);
	System.out.println("Now size is: "+l2.size());
	System.out.println("Deque from front is: "+ l2.dequeueFront());
	System.out.println(l2.toString());
	// String test2 = l1.dequeueNth(false,1);
	*/
	
	System.out.println("DequeueNth  in forward 2 position is: " + l2.dequeueNth(true, 2));
	System.out.println(l2.toString());
	l2.enqueueRear(7);
	System.out.println( "After enqueing rear : " +l2);
	
	System.out.println(l2.toString());
	

	System.out.println("Dequeue Nth in backward direction position 2 is :"+  l2.dequeueNth(false,2));
	//System.out.println(l1.toString());
	//l1.dequeueFront();
	System.out.println(l2.toString());
	//l1.dequeueRear();
	System.out.println(" Size is: " +  l2.size());
	
	
	
	
	
	


	
		
		
	}
}
