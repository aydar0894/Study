import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by InvarianT on 18.07.2016.
 */
public class MainClass {
    public static void main(String[] args) throws IOException {

        long time = 0;
        long memory = 0;
        int count = 0;
        int iterator = 0;
        int[] arr = new int[1];
        Sort sort = new Sort();
        int choise = 0;
        File out = new File("out.txt");

        File in = new File("in.txt");
        Scanner sc = new Scanner(in);
        FileWriter fw = new FileWriter(out, true);
        while(iterator == 0)
        {
            System.out.println("1.Ввести элементы");
            System.out.println("2.Отсортировать Методом Обмена");
            System.out.println("3.Отсортировать Методом Выбора");
            System.out.println("4.Отсортировать Методом Быстрой сортировки");
            System.out.println("5.Выход");
            Scanner menuScanner = new Scanner(System.in);
            choise = menuScanner.nextInt();



            switch (choise)
            {
                case 1:
                    System.out.println("1.Введите количество элементов");
                    count = menuScanner.nextInt();

                    arr = new int[count];
                    System.out.println("Введите элементы");
                    for (int i = 0;i<count;i++)
                    {
                       // arr[i] = sc.nextInt();
                        arr[i] = 1+i;

                    }

                    break;
                case 2:
                    sort = new BubbleSort();
                    time = Complexity.now();
                    arr = sort.sort(arr);
                    time = Complexity.now() - time;
                    fw.append("BubbleSort, " + count + " items : " + time + "\n");
                    for (int i = 0;i<count;i++)
                    {
                        System.out.println(arr[i]);

                    }
                    break;

                case 3:
                    sort = new SelectionSort();
                    time = Complexity.now();
                    arr = sort.sort(arr);
                    time = Complexity.now() - time;
                    fw.append("Selection, " + count + " items : " + time + "\n");
                    for (int i = 0;i<count;i++)
                    {
                        System.out.println(arr[i]);

                    }
                    break;
                case 4:
                    sort = new Qsort();
                    time = Complexity.now();
                    arr = sort.qSort(arr,0,arr.length - 1);
                    time = Complexity.now() - time;
                    fw.append("Quick sort, " + count + " items : " + time + "\n");
                    for (int i = 0;i<count;i++)
                    {
                        System.out.println(arr[i]);

                    }
                    break;

                case 5:
                    fw.close();
                    iterator = 1;
                    break;
            }



        }
        fw.close();
    }

}
