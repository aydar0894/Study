import java.util.Scanner;

/**
 * Created by ASUS on 06.09.2016.
 */
public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int count  = sc.nextInt();
        AHash hashTable;
       // hashTable = new Hash__SeparateChaining(count);

        hashTable = new Hash__OpenAddressing(count);
        System.out.println("Enter elements");
        long time = Complexity.now();
        for (int i = 0;i<count;i++)
        {
            hashTable.add(sc.nextInt());
        }
        time = Complexity.now() - time;
        System.out.println(time);
        int a = 0;
    }
}
