package pgdp.collections;

public class LinkedStack<T> implements Stack<T>
{
    private List<T> data;

    public LinkedStack()
    {
        this.data = null;
    }

    protected List<T> getData()
    {
        return this.data;
    }

    @Override
    public void push(T element)
    {
        this.data = new List<T>(element, this.data);
    }

    @Override
    public T pop()
    {
        if (this.data == null) return null;
        T result = this.data.getInfo();
        this.data = this.data.getNext();
        return result;
    }

    @Override
    public int size()
    {
        return isEmpty() ? 0: data.length();
    }

    @Override
    public boolean isEmpty()
    {
        return this.data == null;
    }
}