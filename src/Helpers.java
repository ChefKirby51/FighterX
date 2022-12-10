import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Iterator;

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

    public static <T> ArrayList<T> arrayListDeepClone(ArrayList<T> arrayList)
    {
        ArrayList<T> clone = new ArrayList<>();

        Iterator<T> iterator = arrayList.iterator();

        while(iterator.hasNext()) {
            clone.add((T) iterator.next());
        }

        return clone;
    }
}
