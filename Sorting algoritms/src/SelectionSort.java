/**
 * Created by InvarianT on 18.07.2016.
 */
public class SelectionSort extends Sort {
    public int[] sort(int[] arr)
    {
        int n = arr.length;
        int currIndex;
        for ( int i=0; i<n-1; i++)        {
         currIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j]<(arr[currIndex]))
                    currIndex = j;
            if (currIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[currIndex];
                arr[currIndex] = tmp;
            }
        }
        return arr;
    }
}
