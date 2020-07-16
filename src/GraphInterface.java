public interface GraphInterface <T>{

    boolean isEmpty();
    // Returns true if this graph is empty; otherwise, returns false.

    boolean isFull();
    // Returns true if this graph is full; otherwise, returns false.

    void addVertex(T vertex);
    // Preconditions:
        //    This graph is not full.
        //    vertex is not already in this graph.
        //    vertex is not null.

    // Adds vertex to this graph.
    boolean hasVertex(T vertex);
    // Returns true if this graph contains vertex; otherwise, returns false.

    void addEdge(T fromVertex, T toVertex);
    // Adds an edge with the specified weight from fromVertex to toVertex.


    void clearMarks();
    // Unmark all vertices.

    void markVertex(T vertex);
    // Marks vertex.

    boolean isMarked(T vertex);
    // Returns true if vertex is marked; otherwise, returns false.

    T getUnmarked();
    // Returns an unmarked vertex if any exist; otherwise, returns null.


}

