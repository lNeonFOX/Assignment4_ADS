# Assignment 4: Graph Traversal and Representation System
Project Overview
This project implements a Graph Traversal and Representation System in Java. A graph is a data structure made up of:

Vertices (nodes) — individual elements in the graph, each with a unique ID
Edges (connections) — links between two vertices, which can be directed (one-way) or undirected (two-way)

Graphs are used to model real-world systems such as social networks, road maps, computer networks, and scheduling problems.
This project implements two classic graph traversal algorithms:

BFS (Breadth-First Search) — explores the graph level by level, starting from the nearest neighbors
DFS (Depth-First Search) — explores the graph by going as deep as possible along each branch before backtracking

The graph is stored using an adjacency list, which maps each vertex to a list of its neighbors. This is memory-efficient for sparse graphs since it only stores existing edges.

Class Descriptions
Vertex.java
Represents a single node in the graph. Each vertex holds a unique integer id that identifies it. The class provides a constructor, a getter for the id, and a toString() method for readable output.
Edge.java
Represents a directed connection between two vertices. It stores a source vertex and a destination vertex. The class provides a constructor, getters for both endpoints, and a toString() method that displays the edge as source -> destination.
Graph.java
Represents the overall graph structure using an adjacency list — a HashMap that maps each vertex ID to a list of neighbor IDs. This class handles adding vertices and edges, printing the graph structure, and running BFS and DFS traversals.
Adjacency List Representation:
Instead of storing a full V×V matrix (which wastes memory when edges are sparse), the adjacency list stores only the actual edges. For example, if vertex 0 connects to vertices 1 and 2, the map stores: {0: [1, 2]}.
Experiment.java
Handles performance testing and result reporting. It runs BFS and DFS on graphs of different sizes (small, medium, large), records execution time using System.nanoTime(), and prints a formatted comparison table.
Main.java
The entry point of the program. It creates three graphs of sizes 10, 30, and 100 vertices, adds edges to each, runs traversals, prints the small graph's structure and traversal order, and delegates timing experiments to the Experiment class.

Algorithm Descriptions
Breadth-First Search (BFS)

Start at the given vertex. Mark it as visited and add it to a Queue
While the queue is not empty:

Remove the front vertex from the queue
Print/process it
For each unvisited neighbor, mark it visited and add it to the queue

Repeat until all reachable vertices are visited
Use cases:
Finding the shortest path between two vertices (in unweighted graphs)
Level-order traversal
Checking if a graph is connected
Social network friend suggestions (nearest connections first)

Time Complexity: O(V + E) — every vertex and every edge is visited exactly once

Depth-First Search (DFS)

Start at the given vertex. Push it onto a Stack
While the stack is not empty:

Pop the top vertex
If it has not been visited, mark it visited and print/process it
Push all unvisited neighbors onto the stack (in reverse order to preserve left-to-right traversal)


Repeat until all reachable vertices are visited
Use cases:
Detecting cycles in a graph
Topological sorting
Solving mazes or puzzles
Finding connected components

Time Complexity: O(V + E) — every vertex and every edge is visited exactly once

Experimental Results
Each graph was tested by running both BFS and DFS from vertex 0. Execution time was measured using System.nanoTime().
Execution Time Comparison Table
<img width="567" height="155" alt="изображение" src="https://github.com/user-attachments/assets/fb099a5a-083d-4011-aefb-e7239b77b485" />

Observations

As graph size increases, both BFS and DFS execution time increases, consistent with O(V + E) complexity
BFS and DFS have nearly identical time complexity in practice; differences are caused by data structure overhead (Queue vs Stack)
BFS tends to have slightly higher memory usage because it holds all vertices at the current level in the queue simultaneously
DFS traversal order differs from BFS: DFS goes deep before visiting siblings, while BFS visits all neighbors before going deeper
The execution times roughly scale proportionally with the number of vertices and edges, confirming the expected linear O(V + E) complexity

Graph Structure Output (Small Graph)
<img width="402" height="363" alt="изображение" src="https://github.com/user-attachments/assets/02e5e320-09ed-4082-9670-89251a839ad1" />

BFS/DFS Traversal Output
<img width="1817" height="337" alt="изображение" src="https://github.com/user-attachments/assets/7601d4a1-15cf-49ce-992b-a0d8be516654" />

Performance Results Table
<img width="648" height="187" alt="изображение" src="https://github.com/user-attachments/assets/31370ecc-eac9-4dcc-96c4-6fe059157fdd" />


Reflection
Implementing this graph traversal system deepened my understanding of how graph structures work and how different algorithms interact with them. The most important insight was how the choice of data structure determines the traversal behavior: BFS uses a Queue (First-In-First-Out), which naturally explores vertices level by level, while DFS uses a Stack (Last-In-First-Out), which pushes deeper into the graph before backtracking. Both algorithms share the same O(V + E) time complexity, yet they produce very different traversal orders and are suited to different problems. BFS is preferable when searching for the shortest path or exploring nearby nodes first, while DFS is better for tasks like cycle detection or exploring all possible paths.
One of the main challenges I faced was correctly implementing the adjacency list using a HashMap and ensuring that vertices were always added before edges, to avoid null pointer errors. Another challenge was understanding why DFS sometimes produces surprising traversal orders — it depends heavily on the order neighbors are stored in the list and the stack's LIFO behavior. Through the performance experiments, I confirmed that execution time scales linearly with graph size, matching the expected O(V + E) complexity. Overall, this assignment gave me practical experience with graph theory concepts and reinforced the importance of choosing the right algorithm and data structure for a given problem.
