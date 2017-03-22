import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ASUS on 21.11.2016.
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        File file = new File("russia.txt");
        Graph<String> graph = null;
        Scanner scanner = new Scanner(file);
        String[] names = scanner.nextLine().split(" ");
        for (int i = 0; i < names.length; i++) names[i] = names[i].trim();
        graph = new Graph<>(names);

        while (scanner.hasNext()) {
            String from = scanner.next().trim();
            String to = scanner.next().trim();
            String[] edgeInf = scanner.next().trim().split(":");
            double[] edges = Arrays.asList(edgeInf).stream().mapToDouble(Double::parseDouble).toArray();
            graph.addBothEdges(from, to, edges[0], edges[1], edges[2]);
        }
        scanner = new Scanner(new File("input.txt"));
        String[] lines = {};
        ArrayList<String> toOutput = new ArrayList<>();
        ArrayList<Integer> returns = new ArrayList<Integer>();
        int i = 0;
        String temp;
        double amountOfGoods = 0;
        double totalTime = 0;
        double totalPrice = 0;
        ArrayList<String> resultString = new ArrayList<>();
        while (scanner.hasNextLine()) {
            temp = "";
            amountOfGoods = 0;
            totalTime = 0;
            totalPrice = 0;
            toOutput.add(scanner.nextLine());
            lines = toOutput.get(i).split(" ");
            Object mat[][] = graph.adjMatrix;

            int matrix[][] = new int[graph.adjMatrix.length][graph.adjMatrix.length];
            for (int k = 0; k < graph.adjMatrix.length; k++) {
                for (int l = 0; l < graph.adjMatrix.length; l++) {
                    matrix[k][l] = (int) ((Edge) graph.adjMatrix[k][l]).sum;
                }
            }

           ArrayList<BFSNode<String, Edge>> res = graph.BFS(lines[0], lines[1]);
            amountOfGoods = Double.parseDouble(lines[2]);
            totalTime += res.get(res.size() - 1).total.time;
            totalPrice += res.get(res.size() - 2).total.price * amountOfGoods;
            temp += lines[0] + " " + lines[1] + " " + amountOfGoods + " " + totalTime + " " + totalPrice;
            resultString.add(temp);

           //returns.add(graph.maxFlow(graph.posInMatrix.get(lines[0]),graph.posInMatrix.get(lines[1]),matrix ));



            i++;
        }


        FileWriter fw = new FileWriter(new File("output.txt"));
        for (int j = 0; j < toOutput.size(); j++) {
            fw.write(resultString.get(j) + "\n");
        }


        fw.close();


    }

}
