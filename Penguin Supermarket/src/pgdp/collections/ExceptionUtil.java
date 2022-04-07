package pgdp.collections;

public class ExceptionUtil 
{

    public static void unsupportedOperation(String message) 
    {
        throw new UnsupportedOperationException(message);
    }

    public static void illegalArgument(String message) 
    {
        throw new IllegalArgumentException(message);
    }
}
