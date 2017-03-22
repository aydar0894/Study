
import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    private static final int capacity = 10;
    private Object array[];

    public MyArrayList() {
        array = new Object[capacity];
    }

    public int size()
    {
        return size;
    }

    public void add(E e) {
        if (size == array.length) {
            increaseCapasity();
        }
        array[size++] = e;
    }

    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    private void increaseCapasity() {
        int newSize = array.length * 2;
        array = Arrays.copyOf(array, newSize);
    }

    public E get(int i) {
        if (i <= size || i >= 0) {
            return (E) array[i];
        }
        return null;
    }
}
