import java.util.*;

public class Graph<V> {
    // Starting node of the graph
    public V startingNode = null;

    // Map all the vertex name (String) to a corresponding Vertex
    Map<String, V> vertices = new HashMap<>();

    // Adjacency representation of the graph
    Map<V, ArrayList<V>> adjacencyList = new HashMap<>();

    // Track if a node/vertex is visited in the searching process
    Set<V> visited = new HashSet<>();

    // Representation utility
    ParenthesizedList hierarchy = new ParenthesizedList();
    Hierarchy parenthesizedList = new Hierarchy();

    // keep track if the graph contain a circle
    boolean cycle;

    //
    Set<V> discovered = new HashSet<>();

    public void depthFirstSearch() {
        /**
         * Task: initialize the DFS with all other related attributes
         */

        // Marking cycle flag as false
        cycle = false;
        // Starting DFS from the first node of the input data
        dfs(startingNode);
    }

    private void dfs(V node) {
        /**
         * Task: Search in the adjacency list in Depth-First-Order
         * @param node Node to discover with all of it's child
         */

        // check if the node is already visited in and not completed discovering it's child yet
        // If so, a cycle has been detected
        if (discovered.contains(node)) {
            cycle = true;

            // Perform DFS Actions Cycle Detected operation
            hierarchy.cycleDetected();
            parenthesizedList.cycleDetected();
            return;
        }

        // Perform DFS Actions Vertex Add operation
        hierarchy.processVertex((Vertex) node);
        parenthesizedList.processVertex((Vertex) node);

        // Perform DFS Actions Descend Vertex operation
        hierarchy.descendVertex((Vertex) node);
        parenthesizedList.descendVertex((Vertex) node);

        // add the node to the discovery list
        discovered.add(node);

        // mark the node as visited
        visited.add(node);

        // discover all of it's child
        ArrayList<V> list = adjacencyList.get(node);
        if (list != null) {
            for (V u : list)
                dfs(u);
        }


        // Perform DFS Actions Ascend Vertex operation
        hierarchy.ascendVertex((Vertex) node);
        parenthesizedList.ascendVertex((Vertex) node);
        
        // this node has discovered completely and remove it from the discovered list
        discovered.remove(node);

    }


    private V getVertex(String u) {
        // get the Mapped vertex reference of a node(String)
        return vertices.get(u);
    }

    public void displayUnreachableClasses(){
        /**
         * Task: Print all the unvisited nodes/classes
         */


        // Loop all over the adjacency list

        for (Map.Entry<V, ArrayList<V>> entry : adjacencyList.entrySet()) {
            // for each entry check if there is any unvisited/undiscovered node/class
            if(entry.getValue().size()>0){
                // if found one print it and mark it as visited to avoid double printing

                // check the node itself
                if(!visited.contains(entry.getKey())){
                    System.out.println(entry.getKey() + " is unreachable");
                    visited.add(entry.getKey());
                }

                // check all of it's adjacent nodes
                for (V vertex : entry.getValue()){

                    if(!visited.contains(vertex)){
                        System.out.println(vertex + " is unreachable");
                        visited.add(vertex);
                    }
                }
            }
        }

    }


}
