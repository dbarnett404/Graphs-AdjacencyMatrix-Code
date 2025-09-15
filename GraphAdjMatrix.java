import java.util.HashMap;
import java.util.Map;

public class GraphAdjMatrix implements Graph {
        // Map to store vertices by their labels
    private HashMap<String, Integer> labelToIndex;
    private int[][] adjacencyMatrix;
    private int size;
    public GraphAdjMatrix(int matrixSize) {
        adjacencyMatrix = new int[matrixSize][matrixSize];
        labelToIndex = new HashMap<>();
        size = 0;
    }
    @Override
    public void addVertex(String vertexLabel) {
        labelToIndex.put(vertexLabel, size);
        size++;
    }
    @Override
    public void addEdge(String label1, String label2, int weight) {
        int i = labelToIndex.get(label1);
        int j = labelToIndex.get(label2);
        adjacencyMatrix[i][j] = weight;
        adjacencyMatrix[j][i] = weight; // if undirected
    }

    @Override
    public int fetchEdgeWeight(String label1, String label2) {
        int i = labelToIndex.get(label1);
        int j = labelToIndex.get(label2);
        return adjacencyMatrix[i][j];
    }

    @Override
    public int size() {
        return labelToIndex.size();
    }

    @Override
    public void display() {
        // Build an array to map index to label
        String[] indexToLabel = new String[labelToIndex.size()];
        for (Map.Entry<String, Integer> entry : labelToIndex.entrySet()) {
            indexToLabel[entry.getValue()] = entry.getKey();
        }

        // Print header row
        for (int i = 0; i < indexToLabel.length; i++) {
            System.out.print(String.format("%5s", indexToLabel[i]));
        }
        System.out.println();

        // Print each row
        for (int i = 0; i < indexToLabel.length; i++) {
            //System.out.print(String.format("%4s", indexToLabel[i]));
            System.out.print(String.format("%s", indexToLabel[i]));
            for (int j = 0; j < indexToLabel.length; j++) {
                System.out.print("|" + String.format("%3d", adjacencyMatrix[i][j]) + " ");
            }
            System.out.println("|");
        }
    }

}
