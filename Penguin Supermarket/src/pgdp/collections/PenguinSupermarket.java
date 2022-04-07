package pgdp.collections;

public class PenguinSupermarket
{
    private Checkout[] checkouts;
    
    public PenguinSupermarket(int registers)
    {
        if (registers < 1) ExceptionUtil.illegalArgument("Low register number");
        this.checkouts = new Checkout[registers];
        for (int i = 0; i < this.checkouts.length; i++) checkouts[i] = new Checkout();
    }

    public Checkout[] getCheckouts()
    {
        return this.checkouts;
    }

    public Checkout getCheckoutWithSmallestQueue()
    {
        Checkout minimum = this.checkouts[0];

        for (int i = 0; i < this.checkouts.length; i++)
        {
            if (this.checkouts[i].queueLength() < minimum.queueLength())
                minimum = this.checkouts[i];
        }
        return minimum;
    }

    public void closeCheckout(int index) 
    {
        if (index < 0 || index >= this.checkouts.length)
            ExceptionUtil.illegalArgument("Invalid index!");

        if (this.checkouts.length == 1)
            ExceptionUtil.unsupportedOperation("End reached!");

        LinkedStack<PenguinCustomer> customer = new LinkedStack<PenguinCustomer>();

        QueueConnector<PenguinCustomer> myQueue = new QueueConnector<PenguinCustomer>(this.checkouts[index].getQueue());

        while (myQueue.hasNextElement()) new StackConnector<PenguinCustomer>(customer).addElement(myQueue.removeNextElement());

        Checkout[] temp = new Checkout[this.checkouts.length - 1];
        for (int i = 0; i < temp.length; i++) temp[i] = i < index ? this.checkouts[i]: this.checkouts[i + 1];

        this.checkouts = temp;
        while (!customer.isEmpty()) customer.pop().goToCheckout(this);
    }
    
    public void serveCustomers()
    {
        for (Checkout checkout : this.checkouts)
            checkout.serveNextCustomer();
    }



}