import java.util.*;

public class MyGraph<V> {
    private Map<Vertex, List<Edge<V>>> list;


    public MyGraph() {
        list = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        list.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        Edge edge = new Edge(source, destination, weight);
        source.addAdjacentVertex(destination, weight);
        if(!list.containsKey(source)){
            list.put(source, new ArrayList<>());
        }

        list.get(source).add(edge);
//        validateVertex(source);
//        validateVertex(destination);
//        list.get(source).add(destination);
//        list.get(destination).add(source);
    }

//    private void validateVertex(Vertex index) {
//        if (!list.containsKey(index)) {
//            throw new IllegalArgumentException("Vertex " + index + " is out of the range");
//        }
//    }

    public void printGraph() {
        for (Map.Entry<Vertex, List<Edge<V>>> entry : list.entrySet()) {
            Vertex vertex = entry.getKey();
            List<Edge<V>> neighbors = entry.getValue();
            System.out.print("Vertex " + vertex + " is connected to: ");
            for (Edge<V> neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public void removeEdge(Vertex source, Vertex destination) {
        List<Edge<V>> neighbors = list.get(source);
        if (neighbors!=null) {
            neighbors.remove(destination);
        }
        list.get(destination).remove(source);
    }

    public boolean hasEdge(Vertex source, Vertex destination) {
        List<Edge<V>> neighbors = list.get(source);
        return neighbors != null && neighbors.contains(destination);
    }

    public List<Edge<V>> getNeighbors(Vertex vertex) {
        return list.getOrDefault(vertex, new LinkedList<>());
    }

    public void DFS(Vertex start) {
        Map<Vertex, Boolean> visited = new HashMap<>();
        for (Vertex vertex:list.keySet()) {
            visited.put(vertex,false);
        }
        DFSHelper(start, visited);

    }


    private void DFSHelper(Vertex vertex, Map<Vertex, Boolean> visited) {
        visited.put(vertex, true);
        System.out.print(vertex + " ");
        for(int i = 0; i < list.size(); i++){
            if(!visited.get(list.get(i))){
                DFSHelper((Vertex) list.get(i), visited);
            }
        }
    }
}