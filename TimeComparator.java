package prj1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Pouyan
 *
 */
public class TimeComparator {
    /**
     * This class executes your implementations of the Dijkstras shortest path
     * algorithm on some sample graphs and prints the running time
     * 
     * @param args
     */
    public static void main(String[] args) {
        int n;
        System.out.println("Reading the graph ...");

        // * // Here, you can choose between graph_1 to graph_6. For graph_1,
        // graph_2
        // * // and graph_3, we expect to see that the Dijkstra's without heap
        // * // perform better while for graph_4, graph_5, and graph_6 we expect
        // to
        // * // find Dijkstra's with heap to be more efficient
        //Graph graph = readFile("graphs/graph_1.txt");
        // *
        // * // number of repeating the test
        n = 1;

        // * // executing the DijkstrasWithoutHeap method on the graph
/*
 * System.out.println("Executing Dijkstras without heap ...");
 * DijkstrasWithoutHeap[] dWithouts = new DijkstrasWithoutHeap[n];
 * long start = System.currentTimeMillis();
 * for (int i = 0; i < n; i++) {
 * dWithouts[i] = new DijkstrasWithoutHeap(graph.n, graph.edges);
 * dWithouts[i].run(graph.source);
 * }
 * System.out.println("Average execution time of Dijkstra's without heap: "
 * + (System.currentTimeMillis() - start));
 */

        // executing the DijkstrasWithHeap method on the graph
/*
 * System.out.println("Executing Dijkstras with heap ...");
 * DijkstrasWithHeap[] dWiths = new DijkstrasWithHeap[n];
 * long start = System.currentTimeMillis();
 * for (int i = 0; i < n; i++) {
 * dWiths[i] = new DijkstrasWithHeap(graph.n, graph.edges);
 * dWiths[i].run(graph.source);
 * }
 * System.out.println("Average execution time of Dijkstra's with heap: "
 * + (System.currentTimeMillis() - start));
 * n = 5;
 * int[][] edges = { { 1, 2, 50 }, { 2, 3, 10 }, { 3, 4, 20 }, { 3, 5,
 * 50 }, { 4, 5, 10 } };
 * int source = 2;
 * // The distance of each node from the source vertex
 * int[] expectedDistances = { 50, 0, 10, 30, 40 };
 * 
 * // Running the Dijkstras implementation that uses the min-heap
 * DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
 * int[] distancesWithout = dWithout.run(source);
 * for (int i = 0; i < distancesWithout.length; i++) {
 * System.out.print(distancesWithout[i]);
 * System.out.print(" ");
 * }
 * System.out.println();
 */
        
        n = 5;
        int[][] edges = { { 1, 2, 50 }, { 2, 3, 10 }, { 3, 4, 20 }, { 3, 5,
            50 }, { 4, 5, 10 } };
        int source = 2;
        // The distance of each node from the source vertex
        int[] expectedDistances = { 50, 0, 10, 30, 40 };

        // Running the Dijkstras implementation that uses the min-heap
        System.out.println("Initilizing with heap");
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        System.out.println("Running with heap");

        int[] distancesWith = dWith.run(source);

        for (int d = 0; d < distancesWith.length; d++) {
            System.out.print(distancesWith[d] + " ");
        }
        System.out.println();

        // Running the Dijkstras implementation that uses the min-heap
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(source);

        for (int d = 0; d < distancesWithout.length; d++) {
            System.out.print(distancesWithout[d] + " ");
        }

    }


    /*
     * This method reads a file and returns the data of the graph
     * You do not need to change anything inside this method
     * 
     * @param name The name of the file
     * 
     * @return graph
     */
    private static Graph readFile(String name) {
        int n = 0, m, source = 0;
        int count = 0;
        int[][] edges = new int[1][1];
        try {
            File myObj = new File(name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splited = data.split(" ", 0);
                if (n == 0) {
                    n = Integer.valueOf(splited[0]);
                    m = Integer.valueOf(splited[1]);
                    source = Integer.valueOf(splited[2]);
                    edges = new int[m][3];
                }
                else {
                    edges[count][0] = Integer.valueOf(splited[0]);
                    edges[count][1] = Integer.valueOf(splited[1]);
                    edges[count][2] = Integer.valueOf(splited[2]);
                    count += 1;
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return new Graph(n, edges, source);
    }
}




/*
 * Just a simple class to store the graph
 * It is used to pass multiple information
 * from one method to another
 * 
 * @author Pouyan
 *
 */
class Graph {
    public int n;
    public int[][] edges;
    public int source;

    public Graph(int n, int[][] edges, int source) {
        this.n = n;
        this.edges = edges;
        this.source = source;
    }
}
