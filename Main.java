
public class Main {
    private static String[] vertexLabels = {"A", "B", "C", "D", "E"};

    public static Graph buildAdjacencyMatrix(GraphAdjMatrix graph) {
        // Create a map to hold vertex labels to their indices
        for (String label : vertexLabels) {
            graph.addVertex(label);
        }
        // A: (B,20), (C,30)
        graph.addEdge("A", "B", 20);
        graph.addEdge("A", "C", 30);
        // B: (A,20), (C,30), (E,25)
        graph.addEdge("B", "A", 20);
        graph.addEdge("B", "C", 30);
        graph.addEdge("B", "E", 25);
        // C: (A,30), (B,30), (D,35)
        graph.addEdge("C", "A", 30);
        graph.addEdge("C", "B", 30);
        graph.addEdge("C", "D", 35);
        // D: (C,35), (E,40)
        graph.addEdge("D", "C", 35);
        graph.addEdge("D", "E", 40);
        // E: (B,25), (D,40)
        graph.addEdge("E", "B", 25);
        graph.addEdge("E", "D", 40);
        return graph;
    }

    
    public static void main(String[] args) {
        GraphAdjMatrix adjacencyMatrixGraph = new GraphAdjMatrix(vertexLabels.length);
        buildAdjacencyMatrix((GraphAdjMatrix) adjacencyMatrixGraph);
        adjacencyMatrixGraph.display();
        
    }
}