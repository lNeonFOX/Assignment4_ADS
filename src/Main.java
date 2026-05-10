public class Main {

    static Graph buildGraph(int n) {
        Graph g = new Graph();

        for (int i = 0; i < n; i++) {
            g.addVertex(new Vertex(i));
        }

        for (int i = 0; i < n; i++) {
            g.addEdge(i, i + 1);
            if (i + 2 < n) g.addEdge(i, i + 2);
        }
        return g;
    }

    public static void main(String[] args) {
        Graph small = buildGraph(10);
        Graph medium = buildGraph(30);
        Graph large = buildGraph(100);

        System.out.println("Small Graph (10 vertices)");
        small.printGraph();
        small.bfs(0);
        small.dfs(0);

        Experiment exp = new Experiment();
        exp.runMultipleTests(small, medium, large);
        exp.printResults();
    }
}