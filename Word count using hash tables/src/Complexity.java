import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * Created by ASUS on 01.09.2016.
 */
public class Complexity {
    public static long now() {
        return System.nanoTime();
    }

    public static long nowMillis() {
        //return System.currentTimeMillis();
        return TimeUnit.NANOSECONDS.toMillis(now());
    }

    public static long mem() {
        MemoryUsage heap
                = ManagementFactory
                .getMemoryMXBean()
                .getHeapMemoryUsage();
        return heap.getUsed();
    }

    public static long mem2() {
        Runtime rt = Runtime.getRuntime();
        return rt.totalMemory() - rt.freeMemory();
    }

    public static int[] generate(int amount,boolean test,int testAmount)
    {
        int[] result;
        Random r = new Random();
        if(test == false)
        {
            result = new int[amount];
            for (int i=0;i<amount;i++)
            {
                result[i] = r.nextInt(100);
            }
        }
      else
        {
            result = new int[testAmount];
            for (int i=0;i<testAmount;i++)
            {
                result[i] = r.nextInt(200);
            }
        }
        return result;
    }
}
