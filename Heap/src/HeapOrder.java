/**
 * Created by InvarianT on 19.07.2016.
 */
public class HeapOrder<T extends Comparable, P2 extends Comparable, P extends Comparable>  {
     public Node<T,P2,P>[] minHeap(Node<T,P2,P>[] arr, int k, int n) {
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int min;
            if (left < n && arr[left].compareTo(arr[k]) > 0)
                min = left;
            else
                min = k;

            if (right < n && arr[right].compareTo(arr[min]) > 0)
                min = right;
            if (min == k) return arr;
            Node tmp = arr[k];
            arr[k] = arr[min];
            arr[min] = tmp;
            k = min;
        }

    }

    public Node<T,P2,P>[] maxHeap(Node<T,P2,P>[] arr, int k, int n) {
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int max;
            if (left < n && arr[left].compareTo(arr[k]) > 0)
                max = left;
            else
                max = k;

            if (right < n && arr[right].compareTo(arr[max]) > 0)
                max = right;
            if (max == k) return arr;
            Node tmp = arr[k];
            arr[k] = arr[max];
            arr[max] = tmp;
            k = max;

        }

    }
     public Node[] pyramidalSort(Node<T,P2,P>[] arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--)
          minHeap(arr, i, n);
        for (int i = n - 1; i >= 1; i--) {
            Node<T,P2,P> tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            minHeap(arr, 0, i);
        }
        return arr;
    }
}
