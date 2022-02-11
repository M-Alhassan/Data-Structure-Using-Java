//************************  SLLNode.java  *******************************
//           node in a generic singly linked list class 

public class SLLNode<T> {
    public T info;
    public SLLNode<T> next;
    
    public SLLNode() {	// this is called when the next node is null and the value for that node is null
        this(null,null);
    }
    public SLLNode(T el) {	// this is called when the next node is null and the value is available 
        this(el,null);
    }
    public SLLNode(T el, SLLNode<T> ptr) {	// this is called when the next node is available and the value is available
        info = el;
        next = ptr;
    }
}

