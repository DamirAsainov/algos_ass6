// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
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
        System.out.println();
        graph.DFS(s1);
//        MyGraph<Integer> temp = new MyGraph<>();
//        temp.addVertex(new Vertex<>(1));
//        temp.addVertex(new Vertex<>(3));
//        temp.addVertex(new Vertex<>(2));
//        temp.addVertex(new Vertex<>(4));
//        temp.addEdge(new Vertex<>(1), new Vertex<>(3), 5);
//        temp.addEdge(new Vertex<>(1), new Vertex<>(2), 3);
//        temp.addEdge(new Vertex<>(2), new Vertex<>(4), 1);
//        temp.addEdge(new Vertex<>(3), new Vertex<>(4), 5);
//        temp.printGraph();
//        System.out.println();
//        temp.removeEdge(new Vertex<>(2), new Vertex<>(3));
//        temp.printGraph();
//        System.out.println(temp.hasEdge(new Vertex<>(1),new Vertex<>(3)));
//        System.out.println(temp.hasEdge(new Vertex<>(1),new Vertex<>(2)));
//        System.out.println(temp.getNeighbors(new Vertex<>(1)));
//        temp.DFS(new Vertex<>(1));
    }
}