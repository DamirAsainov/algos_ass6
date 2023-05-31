
public class Main {
    public static void main(String[] args) {
        MyGraph<Integer> graph = new MyGraph<>();
        Vertex<Integer> s1 = new Vertex<>(1);
        Vertex<Integer> s2 = new Vertex<>(2);
        Vertex<Integer> s3 = new Vertex<>(3);
        Vertex<Integer> s4 = new Vertex<>(4);
        Vertex<Integer> s5 = new Vertex<>(5);
        graph.addEdge(s1, s2, 5d);
        graph.addEdge(s1, s3, 6d);
        graph.addEdge(s2, s4, 7d);
        graph.addEdge(s2, s5, 8d);
        graph.printGraph();
        System.out.println("DFS:");
        graph.DFS(s1);
        System.out.println("\nBFS:");
        graph.BFS(s1);
        System.out.println();
        System.out.println("Dijkstra Algorithm - " + graph.dijkstra(s1));
        System.out.println();
    }
}