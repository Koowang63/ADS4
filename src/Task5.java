import java.util.*;
public class Task5 {

    static class Edge {
        String target;
        int weight;
        Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static Map<String, List<Edge>> graph = new HashMap<>();

    static void buildGraph() {
        graph.put("Edinburgh", Arrays.asList(
                new Edge("Perth", 100),
                new Edge("Stirling", 50),
                new Edge("Glasgow", 70)
        ));

        graph.put("Stirling", Arrays.asList(
                new Edge("Perth", 40),
                new Edge("Edinburgh", 50),
                new Edge("Glasgow", 50)
        ));
        graph.put("Perth", Arrays.asList(
                new Edge("Dundee", 60),
                new Edge("Stirling", 40),
                new Edge("Edinburgh", 100)
        ));


        graph.put("Glasgow", Arrays.asList(
                new Edge("Stirling", 50),
                new Edge("Edinburgh", 70)
        ));
        graph.put("Dundee", new ArrayList<>());
    }

    static void findShortestPath(String start) {
        Map<String, Integer> distance = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        for (String node : graph.keySet()) {
            distance.put(node, Integer.MAX_VALUE);
        }

        distance.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();

            for (Edge edge : graph.get(current)) {
                int newDist = distance.get(current) + edge.weight;

                if (newDist < distance.get(edge.target)) {
                    distance.put(edge.target, newDist);
                    pq.add(edge.target);
                }
            }
        }
        System.out.println("Shortest to Dundee: " + distance.get("Dundee"));
    }

    public static void main(String[] args) {
        buildGraph();
        findShortestPath("Edinburgh");
    }
}