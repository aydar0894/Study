import java.util.LinkedList;

public class Hash__SeparateChaining<T extends Comparable> implements AHash{

    LinkedList[] hashTable;
    int size = 0;

    public Hash__SeparateChaining(int count)
    {
        hashTable = new LinkedList[count];
        for (int i = 0;i<count;i++) hashTable[i] = new LinkedList();
        size = count;
    }


    public void add(int element) {

            hashTable[element%size].add(element);

    }


    public void delete(int element) {
        Object el = new Object();
        if((el = (Object)search(element)).equals((Object)0)) hashTable[element%size].remove(el);

    }


    public int search(int element) {
        for(int i = 0;i<hashTable[element%size].size();i++)
        {
            if (hashTable[element%size].iterator().equals(element))
            {
                return element;
            }

             else hashTable[element%size].iterator().next();
        }
        return 0;
    }
}

