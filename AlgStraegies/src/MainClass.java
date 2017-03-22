import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {
    public static void main(String[] args) throws IOException {

        ArrayList<ItemNode> items = new ArrayList<ItemNode>();
        File in = new File("input.txt");
        File out = new File("output.txt");
        Scanner sc = new Scanner(in);
        FileWriter outFw = new FileWriter(out);
        String weights = sc.nextLine();
        String costs = sc.nextLine();
        String[] weightsArr = weights.split("\\s+");
        String[] costsArr = costs.split("\\s+");
        int weightLimit = sc.nextInt();
        //This condition is to avoid case when number of weights isn't equal to number of costs
        if(weightsArr.length!=costsArr.length)
        {
            outFw.write(String.valueOf(0));
            outFw.close();
            return;

        }
        //Here we fill our arrayList of items
        for (int i = 0;i<weightsArr.length;i++)
        {
            items.add(new ItemNode(Integer.parseInt(weightsArr[i]), Integer.parseInt(costsArr[i])));
        }

        ItemNode[] itemNodesms = {};
        itemNodesms = items.toArray(itemNodesms);//here we convert our array list of nodes to array of nodes
        int result = Knap.knap(itemNodesms,weightLimit);
        outFw.write(String.valueOf(result));
        outFw.close();

        return;

    }



}
