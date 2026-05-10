public class Experiment {
    private long[] bfsTimes = new long[3];
    private long[] dfsTimes = new long[3];
    private String[] labels = {"Small (10)", "Medium (30)", "Large (100)"};

    public void runTraversals(Graph g, int startVertex, int index) {
        long start, end;

        start = System.nanoTime();
        g.bfs(startVertex);
        end = System.nanoTime();
        bfsTimes[index] = end - start;

        start = System.nanoTime();
        g.dfs(startVertex);
        end = System.nanoTime();
        dfsTimes[index] = end - start;
    }

    public void runMultipleTests(Graph small, Graph medium, Graph large) {
        runTraversals(small, 0, 0);
        runTraversals(medium, 0, 1);
        runTraversals(large, 0, 2);
    }

    public void printResults() {
        System.out.println("Performance Results");
        System.out.printf("%-15s %-20s %-20s%n", "Graph Size", "BFS Time (ns)", "DFS Time (ns)");
        System.out.println("-".repeat(55));
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-15s %-20d %-20d%n", labels[i], bfsTimes[i], dfsTimes[i]);
        }
    }
}
