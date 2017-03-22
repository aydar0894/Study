public class HashTable {
    WordNode[] table;
    int size = 0;
    int wordsCount = 0;
    int q = 0;

    public HashTable(int count) {
        //if amount of elements = 1, size of our hash-map = 1
        if (count == 1) {
            size = 1;
            table = new WordNode[1];
            wordsCount = count;
            return;
        }
        //Here we call getPrev() to generate prime numbers and then we choose closest to count prime number to use it in double-hashing
        int[] primes = PrimeNumber.getPrev(count);
        for (int i = primes.length - 1; i >= 0; i--) {
            if (primes[i] == 1) {
                q = i;
                break;
            }
        }
        //Here we call getNext() to generate prime numbers and then we use second after 'count' prime number as a size of our hash-table
        primes = PrimeNumber.getNext(count);
        for (int i = count; i < primes.length; i++) {
            if (primes[i] == 1) {
                if (size > 0) {
                    size = i;
                    break;
                } else size = i;

            }
        }


        table = new WordNode[size];
        wordsCount = count;
    }

    public WordNode add(String element) {
        int iterator = Math.abs(element.hashCode()) % size;

        if (table[iterator] == null) {
            table[iterator] = new WordNode(element, 1);
        } else if (table[iterator].word.compareTo((element)) == 0) {
            table[iterator].count++;
        } else {
            boolean IS_FULL = false;
            int i = 0;
            int func = 1;
            while (table[iterator] != null) {
                if (iterator == size - 1 && IS_FULL == false) {
                    IS_FULL = true;
                    iterator = 0;
                    i = -1;
                }
                if (iterator == size - 1 && IS_FULL == true) return null;
                //Using the double-hashing
                iterator = (iterator + (q - element.hashCode() % q)) % size;

            }
            table[iterator + i] = new WordNode(element, 1);
        }
        return table[iterator];
    }


    public int search(int element) {
        int i = 0;
        int iterator = element % size;
        if (table[element % size].equals((Object) element)) return element % size;
        else {
            Boolean ROUND = false;
            while (!table[iterator + i].equals((Object) element)) {
                if (iterator == size - 1 && ROUND == false) {
                    ROUND = true;
                    iterator = 0;
                    i = -1;
                }
                if (iterator == size - 1 && ROUND == true) return -1;
                i++;
            }

        }

        return iterator + i;
    }


}