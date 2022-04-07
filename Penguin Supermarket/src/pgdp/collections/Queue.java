package pgdp.collections;

public interface Queue<T> extends DataStructure
{
    public void enqueue(T element);
    public T dequeue();   
}