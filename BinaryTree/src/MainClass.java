import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ASUS on 27.09.2016.
 */
public class MainClass {


    public static void main(String[] args) throws IOException {

        AVLTree<String> tree = new AVLTree<>();
        TreeNode root = tree.root;

        FileWriter fw = new FileWriter(new File("output.txt"));
        Scanner sc = new Scanner(new File("input.txt"));
        String textString = "";
        while (sc.hasNextLine())
        {
            textString += sc.nextLine();
        }

        char[] textArray = textString.replaceAll(" ","").toCharArray();

        for (int i = 0; i<textArray.length;i++)
        {
            tree.add(String.valueOf(textArray[i]).toLowerCase());
        }

        String masToDel = ": ; < = > ? @ [ ] ^ _ ` . - *";
        String[] del = masToDel.split("\\s+");
       for (int i = 0;i<del.length;i++)
        {
            tree.delete(del[i]);
        }

        String s = tree.traverse();
        fw.write(s);
        fw.close();
    }
}
