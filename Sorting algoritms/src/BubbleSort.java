/**
 * Created by InvarianT on 18.07.2016.
 */
public class BubbleSort extends Sort {
    public int[] sort(int[] arr)
    {
        int n = arr.length;
        //int[] result = new int[arr.length];
        for (int i=0; i<n; i++)
            for (int j=n-1; j>i; j--)
                if(arr[j]<(arr[j-1]))
                {
                    int tmp=arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1]=tmp;

                }
        return arr;

    }
}
