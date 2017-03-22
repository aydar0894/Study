public class Worker extends Thread {
    HashTable[] hashTables;
    int lBound = 0, rBound = 0;
    WordNode temp = new WordNode();
    HashTable resultTable;
    WordNode max = new WordNode("", 0);
    String exclude = "a the in at to on not for 's 'd 're is are am has I we you"; //Words those we should not consider

    public void setParams(HashTable[] hashTables, int lBound, int rBound, HashTable resultTable) {
        this.hashTables = hashTables;
        this.lBound = lBound;
        this.rBound = rBound;
        this.resultTable = resultTable;
    }

    public WordNode returnMax() {
        return this.max;
    }

    public void run() {
        synchronized (resultTable)
        {

        for (int i = lBound; i < rBound; i++) {//going through each hash table given to current thread
            for (int j = 0; j < hashTables[i].size; j++) {//going through each element in current hash table
                if (hashTables[i].table[j] != null && !exclude.contains(hashTables[i].table[j].word)) {
                    for (int k = 0; k < hashTables[i].table[j].count; k++) {//here we add each element in amount of 'k' to result hash table
                        temp = resultTable.add(hashTables[i].table[j].word);
                        if (temp.count > max.count) max = temp;
                    }

                }
            }
        }

    }
    }
}
