import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by InvarianT on 13.07.2016.
 */
public class MainClass {
    public static void main(String[] args) throws IOException, ParseException  {
        HeapOrder<String,Double, LocalDateTime> heapOrder = new HeapOrder<>();
        Scanner sc = new Scanner(new File("input.txt"));
        ArrayList<String> nodesStr = new ArrayList();
        ArrayList<Node<String,Double, LocalDateTime>> nodes = new ArrayList<>();
        String time = sc.nextLine();

        FileWriter fw = new FileWriter(new File("output.txt"));

        for(int i = 0;;i++)
        {
            if(!sc.hasNextLine()) break;
            nodesStr.add(sc.nextLine());
        }
        String[] nodesMas = {};
        nodesMas = nodesStr.toArray(nodesMas);

        Node<String,Double, LocalDateTime>[] nodesArray = new Node[nodesMas.length];

        String tempRecord[] = {};
        String name = "";
        Double price = 0.0;
        LocalDateTime dateTime;
        for(int i = 0;i<nodesMas.length;i++)
        {
            tempRecord = nodesMas[i].replace(" at", "").split("\\s+");
            name = tempRecord[0] + " " + tempRecord[1].replace(":","");
            price = Double.parseDouble(tempRecord[2]);
            dateTime = LocalDateTime.parse(tempRecord[3]);
            nodes.add(new Node<>(name,price,dateTime,0));
        }

        nodesArray = nodes.toArray(nodesArray);

        nodesArray = heapOrder.pyramidalSort(nodesArray,nodesArray.length);
        time =  time.replace("Boss: ","");
        String[] timePeriod = time.split(" - ");
        LocalDateTime timeStart = LocalDateTime.parse(timePeriod[0]);
        LocalDateTime timeStop = LocalDateTime.parse(timePeriod[1]);

        int intervals = Math.abs(timeStop.toLocalTime().getHour()*60+timeStop.toLocalTime().getMinute() - timeStart.toLocalTime().getHour()*60+timeStop.toLocalTime().getMinute());

        intervals /= 60;

        HeapOrder<String,Double,LocalDateTime> newOrder = new HeapOrder<>();


        ArrayList<Node<String,Double,LocalDateTime>> tempArray = new ArrayList<>();
        Node<String,Double,LocalDateTime>[] resultArray;
        int j = 0;
        for(int i = 0;i<=intervals;i++)
        {
            tempArray = new ArrayList<>();
            j = 0;
            while (timeStart.plusHours(i).compareTo(nodesArray[j].priority)>=0)
            {
                nodesArray[j].compare = 1;
                tempArray.add(nodesArray[j]);
                j++;
            }
            int n = tempArray.size();
            resultArray = new Node[n];
            resultArray = tempArray.toArray(resultArray);
            for (int k = (n - 1) / 2; k >= 0; k--) resultArray = newOrder.maxHeap(resultArray, k, n);

            fw.append(timeStart.plusHours(i).toString() + ": " + resultArray[0].inf + "\n");


        }
        fw.close();
        int a = 0;
    }
}
