package pgdp.collections;

public class FishyProduct
{
    private final String name;
    private final int price;

    public FishyProduct(String name, int price)
    {
        if (name == null) ExceptionUtil.illegalArgument("Name is null!");
        if (price <= 0) ExceptionUtil.illegalArgument("Money is negative!");
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return this.name;
    }

    public int getPrice()
    {
        return this.price;
    }

    @Override
    public String toString()
    {
        return "FishyProduct \"" + this.name + "\" (price: " + this.price + ")";
    }
}
