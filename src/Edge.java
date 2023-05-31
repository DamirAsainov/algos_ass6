public class Edge <V> {
    private Vertex<V> source;
    private Vertex<V> dest;
    private Double weight;

    public Edge(Vertex source, Vertex dest, Double weight) {
        this.dest = dest;
        this.source = source;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDest() {
        return dest;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    @Override
    public String toString(){
        return dest.toString();
    }

}
