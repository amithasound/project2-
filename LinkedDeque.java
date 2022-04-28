public class LinkedDeque<T> implements DequeInterface<T> {

	private DLLNode<T> front; // reference to the front of this deque
	private DLLNode<T> rear;  // reference to the rear of this deque
	private int count; // number of elements in this deque

	public LinkedDeque() {
		front = null;
		rear = null;
		count = 0;
	}

	
	
	/* Complete the definition of this LinkedDeque class by 
	 * implementing all methods required by the interface DequeInterface. 
	 * Eclipse can add stubs for all the required methods. 
	 */ 

	
	/* The following private method must be recursive. It traverses
	 * the deque front to rear and builds and returns the string
	 * consisting of deque elements. Use space or comma as a separator.
	 */
	private String makeString(DLLNode<T> list) {
		
		if(list==null)
			return "";
		else 
			return list.getElem().toString() + " " + makeString(list.getNext()) ;
	/*
		if(list != null) {
			return list.getElem() + " " + makeString(list.getNext())  ;
			
			
		}else {
			return " ";
		}
		*/
		
	
	}
	
	
	public String reverseList() {
		
		DLLNode<T> curr  = rear;
		String temp = "";
		
		while(curr != null) {
			temp += curr.getElem() + " ";
			curr = curr.getPrev();
		}
		
		return temp;
	}

	@Override
	public String toString() {
		// Do not modify this method.
		return makeString(front);
	}



	@Override
	public void enqueueFront(T element) {
		DLLNode<T> node = new DLLNode<T>(element);
		// TODO Auto-generated method stub
		
		
		
			if (front != null) { //if front is not null doubly link front and enque'd element
				front.setPrev(node); //links backwards
				node.setNext(front);
			}
			
			if(front == null) { //if front is null, then set rear and front to node 
				rear = node;
				//set node to rear if there is no elements front and rear will both point to node
			}
			front = node;
			count++;
		}
		



	@Override
	public void enqueueRear(T element) {
		// TODO Auto-generated method stub
		DLLNode<T> node = new DLLNode<T>(element);
		
		
		if(isEmpty()) {
			front = rear = node; // if its empty front and rear both need to point to node
			
			
		}else {
			rear.setNext(node); //link forwards
			node.setPrev(rear); //link backward
			rear = node;
		}
		 //move rear reference
		count++;
		
	}



	@Override
	public T dequeueFront() throws QueueUnderflowException {
		
		
		
		if(isEmpty() || front == null){
			throw new QueueUnderflowException();
		}
		DLLNode<T> secondElem = front.getNext(); 
		 
		if(secondElem != null) {
			secondElem.setPrev(null); //set the 
		}
		if(secondElem == null) {
			rear = null;
			
		}
		T result = front.getElem();
		front = secondElem;
		count--;
		
		return result;
		
	}



	@Override
	public T dequeueRear() throws QueueUnderflowException {
		if(isEmpty() || rear == null) {
			throw new QueueUnderflowException();
		}
		
	//T result = rear.getElem();

		DLLNode<T> secondToLast = rear.getPrev(); //
		
		if(secondToLast == null) {
			front = null;
		}
		if(secondToLast != null) {
			secondToLast.setNext(null);
		}  
		
		
		T result = rear.getElem();
		rear = secondToLast; 
		count--;
		return result;
	}



	@Override //true means front of set
	public T dequeueNth(boolean flag, int n) throws QueueUnderflowException, OutOfRangeException {
		// TODO Auto-generated method stub
		T deletedElem = null; 
		
		
		if(size() == 0) {
			throw new QueueUnderflowException();
		}
		else if(n > size()) {
			throw new OutOfRangeException();
		}else if((n ==1 && flag == true)||(n == size() && flag == false)) {  // if n 
			deletedElem = dequeueFront();
		}else if((n == size() && flag == true) || (n==1 && flag == false)) {
			deletedElem = dequeueRear();
		}else if(flag) {
			
			DLLNode<T> afterElem = front;
			for(int k = 1; k < n -1 ; k++) {
				afterElem = afterElem.getNext(); //gets to one before deleted element
			}	
			
			DLLNode<T> del = afterElem.getNext(); //deleted element
			DLLNode<T> beforeElem = del.getPrev(); //one before deleted element
			afterElem = del.getNext(); //moves to after deleted element
			afterElem.setPrev(beforeElem); // sets backwards link from afterdeleted elem to beforedeleted element
			beforeElem.setNext(afterElem);  // sets forward link from afterdeleted elem to beforedeleted element
			deletedElem = del.getElem(); 
			count--;
			
		}else{
			DLLNode<T> beforeElem = rear;
			for(int k = 1; k < n -1; k++) {
				beforeElem = beforeElem.getPrev(); //get to one after del element
				
			}
			DLLNode<T> del = beforeElem.getPrev(); //gets to deleted element
			DLLNode<T> afterElem = del.getNext(); //gets to one after deleted element
			beforeElem = del.getPrev(); // gets to one before the deleted element
			beforeElem.setNext(afterElem); //sets forward link element before deleted to after deleted
			afterElem.setPrev(beforeElem); // sets backward link element before deleted and after deleted
			deletedElem = del.getElem();
			count--;
		
			
			
		}
		return deletedElem;
	}
		



	@Override
	public boolean isEmpty() {
		return count == 0;
		

	}



	@Override
	public int size() {
		return count;
	}
}
