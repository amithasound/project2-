/*----------------------------------------------------------------------------
 * DequeInterface.java           by Dale/Joyce/Weems                 Chapter 4
 * 
 * Interface for a class that implements a deque of T.
 * A deque is a linear structure allowing insertion/removal at both ends.
 * 
 * Modified for the project by V. Gehlot
 * ----------------------------------------------------------------------------*/

import java.util.ArrayList;

public interface DequeInterface<T> {
	/* Adds element to the front of this deque. */	
	void enqueueFront(T element);

	/* Adds element to the rear of this deque. */
	void enqueueRear(T element);

	/* Throws QueueUnderflowException if this deque is empty;
	 * otherwise, removes the front element from this deque and returns it. */
	T dequeueFront() throws QueueUnderflowException;

	/* Throws QueueUnderflowException if this deque is empty;
	 * otherwise, removes the rear element from this deque and returns it. */
	T dequeueRear() throws QueueUnderflowException;
	
	/* If the flag is true, then counting from 1, it dequeues the nth element from the front of this deque and
	 * returns it. If the flag is false, then the nth element is dequeued from the rear. That is, counting
	 * from 1 but starting at the rear. Throws QueueUnderflowException if this deque is empty. 
	 * Throws OutOfRangeException if the parameter n is not within the range, that is,
     * zero or negative or exceeds the size */
	T dequeueNth(boolean flag, int n) throws QueueUnderflowException, OutOfRangeException;

	/* Returns true if this queue is empty; otherwise, returns false. */
	boolean isEmpty();

	/* Returns the number of elements in this queue. */ 
	int size();

	/* Returns all elements from left (front) to right (right) of deque as a string. 
	 * Must use recursion. Towards this end, define a private recursive method
	 * that accepts DLLNode as a parameter and traverses it recursively building
	 * up the desired string. Use space or comma as a separator. */
	String toString(); // must provide an implementation to override toString() from Object.
}




