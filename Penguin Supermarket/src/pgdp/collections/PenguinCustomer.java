package pgdp.collections;


public class PenguinCustomer
 {
    private final String name;
    private int money;
    private final Stack<FishyProduct> products;

    public PenguinCustomer(String name, int money)
    {
        if (name == null) ExceptionUtil.illegalArgument("Name is null!");
        if (money < 0) ExceptionUtil.illegalArgument("money is less than 0!");
        this.name = name;
        this.money = money;
        this.products = new LinkedStack<FishyProduct>(); 
    }

    public String getName() 
    {
        return this.name;
    }

    public int getMoney() 
    {
        return this.money;
    }

    public Stack<FishyProduct> getProducts()
    {
        return this.products;
    }

    public void addProductToBasket(FishyProduct item)
    {
        this.products.push(item);
    }

    public void placeAllProductsOnBand(Queue<FishyProduct> belt)
    {
        new DataStructureLink<>(new StackConnector<>(this.products), new QueueConnector<>(belt)).moveAllFromAToB();
    }

    public void takeAllProductsFromBand(Queue<FishyProduct> belt)
    {
        new DataStructureLink<>(new QueueConnector<>(belt), new StackConnector<>(this.products)).moveAllFromAToB();
    }

    public void pay(int price)
    {
        if (price < 0) ExceptionUtil.illegalArgument("Illegal price!");
        if (price > this.money) ExceptionUtil.illegalArgument("Not enough money");
        this.money -= price;
    }

    @Override
    public String toString() 
    {
        return "PenguinCustomer \"" + this.name + "\" (money: " + this.money + ")";
    }

    public void goToCheckout(PenguinSupermarket supermarket)
    {
        supermarket.getCheckoutWithSmallestQueue().getQueue().enqueue(this);
    }
}

