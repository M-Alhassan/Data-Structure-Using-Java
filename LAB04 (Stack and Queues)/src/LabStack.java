import java.util.ArrayList;

public class LabStack<T> {
    ArrayList<T> pool; 
    
    public LabStack() {
      pool = new ArrayList<T>();
    }
    
       
    public void clear() {
        pool.clear();
    }
    
    public boolean isEmpty() {
        return pool.isEmpty();
    }
    
    public T topEl() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return pool.get(pool.size()-1);
    }
    
    public T pop() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return pool.remove(pool.size()-1);
    }
    
    public void push(T el) {
        pool.add(el);
    }
    
    public String toString() {
        return pool.toString();
    }
}
