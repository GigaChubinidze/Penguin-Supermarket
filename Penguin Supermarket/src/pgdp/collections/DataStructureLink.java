package pgdp.collections;

public class DataStructureLink<T>
{
    private final DataStructureConnector<T> A;
    private final DataStructureConnector<T> B;

    public DataStructureLink(DataStructureConnector<T> A, DataStructureConnector<T> B)
    {
        this.A = A;
        this.B = B;
    }

    protected DataStructureConnector<T> getA()
    {
        return this.A;
    }

    protected DataStructureConnector<T> getB()
    {
        return this.B;
    }

    public boolean moveNextFromAToB()
    {
        if (this.A.hasNextElement()) 
        {
            this.B.addElement(this.A.removeNextElement());
            return true;
        }
        return false;
    }

    public void moveAllFromAToB()
    {
        while (this.A.hasNextElement()) this.B.addElement(this.A.removeNextElement());
    }
}