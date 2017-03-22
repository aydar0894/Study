import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class MainClass {
    public static void main(String[] args) throws IOException {

        File in = new File("input.txt");
        File out = new File("output.txt");
        Scanner sc = new Scanner(in);
        FileWriter outFw = new FileWriter(out);
        String input = sc.nextLine();
        int windowSize = sc.nextInt();
        String[] signalArr = input.split("\\s+");
        int[] signal = new int[signalArr.length];//Array of ints, that will store our signal

        //Here we fill array of ints
        for (int i = 0; i < signal.length; i++) {
            signal[i] = Integer.parseInt(signalArr[i]);
        }

        int[] result = MedianFilter.filter(signal, windowSize);//We call method filter()

        for (int i = 0; i < result.length; i++) {
            outFw.write(result[i] + " ");
        }
        outFw.close();

    }
}
