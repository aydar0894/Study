import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ASUS on 04.09.2016.
 */
public class MonteCarlo {

    public static double monteCarlo(MyArrayList<Point2D> polygon, Point2D f, double xMax, double yMax, double xMin, double yMin)
    {
        MyArrayList<Point2D> points = new MyArrayList<Point2D>();
        double rnd,rnd2;
        double n = 0;
        double k = 0;
        double prevK = 0;
        Random random = new Random();
        for(int i = 0;i<100000;i++)
        {
            points.add(new Point2D.Double(random.nextDouble()*(xMax-xMin)+xMin,random.nextDouble()*(yMax-yMin)+yMin));
        }
        Point2D[] pointt = {};
        double square = (xMax-xMin)*(yMax-yMin);
        pointt = points.toArray(points.toArray(pointt));
        n = 100000.0;
        for (int j = 1;j<100000;j++)
        {
            if(IsInside.IsInside(polygon,pointt[j-1],f)) k++;
            if((j>100) && ((Math.abs((k/j)*square - (prevK/(j-1))*square)) <= Math.pow(10,-4)))
            {
                n = j;
                break;
            }
            prevK = k;
        }
        double result = square*(k/n);
        BigDecimal x = new BigDecimal(String.valueOf(result));
        x = x.setScale(2, BigDecimal.ROUND_HALF_UP);
        result = x.doubleValue();
        return result;
    }

    public static double rnd(final double max)
    {
        return Math.random() * max;
    }

}

