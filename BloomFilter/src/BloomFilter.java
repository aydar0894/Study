import sun.security.util.BitArray;

import java.util.BitSet;
import java.util.Random;

/**
 * Created by ASUS on 01.09.2016.
 */
public class BloomFilter {
    public int[] bitArray;
    int size;
    int count;
    int[] functions;
    MyBitSet bs;
    public BloomFilter(int[] array,int arrSize, double errProb)
    {

        size = (int)(-(arrSize * Math.log(errProb)) / (Math.log(2) * Math.log(2)));
        count = (int)((size / arrSize) * Math.log(2));
        functions = new int[count];
        for (int i = 0; i < count; i++) functions[i] = hashFunction(size);
        bs = new MyBitSet(size);



    }
    public void add(int[] array,int arrSize)
    {
        for(int i = 0;i<arrSize;i++)
        {
            for (int j = 0;j<functions.length;j++)
                bs.set((array[i]*functions[j]%size));
        }
    }

    public boolean tryInt(int value)
    {
        int count = 0;
        for (int j = 0;j<functions.length;j++)
        {
            if(bs.get((value*functions[j]%size))) count++;
            else return false;
        }
           return true;
    }

    public static int hashFunction(int size)
    {
        int func;
        Random random = new Random();

        int result = 0;
        func = (((random.nextInt((size)*32) + 32)))%size;
        result = func;
        return result;

    }


}
