import java.util.Random;
import java.util.List;

public class Helpers
{
    /**
     * Generate a random double between the given min and max range.
     * @param minRange
     * @param maxRange
     * @return
     */
    public static double randRange(double minRange, double maxRange)
    {
        Random rand = new Random();

        return minRange + (maxRange - minRange) * rand.nextDouble();
    }
}
