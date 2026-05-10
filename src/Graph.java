import java.util.*;
public class Graph {
    private Map<Integer, List<Edge>> adjList;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjList = new HashMap<>();
        vertices = new HashMap<>();
    }

    //add Vertex to graph
    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        vertices.putIfAbsent(from, new Vertex(from));
        vertices.putIfAbsent(to, new Vertex(to));
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());

        Vertex src = vertices.get(from);
        Vertex dst = vertices.get(to);
        adjList.get(from).add(new Edge(src, dst));
    }

    public void printGraph() {
        System.out.println("Graph Adjacency List:");
        for (int id : adjList.keySet()) {
            System.out.print("  " + id + " -> [");
            List<Edge> edges = adjList.get(id);
            for (int i = 0; i < edges.size(); i++) {
                System.out.print(edges.get(i).getDestination().getId());
                if (i < edges.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.println("BFS: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (Edge edge : adjList.getOrDefault(current, new ArrayList<>())) {
                int neighbor = edge.getDestination().getId();  // get ID from Edge
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        System.out.print("DFS: ");

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + " ");

                List<Edge> edges = adjList.getOrDefault(current, new ArrayList<>());
                for (int i = edges.size() - 1; i >= 0; i--) {
                    int neighbor = edges.get(i).getDestination().getId();
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }
}
