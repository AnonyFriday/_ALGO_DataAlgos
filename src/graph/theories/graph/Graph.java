package graph.theories.graph;

/* This program contains 2 parts: (1) and (2)
 * YOUR TASK IS TO COMPLETE THE PART (2) ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//-------------------------------------------------------------------------------

public class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) {  //do not edit this function
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile(".\\graph\\theories\\graph\\data\\data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i,
            RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    void breadth(boolean[] en,
            int i,
            RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k,
            RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited,
            int k,
            RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }

    }

    void depth(int k,
            RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    //Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        loadData(1);
        String fname = "E:\\Learning\\FPT\\2022_Semester-3\\CSD201\\AdvancedTopic\\Algorithms\\DataAlgos\\src\\graph\\theories\\graph\\data\\f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(0, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /* You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper. */

        customDisplayAllDFS(4, 8, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    // Method for displaying vertices including disconnected graph by using DFS
    void customDisplayAllDFS(int startIdx,
            int endIdx,
            RandomAccessFile f) {
        boolean[] visited = new boolean[n];

        // Result array contains index of each vertex
        ArrayList<Integer> result = new ArrayList<>(n);

        // DFS including disconnected graph
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                displayConnectedDFS(i, visited, result, f);
            }
        }

        // Looping and get result
        // e.g. 4th - 8th, then start from index 3 to 7
        int lowerBound = startIdx - 1;
        int upperBound = endIdx - 1;
        for (int i = lowerBound; i <= upperBound; i++) {
            try {
                fvisit(result.get(i), f);
            } catch (Exception ex) {
                Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Method for diplaying connected DFS
    private void displayConnectedDFS(
            int startIdx,
            boolean[] visited,
            List<Integer> result,
            RandomAccessFile f) {

        visited[startIdx] = true;
        result.add(startIdx);

        // Looping through the row to find the next possible path
        for (int i = 0; i < n; i++) {
            if (visited[i] == false && this.a[startIdx][i] > 0) {
                displayConnectedDFS(i, visited, result, f);
            }
        }
    }

//=================================================================
    void f2() throws Exception {
        loadData(13);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /* You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper. */

        dijkstra(a, 2, 7, f);
        dijkstra(a, 4, 6, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    /**
     * Dikstra
     *
     *
     *
     * Relax operation
     */
    public void dijkstra(int[][] graph,
            int startVIdx,
            int destVIdx,
            RandomAccessFile f) {

        boolean[] visited = new boolean[n]; // Determine if the vertex has been visitted
        int[] costs = new int[n];           // Shortest distance from start to each vertex
        int[] predecessors = new int[n];    // Storing the predecessor of each vertex

        int newCostToU;                     // The total cost from starting to U
        int costVU;
        int currV = startVIdx;

        // Preset the vertices and starting vertex
        preparePresetValue(startVIdx, visited, predecessors, costs);

        // Using for loop to traversal all vertices
        while (currV != -1) {
            visited[currV] = true;

            for (int u = 0; u < n; u++) {
                // Extract the current weight from V to U
                costVU = graph[currV][u];

                // If u has not yet been visited and weight not equals to INF
                if (visited[u] == false && costVU != 99) {
                    newCostToU = costVU + costs[currV];

                    // update new cost if old cost is greater than the new cost
                    if (newCostToU < costs[u]) {
                        costs[u] = newCostToU;
                        predecessors[u] = currV;
                    }
                }
            }
            // Move to next min cost vertex
            currV = findNextMinVisited(costs, visited);
        }

        printShortestPath(predecessors, destVIdx, f);
        printShortestPathCost(costs, destVIdx, f);
    }

    /**
     * Preset all essential variables and set the initial round for starting vertex
     *
     * @param startVIdx
     * @param visited
     * @param predecessor
     * @param costs
     */
    public void preparePresetValue(int startVIdx,
            boolean[] visited,
            int[] predecessor,
            int[] costs) {
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            costs[i] = 99;          // 99 is INFINITY
            predecessor[i] = -1;
        }

        // Initial data of the starting vertex
        visited[startVIdx] = true;
        costs[startVIdx] = 0;
    }

    /**
     * Find the next min cost vertex
     *
     * @param distance
     * @param visited
     *
     * @return
     */
    private int findNextMinVisited(int[] costs,
            boolean[] visited) {

        int minCost = 99; // 99 is INFINITY
        int minVIdx = -1;

        // Iterating the row to find the minimum cost at current vertex
        for (int i = 0; i < n; i++) {
            if (visited[i] == false && costs[i] < minCost) {
                minCost = costs[i];
                minVIdx = i;
            }
        }
        return minVIdx;
    }

    /**
     * Print Shortest Path from start to dest
     *
     * @param predecessor
     * @param startVIdx
     * @param destVIdx
     * @param f
     */
    private void printShortestPath(int[] predecessor,
            int destVIdx,
            RandomAccessFile f) {

        // Lookup on the predecessor array
        int vertexIdx = destVIdx;
        LinkedList<Integer> path = new LinkedList<>();

        // since tracking backward from dest to start, 
        // adding to the linkedlist first then printout later 
        while (vertexIdx != -1) {
            path.addFirst(vertexIdx);
            vertexIdx = predecessor[vertexIdx];
        }

        // Print out on the screen
        for (int idx : path) {
            try {
                fvisit(idx, f);
            } catch (Exception ex) {
                Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Print total cost from start to dest
     *
     * @param costs
     * @param destIdx
     * @param f
     */
    private void printShortestPathCost(int[] costs,
            int destIdx,
            RandomAccessFile f) {

        try {
            f.writeBytes("\n  " + costs[destIdx] + "\n");
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
