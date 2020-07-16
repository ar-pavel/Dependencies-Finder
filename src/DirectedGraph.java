public class DirectedGraph<T> implements GraphInterface<T> {

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void addVertex(T vertex) {

    }

    @Override
    public boolean hasVertex(T vertex) {
        return false;
    }

    @Override
    public void addEdge(T fromVertex, T toVertex) {

    }

    @Override
    public void clearMarks() {

    }

    @Override
    public void markVertex(T vertex) {

    }

    @Override
    public boolean isMarked(T vertex) {
        return false;
    }

    @Override
    public T getUnmarked() {
        return null;
    }
}
