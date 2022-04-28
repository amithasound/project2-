//----------------------------------------------------------------------------
//
// Implements nodes holding elem of class T for a doubly linked list.
// 
//----------------------------------------------------------------------------


public class DLLNode<T> {
  private T elem;
  private DLLNode<T> next, prev;
  
  public DLLNode(T elem) {
    this.elem = elem; next = null; prev = null;
  }
 
  public void setElem(T elem){this.elem = elem;}
  public T getElem(){return elem;}
  
  public void setNext(DLLNode<T> next){this.next = next;}
  public void setPrev(DLLNode<T> prev){this.prev = prev;}
  
  public DLLNode<T> getNext(){return next;}
  public DLLNode<T> getPrev(){return prev;}
}
 
 