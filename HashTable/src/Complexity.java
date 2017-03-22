import java.util.concurrent.TimeUnit;

/**
 * Created by ASUS on 06.09.2016.
 */
public class Complexity {
    public static long now() {
        return System.nanoTime();
    }

    public static long nowMillis() {
        //return System.currentTimeMillis();
        return TimeUnit.NANOSECONDS.toMillis(now());
    }
}
