import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<Vertex> {
    private Edge<Vertex> edge;
    private Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();
}
    