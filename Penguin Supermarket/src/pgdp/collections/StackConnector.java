package pgdp.collections;

public class StackConnector <T> implements DataStructureConnector<T>
{
    private final Stack<T> data;

    public StackConnector(Stack<T> data)
    {
        this.data = data;
    }

    protected Stack<T> getData()
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
        this.data.push(element);
    }

    @Override
    public T removeNextElement()
    {
        return this.data.pop();
    }
}