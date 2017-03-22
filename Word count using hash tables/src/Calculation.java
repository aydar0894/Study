import java.io.IOException;

public class Calculation {
    // Declaration of variables
    int i;
    HashTable[] hashTable;
    int maxCount = 0;
    HashTable resultTable;
    WordNode max = new WordNode("", 0);
    WordNode temp = new WordNode();
    int lBound, rBound;
    String exclude = "a the in at to on not for 's 'd 're is are am has I we you"; //Words those we should not consider

    public WordNode calculate(String[][] lines, int linesCount) throws InterruptedException, IOException {

        hashTable = new HashTable[linesCount];
        // Here we create and fill hash tables to each line in amount of linesCount
        for (int i1 = 0; i1 < linesCount; i1++) {
            int count = lines[i1].length;
            maxCount += count;
            hashTable[i1] = new HashTable(count);
            for (int j = 0; j < count; j++) {
                hashTable[i1].add(lines[i1][j]);
            }

            int a = 0;
        }
        resultTable = new HashTable(maxCount);// To this hash table we will merge all existing hash tables
        int workersCount = 2;
        Worker worker[] = new Worker[workersCount];// Instantiating two Thread instances
        //Here we start our loop in threads
        for (int i = 0; i < workersCount; i++) {
            lBound = i * linesCount / workersCount;
            if (workersCount == 1) rBound = linesCount;
            else if (linesCount % workersCount > 0) rBound = lBound + linesCount / workersCount + 1;
            else rBound = lBound + linesCount / workersCount;
            worker[i] = new Worker();
            worker[i].setParams(hashTable, lBound, rBound, resultTable);
            worker[i].run();
        }
        max = worker[workersCount - 1].returnMax();
        return max;

    }


}
