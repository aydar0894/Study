/**
 * Created by ASUS on 05.09.2016.
 */
public class MyBitSet {
    private long[] words;
    int[] bits;
    public MyBitSet(int size) {

        bits = new int[size/32+1];
    }


    boolean get(int index)
    {
        System.out.println(bits[index/32]);
        return (bits[index / 32] >>> (index % 32) & 1) == 1;
    }

    void set(int index)
    {
       bits[(index / 32)]  = bits[(index / 32)] |= 1 << (index % 32);
    }

}
