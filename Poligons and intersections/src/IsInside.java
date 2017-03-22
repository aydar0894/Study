import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by ASUS on 04.09.2016.
 */
public class IsInside {
    public static boolean IsInside(MyArrayList<Point2D> polygon, Point2D point, Point2D f) {
        int countsOfInt = 0;
        for (int i = 0; i < polygon.size(); i++) {
            if (i != polygon.size() - 1) {
                if (intersects(polygon.get(i), polygon.get(i + 1), point, f))
                    countsOfInt++;
            } else {
                if (intersects(polygon.get(i), polygon.get(0), point, f))
                    countsOfInt++;
            }
        }
        if (countsOfInt % 2 > 0) return true;
        else return false;
    }


    public static boolean intersects(Point2D a, Point2D b, Point2D c, Point2D d) {

        double[][] A = new double[2][2];
        A[0][0] = b.getX() - a.getX();
        A[1][0] = b.getY() - a.getY();
        A[0][1] = c.getX() - d.getX();
        A[1][1] = c.getY() - d.getY();

        double det0 = A[0][0] * A[1][1] - A[1][0] * A[0][1];

        double detU = (c.getX() - a.getX()) * A[1][1] - (c.getY() - a.getY()) * A[0][1];
        double detV = A[0][0] * (c.getY() - a.getY()) - A[1][0] * (c.getX() - a.getX());

        double u = detU / det0;
        double v = detV / det0;
        return u > 0 && u < 1 && v > 0 && v < 1;
    }
}
