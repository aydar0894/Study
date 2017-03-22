import java.util.ArrayList;

/**
 * Created by ASUS on 22.09.2016.
 */
public class KnapSack {
    public static int knapsack(ItemNode[] items, int weightLimit)
    {
        ArrayList<ItemNode> knap = new ArrayList<>();
        int knapIterator = -1;
        int weight=0;
        int totalCost = 0;

        items = Sort.sort(items);

        for(int i = 0;i<items.length;i++)
        {
            if(items[i].weight <= weightLimit)
            {
                if(knapIterator == -1) {
                    knap.add(items[i]);
                    knapIterator++;
                    weight+=items[i].weight;
                    totalCost+=items[i].cost;
                }
                else {
                    if(weight+items[i].weight<=weightLimit+knap.get(knapIterator).weight)
                    {
                        if((double)knap.get(knapIterator).cost/(double)knap.get(knapIterator).weight <= (double)items[i].cost/(double)items[i].weight)
                        {
                            ItemNode temp = knap.get(knapIterator);
                            knap.remove(knapIterator);
                            knap.add(items[i]);
                            knap.add(temp);
                            //weight -= knap.get(knapIterator).weight;
                            weight+=items[i].weight;
                           // totalCoast-=knap.get(knapIterator).coast;
                            totalCost+=items[i].cost;
                            knapIterator++;
                        }
                        else
                        if(weight+items[i].weight<=weightLimit)
                        {
                            knap.add(items[i]);
                            weight+=items[i].weight;
                            totalCost+=items[i].cost;
                            knapIterator++;
                        }

                    }


                }

            }
        }
        return totalCost;
    }
}
