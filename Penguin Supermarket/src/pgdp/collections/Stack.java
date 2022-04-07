package pgdp.collections;

public interface Stack<T> extends DataStructure
{
    public void push(T element);
    public T pop();
}