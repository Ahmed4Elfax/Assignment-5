package eg.edu.alexu.csd.datastructure.stack;
/**
 * 
 * @author Ahmed Ashraf
 *
 */

class DNode {
	private DNode next, prev;
	private Object element;
	public DNode(Object  e, DNode p, DNode n) {
		element = e;
		prev = p;
		next = n;
		    }
	/** Returns the element of this node */
	public Object getElement() {return element;}
	/** Returns the previous node of this node */
	public DNode getPrev() {return prev;}
	/** Returns the next node of this node */
	public DNode getNext() {return next;}
	/** Sets the element of this node */
	public void setElement(Object  newElem) {element = newElem;}
	/** Sets the previous node of this node */
	public void setPrev(DNode newPrev) {prev = newPrev;}
	/** Sets the next node of this node */
	public void setNext(DNode newNext) {next = newNext;}
}
public class Stack implements IStack {
    DNode  head = new DNode(null, null, null);
    //DNode  tail = new DNode(null, head, null);
    //head.setNext(tail);
    private DNode top;
    private int size;
    public Stack() {
		top=head;
		size=0;
	}
    /**
	* Removes the element at the top of stack and returns that element.
	* *
	@return top of stack element, or through exception if empty
	*/
	@Override
	public Object pop() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Stack");
		}
		Object temp = top.getElement();
		top=top.getNext();
		size--;
		return temp;
	}
	/**
	* Get the element at the top of stack without removing it from stack.
	* *
	@return top of stack element, or through exception if empty
	*/
	@Override
	public Object peek() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Stack");
		}
		return top.getElement();
	}
	/**
	* Pushes an item onto the top of this stack.
	* *
	@param object
	* to insert
	*/
	@Override
	public void push(Object element) {
		DNode temp=new DNode(element, null, top);
		top=temp;
		size++;
	}
	/**
	* Tests if this stack is empty
	* *
	@return true if stack empty
	*/
	@Override
	public boolean isEmpty() {
		return (size==0);
	}
	/**
	* Returns the number of elements in the stack.
	* *
	@return number of elements in the stack
	*/
	@Override
	public int size() {
		
		return size;
	}

}
