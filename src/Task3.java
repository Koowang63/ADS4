import java.util.*;

public class Task3 {
    static Map<String, List<String>> graph = new HashMap<>();
    static void buildGraph() {
        graph.put("A", Arrays.asList("B", "C", "D"));
        graph.put("B", Arrays.asList("A", "C", "E", "G"));
        graph.put("C", Arrays.asList("A", "B", "D"));
        graph.put("D", Arrays.asList("C", "A"));
        graph.put("E", Arrays.asList("G", "F", "B"));
        graph.put("F", Arrays.asList("G", "E"));
        graph.put("G", Arrays.asList("F", "B"));
    }
    static void performDFS(String node, Set<String> visited) {
        System.out.print(node + " ");
        visited.add(node);
        for (String neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                performDFS(neighbor, visited);
            }
        }
    }

    static void performBFS(String start) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
    public static void main(String[] args) {
        buildGraph();

        System.out.print("DFS: ");
        performDFS("A", new HashSet<>());

        System.out.println();

        System.out.print("BFS: ");
        performBFS("A");
    }
}