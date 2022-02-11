import java.util.LinkedList;

public class LabQueue<T> {
    LinkedList<T> pool;
    
    public LabQueue() {
      pool = new LinkedList<T>();
    }
    
    public void clear() {
        pool.clear();
    }
    
    public boolean isEmpty() {
        return pool.isEmpty();
    }
    
    public T firstEl() {
        return pool.getFirst();
    }
    
    public T dequeue() {
        return pool.removeFirst();
    }
    
    public void enqueue(T el) {
        pool.add(el);
    }
    
    public String toString() {
        return pool.toString();
    }
}
