package pgdp.collections;

public interface DataStructureConnector <T>
{
    public boolean hasNextElement();
    public void addElement(T element);
    public T removeNextElement();
}

