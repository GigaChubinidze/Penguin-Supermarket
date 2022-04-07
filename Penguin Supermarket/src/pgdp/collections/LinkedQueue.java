package pgdp.collections;

public class LinkedQueue<T> implements Queue<T>
{
    private List<T> first;
    private List<T> last;
    private int len;

    public LinkedQueue()
    {
        this.first = null;
        this.last = null;
        this.len = 0;
    }

    protected List<T> getFirst()
    {
        return this.first;
    }

    protected List<T> getLast()
    {
        return this.last;
    }

    @Override
    public int size()
    {
        return this.len;
    }

    @Override
    public boolean isEmpty()
    {
        return this.first == null;
    }

    @Override
    public void enqueue(T element)
    {
        List<T> temp = new List<>(element);
        if (isEmpty()) first = last = temp;
        else 
        {
            last.setNext(temp);
            last = temp;
        }
        len++;
    }

    @Override
    public T dequeue()
    {
        if (isEmpty()) return null;
        T data = first.getInfo();
        first = first.getNext();
        len--;
        return data;
    }  
}