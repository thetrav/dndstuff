package the.trav.util;

public class Assert
{
    public static void assertTrue(String msg, boolean condition)
    {
        if(!condition)
        {
            throw new RuntimeException(msg);
        }
    }
}
