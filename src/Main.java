import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static DirectedGraph graph = new DirectedGraph();


    public void readGraph() {

        /**
         * Task:
         *  - Take input using JFileChooser
         *  - Read the input file
         *  - build a Directed graph from the input data
         */


        // Open file reader window
        JFileChooser choice = new JFileChooser(new File("."));
        int option = choice.showOpenDialog(null);

        //check if user selected a valid file then proceed further
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // Take input from user input file using Scanner class from Java Utility
                Scanner input = new Scanner(choice.getSelectedFile());

                // Read the file line by line
                while (input.hasNextLine()) {
                    String edgeString = input.nextLine();
                    String[] edge = edgeString.split(" ");

                    // Marks the first node of the graph
                    // DFS starts from this node
                    if (graph.startingNode == null)
                        // this cline will be executed only once
                        graph.startingNode = graph.getVertex(edge[0]);

                    // add  edges to the Directed graph
                    // First node of the Line   --------------->   All other nodes
                    for (int i = 1; i < edge.length; i++) {
                        graph.addEdge(edge[0], edge[i]);
//                        System.out.println(edge[0] + "\t" + edge[i]);
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


    }


    public static void main(String[] args) {

        // Initializing Main Class
        new Main().readGraph();

        // Starting Depth First Search Utility to complete the DFS
        graph.depthFirstSearch();


        // Display Parenthesized List after processing the vertices
        System.out.println(graph.parenthesizedList.toString());

        // Display Hierarchy after processing the vertices
        System.out.println(graph.hierarchy.toString());

        // Display all the nodes that remained unreachable in the searching process
        graph.displayUnreachableClasses();


    }
}
