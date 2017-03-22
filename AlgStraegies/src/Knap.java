import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Knap {

    public static int knap(ItemNode[] items, int maxWeight) throws IOException {
        int result = 0;
        int itemsCount = items.length-1;
        int weight = 1;
        int[][] table;
        table = new int[itemsCount+2][maxWeight+1];
        for (int k = 0;k<itemsCount;k++)
        {
            table[k][0] = 0;
        }

        int i = 0;
            for (i = 1; i <= itemsCount+1; i++) {
                for (int j = 0; j <= maxWeight; j++) {
                    if (items[i-1].weight > j || table[i - 1][j]>table[i - 1][j - items[i-1].weight] + items[i-1].cost) {
                        table[i][j] = table[i - 1][j];
                        items[i-1].take = false;
                    }
                    else {
                            table[i][j] = table[i - 1][j - items[i-1].weight] + items[i-1].cost;
                    }
                }
            }
        //Here we figure out which items we have put into our knapSack
            result = table[itemsCount+1][maxWeight];
            int i1 = itemsCount+1;
            int j = maxWeight;
            int curCost = result;
                while(table[i1][j]!=0 && curCost>0) {

                    if(table[i1][j] != table[i1-1][j])
                    {
                        curCost-=items[i1-1].cost;
                        items[i1-1].take = true;
                        j=j-items[i1-1].weight;
                    }

                    i1--;

                }

        //Here we create a file where we store the contents of our knapSack
        //
        /*
        File f = new File("knapSack.txt");
        FileWriter fw = new FileWriter(f,true);
        int sum = 0;
        fw.write("\nWeight : Cost");
        for(int ii = 0;ii<itemsCount+1;ii++)
        {
            if(items[ii].take)
            {
                fw.write("\n\t" + String.valueOf(items[ii].weight) + " : " + String.valueOf(items[ii].cost));
                sum += items[ii].weight;
            }

        }

        fw.write("\nResult weight: "+ sum);
        fw.close();
*/

        return result;
    }

}

