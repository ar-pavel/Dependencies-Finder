import java.util.ArrayList;
import java.util.Map;

public class DirectedGraph extends Graph<Vertex> {
    public void addEdge(String u, String v) {
        ArrayList<Vertex> list = adjacencyList.get(getVertex(u));

//        System.out.print(u + " : ");
//        System.out.println(list);


        if (list == null) {
            list = new ArrayList<>();
        }

        list.add(getVertex(v));

        adjacencyList.put(getVertex(u), list);

//        System.out.println(list);
//        System.out.println();
    }

    public Vertex getVertex(String u) {
        if (vertices.containsKey(u))
            return vertices.get(u);

        vertices.put(u, new Vertex(u));
        return vertices.get(u);
    }



}
