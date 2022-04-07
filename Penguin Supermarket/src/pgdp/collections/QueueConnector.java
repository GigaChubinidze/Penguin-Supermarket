package pgdp.collections;

public class QueueConnector <T> implements DataStructureConnector<T>
{
    private final Queue<T> data;
    
    public QueueConnector(Queue<T> data) 
    {
        this.data = data;
    }

    protected Queue<T> getData()
    {
        return this.data;
    }

    @Override
    public boolean hasNextElement()
    {
        return !this.data.isEmpty();
    }

    @Override
    public void addElement(T element)
    {
        this.data.enqueue(element);
    }

    @Override
    public T removeNextElement()
    {
        return this.data.dequeue();
    }
}