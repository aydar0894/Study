
public class MedianFilter {
    public static int[] filter(int[] signal, int size) {

        int[] newSignal = new int[signal.length];//Result array, it will store the result signal
        for (int curIndex = 0; curIndex < signal.length; curIndex++) {
            int leftShiftIterator = 0;
            int[] tempArray = new int[size];// this array will store signals, its size is equal to the windowSize, we'll sort this array in each step and find the median
            int newIndex = curIndex;
            int windowSize = size;
            while (newIndex - windowSize / 2 < 0) {
                tempArray[leftShiftIterator] = signal[0];
                leftShiftIterator++;
                newIndex++;
            }
            newIndex = curIndex;
            int tempCurIndex = curIndex;
            int rightShiftIterator = 0;
            while (signal.length - 1 - newIndex < windowSize / 2) {
                tempArray[windowSize - 1 - rightShiftIterator] = signal[signal.length - 1];
                rightShiftIterator++;
                newIndex--;
            }
            for (int j = leftShiftIterator; j < windowSize - rightShiftIterator; j++) {
                tempArray[j] = signal[tempCurIndex - windowSize / 2 + leftShiftIterator];
                tempCurIndex++;
            }
            tempArray = Qsort.qSort(tempArray, 0, tempArray.length - 1);//Here we sort our tempArray
            newSignal[curIndex] = tempArray[windowSize / 2];//Here we find current median
        }
        return newSignal;
    }

}
