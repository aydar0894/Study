import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by ASUS on 01.09.2016.
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        long time = 0, tx = 0, memory = 0, mx = 0;
        File inFile = new File("input.txt");
        File outFile = new File("output.txt");
        File complexity = new File("Complexity.txt");
        File complexityTests = new File("ComplexityTests.txt");
        Scanner sc = new Scanner(inFile);
        String symb = sc.nextLine();
        String tests = sc.nextLine();
        sc.close();
        int[] set;
        int[] test;
//--------------Real case
        set = strToIntArr(symb);
        test = strToIntArr(tests);
//--------------Test case
        //set = Complexity.generate(10000,false,0);
        //test = Complexity.generate(0,true,10);

        String result = "";
        FileWriter fw = new FileWriter(outFile);



       // mx = Complexity.mem();
       // tx = Complexity.now();
        if (set.length != 0)
        {

            BloomFilter bloomFilter = new BloomFilter(set,set.length,0.1);
            bloomFilter.add(set,set.length);
            for (int i = 0;i<test.length;i++)
            {
                result += String.valueOf(bloomFilter.tryInt(test[i])) + " ";
            }

        }
        else
        {
            for (int i = 0;i<test.length;i++)
            {
                result += "false ";
            }
        }

       // time += Complexity.now() - tx;
       // memory += Complexity.mem() - mx;

        fw.write(result);
        fw.close();

        String complexityString = "";
//---------Amount Of Nums Devoted
        /*
        fw = new FileWriter(complexity,true);
        fw.append("next:\n");
        complexityString = set.length + " : " + time;
        fw.append(complexityString+"\n");
        complexityString = set.length + " : " + memory;
        fw.append(complexityString + "\n");
        fw.close();
        */
//---------Amount Of Tests Devoted
        /*
        fw = new FileWriter(complexityTests,true);
        fw.append("nextTest:\n");
        complexityString = test.length + " : " + time;
        fw.append(complexityString+"\n");
        complexityString = test.length + " : " + memory;
        fw.append(complexityString + "\n");
        fw.close();
        */
    }

    public static int[] strToIntArr(String string) {
        int[] intSet = new int[string.length()];
        int[] result;
        string += "™";
        int length = 0;
        String s = new String();
        for (int i = 0; i < string.length(); i++) {

            while (string.charAt(i) != ' ' && string.charAt(i) != '™') {
                s += string.charAt(i);
                i++;
            }
            if (s.compareTo(" ") != 0 && s.compareTo("") != 0)
            {
                intSet[length++] = Integer.valueOf(s);
                s = "";
            }
        }
        result = new int[length];
        for (int j = 0; j < length; j++) {
            result[j] = intSet[j];
        }
        return result;
    }
}
