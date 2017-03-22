
import java.lang.management.*;
import java.util.concurrent.TimeUnit;

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



}
