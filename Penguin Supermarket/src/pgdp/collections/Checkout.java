package pgdp.collections;

public class Checkout
{
    private final Queue<PenguinCustomer> queue;
    private final Queue<FishyProduct> bandBeforeCashier;
    private final Queue<FishyProduct> bandAfterCashier;

    public Checkout()
    {
        this.queue = new LinkedQueue<PenguinCustomer>();
        this.bandBeforeCashier = new LinkedQueue<FishyProduct>();
        this.bandAfterCashier = new LinkedQueue<FishyProduct>();
    }

    public Queue<PenguinCustomer> getQueue()
    {
        return this.queue;
    }

    public Queue<FishyProduct> getBandBeforeCashier()
    {
        return this.bandBeforeCashier;
    }

    public Queue<FishyProduct> getBandAfterCashier()
    {
        return this.bandAfterCashier;
    }

    public int queueLength()
    {
        return this.queue.size();
    }

    public void serveNextCustomer()
    {
        PenguinCustomer cust = this.queue.dequeue();

        int totalPrice = 0;

        if (cust != null || !this.queue.isEmpty())
        {
            new DataStructureLink<>(new StackConnector<>(cust.getProducts()), new QueueConnector<>(this.bandBeforeCashier)).moveAllFromAToB();

            while(!this.bandBeforeCashier.isEmpty())
            {
                FishyProduct prod = this.bandBeforeCashier.dequeue();
                totalPrice += prod.getPrice();
                this.bandAfterCashier.enqueue(prod);
            }

            new DataStructureLink<>(new QueueConnector<>(this.bandAfterCashier), new StackConnector<>(cust.getProducts())).moveAllFromAToB();

            cust.pay(totalPrice);
        }
    }
    
    @Override
    public String toString()
    {
        return "Checkout successful!";
    }

}