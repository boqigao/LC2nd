package graph;

import java.util.*;

public class LC399 {

    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, ArrayList<Node>> graph = new HashMap<>();
            int i = 0;

            // create graph
            for (List<String> list : equations) {
                String divisor = list.get(0);
                String dividend = list.get(1);
                ArrayList<Node> nodes = new ArrayList<>();
                if (graph.containsKey(divisor)) {
                    nodes = graph.get(divisor);
                } else {
                    nodes = new ArrayList<>();
                }
                nodes.add(new Node(dividend, values[i]));
                graph.put(divisor, nodes);

                ArrayList<Node> nodes1 = new ArrayList<>();
                if (graph.containsKey(dividend)) {
                    nodes1 = graph.get(dividend);
                } else {
                    nodes1 = new ArrayList<>();
                }
                nodes1.add(new Node(divisor, 1.0 / values[i]));
                graph.put(dividend, nodes1);
                i++;
            }

            double[] ans = new double[queries.size()];
            int j = 0;

            for (List<String> query : queries) {
                ans[j] = dfs(query.get(0), query.get(1), graph, new HashSet<>());
                j++;
            }
            return ans;
        }

        public double dfs(String start, String end,
                          Map<String, ArrayList<Node>> graph, Set<String> visited) {
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                return -1.0;
            }
            if (start.equals(end)) {
                return 1.0;
            }
            visited.add(start);

            for (Node nodes : graph.get(start)) {
                if (!visited.contains(nodes.to)) {
                    double ans = dfs(nodes.to, end, graph, visited);
                    if (ans != -1.0) {
                        return ans * nodes.weight;
                    }
                }
            }
            return -1.0;
        }


    }

    class Node {
        String to;
        double weight;

        public Node(String to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
