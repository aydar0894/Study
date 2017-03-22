/**
 * Created by ASUS on 06.09.2016.
 */
public class Hash__OpenAddressing<T extends Comparable>  implements AHash {
    Object[] hashTable;
    int size = 0;
    static final Object CONST = -90896857;

        public Hash__OpenAddressing(int count) {
        hashTable = new Object[count];
        size = count;
    }

    public void add(int element) {

        if (hashTable[element % size] == null || hashTable[element % size] == CONST) hashTable[element % size] = element;
        else {
            boolean IS_FULL = false;
            int i = 0;
            int iterator = element % size;
            while (hashTable[iterator + i] != null) {
                if (iterator == size - 1 && IS_FULL == false)
                {
                    IS_FULL = true;
                    iterator = 0;
                    i = -1;
                }
                if(iterator == size - 1 && IS_FULL == true) return;
                for (int j = 0;j<17;j++)
                {
                    i++;
                    if (i + iterator >=  size )
                    {
                        iterator = 0;
                        i = 0;
                    }
                }
            }
            hashTable[iterator+ i] = element;
        }

    }


    public void delete(int element) {
        int index = 0;
        if((index = search(element))!= -1) hashTable[index] = CONST ;

    }



    public int search(int element) {
        int i  = 0;
        int iterator = element % size;
        if (hashTable[element % size].equals((Object)element)) return element%size;
        else
        {
            Boolean ROUND = false;
            while (!hashTable[iterator + i].equals((Object)element))
            {
                if (iterator == size - 1 && ROUND == false)
                {
                    ROUND = true;
                    iterator = 0;
                    i = -1;
                }
                if(iterator == size - 1 && ROUND == true) return -1;
                i++;
            }

        }

        return iterator + i;
    }

}
