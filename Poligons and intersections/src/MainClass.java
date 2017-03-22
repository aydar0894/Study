import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by ASUS on 30.08.2016.
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        Point2D a, b, c, d, f;
        MyArrayList<Point2D> polygon = new MyArrayList<Point2D>();
        File inFile = new File("input.txt");
        Scanner dc = new Scanner(inFile);
        String string = dc.nextLine();
        String subStr = "";
        boolean xOry = true;
        double x = 0, y = 0;
        int counter = 0;
        double maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE, minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                subStr += string.charAt(i);
            } else {
                if (xOry == true) {
                    x = Double.valueOf(subStr);
                    xOry = false;
                    counter++;

                } else {
                    y = Double.valueOf(subStr);
                    xOry = true;
                    counter++;
                }

                if (counter == 2) {
                    if (x > maxX) maxX = x;
                    if (x < minX) minX = x;
                    if (y > maxY) maxY = y;
                    if (y < minY) minY = y;
                    polygon.add(new Point2D.Double(x, y));
                    counter = 0;
                }
                subStr = "";
            }
        }
        y = Double.valueOf(subStr);
        polygon.add(new Point2D.Double(x, y));
        if (x > maxX) maxX = x;
        if (x < minX) minX = x;
        if (y > maxY) maxY = y;
        if (y < minY) minY = y;

        if (minX < 0) {
            maxX = maxX - minX;
            for (int i = 0; i < polygon.size(); i++)
                polygon.get(i).setLocation(polygon.get(i).getX() - minX, polygon.get(i).getY());
            minX = 0;

        }

        if (minY < 0) {
            maxY = maxY - minY;
            for (int i = 0; i < polygon.size(); i++)
                polygon.get(i).setLocation(polygon.get(i).getX(), polygon.get(i).getY() - minY);
            minY = 0;

        }
        f = new Point2D.Double(maxX * 100, maxY * 100);
        File outFile = new File("output.txt");
        FileWriter fw = new FileWriter(outFile);
        double result = MonteCarlo.monteCarlo(polygon, f, maxX, maxY, minX, minY);
        String.format("%.3f", result);
        NumberFormat formatter = new DecimalFormat("#0.00");
        fw.write(String.valueOf(formatter.format(result).replace(',', '.')));
        fw.close();
    }

}