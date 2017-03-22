import java.io.*;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws IOException, InterruptedException {
        File input = new File("input.txt");
        File output = new File("output.txt");
        FileReader fileReader = new FileReader(input);
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
        int linesCount = 0;
        Scanner sc = new Scanner(input);
        FileWriter fileWriter = new FileWriter(output);
        //counting number of lines in our text file
        while (lineNumberReader.readLine() != null) {
            linesCount++;
        }

        //Here we initialise an array to store all words from all lines
        String[][] lines = new String[linesCount][];
        //Here we fill our array
        for (int i = 0; i < linesCount; i++) {
            lines[i] = sc.nextLine().toLowerCase().replace(".", "").replace(",", "").replace(":", "").replace(";", "").replace("-", "").replace("'", " '").split("\\s+");
        }

        WordNode max;// This is an object of the class WordNode, that will consist of word and number of occurrences
        Calculation calculation = new Calculation();
        max = calculation.calculate(lines, linesCount);// Here we run a calculate() method, that will return an object of the class WordNode with maximal number of occurrences
        fileWriter.write(max.word + " " + max.count);
        fileWriter.close();

    }
}
