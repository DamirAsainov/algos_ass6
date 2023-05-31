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
        if (!list.containsKey(source)) {
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
        if (neighbors != null) {
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

    public void DFS(Vertex startVertex) {
        Map<Vertex, Boolean> visited = new HashMap<>();
        DFSHelper(startVertex, visited);
    }

    private void DFSHelper(Vertex currentVertex, Map<Vertex, Boolean> visited) {
        visited.put(currentVertex, true);
        System.out.print(currentVertex + " ");

        List<Edge<V>> neighbors = list.get(currentVertex);
        if (neighbors != null) {
            for (Edge<V> neighbor : neighbors) {
                Vertex adjacentVertex = neighbor.getDest();
                if (!visited.containsKey(adjacentVertex)) {
                    DFSHelper(adjacentVertex, visited);
                }
            }
        }
    }

    public void BFS(Vertex startVertex) {
        Map<Vertex, Boolean> visited = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startVertex);
        visited.put(startVertex, true);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            List<Edge<V>> neighbors = list.get(currentVertex);
            if (neighbors != null) {
                for (Edge<V> neighbor : neighbors) {
                    Vertex adjacentVertex = neighbor.getDest();
                    if (!visited.containsKey(adjacentVertex)) {
                        queue.add(adjacentVertex);
                        visited.put(adjacentVertex, true);
                    }
                }
            }
        }
    }
    public Map<Vertex, Double> dijkstra(Vertex startVertex) {
        Map<Vertex, Double> dist = new HashMap<>();
        for (Vertex vertex : list.keySet()) {
            dist.put(vertex, Double.MAX_VALUE);
        }
        dist.put(startVertex, 0d);

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(dist::get));
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            List<Edge<V>> neighbors = list.get(currentVertex);
            if (neighbors == null) {
                continue;
            }
            for (Edge<V> neighbor : neighbors) {
                Vertex<V> destination = neighbor.getDest();
                Double currentDistance = dist.get(currentVertex);
                if (currentDistance == null) {
                    continue;
                }
                double distance = currentDistance + neighbor.getWeight();
                Double destinationDistance = dist.get(destination);
                if (destinationDistance == null || distance < destinationDistance) {
                    dist.put(destination, distance);
                    queue.add(destination);
                }
            }
        }
        return dist;
    }
}
