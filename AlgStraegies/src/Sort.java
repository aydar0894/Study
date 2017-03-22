
public class Sort {
    public static ItemNode[] sort(ItemNode[] itemNodes)
    {

        int n = itemNodes.length;
        int currIndex;
        for ( int i=0; i<n-1; i++)        {
            currIndex = i;
            for (int j = i + 1; j < n; j++)
                if ((double)itemNodes[j].cost/(double)itemNodes[j].weight>((double)itemNodes[currIndex].cost/(double)itemNodes[currIndex].weight))
                    currIndex = j;
            if (currIndex != i) {
                ItemNode tmp = itemNodes[i];
                itemNodes[i] = itemNodes[currIndex];
                itemNodes[currIndex] = tmp;
            }
        }
        return itemNodes;


    }

}
