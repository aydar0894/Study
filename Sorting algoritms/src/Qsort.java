/**
 * Created by InvarianT on 20.07.2016.
 */
public class Qsort extends Sort{
  public  int[] qSort(int[] arr, int a, int b)
    {
        int i=a;
        int j=b;
        int mid=arr[(a+b)/2];
        while(i<=j)
        {
            while(arr[i]<(mid)) i++;
            while(arr[j]>(mid)) j--;
            if(i<=j)
            {
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                i++;
                j--;

            }
        }
        if (a<j)
           arr =  qSort(arr, a, j);
        if (i<b)
            arr =   qSort(arr, i, b);
        return arr;
    }

}
