package tech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class node {
    int number = 1;
    int edge = 0;
    List<node> adj = new ArrayList<>();

    public node(int number, int edge) {
        this.number = number;
        this.edge = edge;
    }

    public node() {
    }
}

public class Solution2 {

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        // examine the test cases
        for (int i = 0; i < n; i++) {
            int edges = s.nextInt();

            // temp list for edges as arrays
            List<int[]> edgesArrays = new ArrayList<>();

            // the head node
            node head = new node();

            // number of nodes
            int[] numberOfNodes = {1};

            // convert to arrays
            for (int j = 0; j < edges; j++) {

                String edgesString = s.nextLine();
                if (edgesString.isEmpty()) edgesString = s.nextLine();

                edgesArrays.add(Arrays.stream(edgesString.split(" ")).mapToInt(Integer::valueOf).toArray());
            }

            // convert to graph
            extractGraph(edgesArrays, head, numberOfNodes);

            // test cases
            int questions = s.nextInt();

            ArrayList<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < questions; j++) {
                numbers.add(s.nextInt());
            }

            ArrayList<Integer> answers = new ArrayList<>();

            for (Integer number : numbers) {
                answers.add(findAnswer(number, head));
            }
        }
    }

    private static Integer findAnswer(Integer number, node head) {
        for (int i = 0; i < number; i++) {
//            node
        }
        return null;
    }

    private static void extractGraph(List<int[]> edgesArrays, node head, int[] numberOfNodes) {
        for (int[] edgesArray : edgesArrays) {
            insert(head, edgesArray[0], edgesArray[1], numberOfNodes);
        }
    }

    private static void insert(node head, int parent, int edge, int[] numberOfNodes) {
        if (parent == head.number) {
            head.adj.add(new node(++numberOfNodes[0], edge));
            return;
        }
        for (node node : head.adj) {
            insert(node, parent, edge, numberOfNodes);
        }
    }
}