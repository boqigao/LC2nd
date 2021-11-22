package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC559 {

    class SolutionBfs {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            int ans = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    Node node = queue.poll();
                    List<Node> children = node.children;
                    for (Node child: children) {
                        queue.offer(child);
                    }
                    size--;
                }
                ans++;
            }
            return ans;

        }
    }

    class SolutionDfs {
        int max = 0;
        public int maxDepth(Node root) {
            if (root == null ){
                return 0;
            }
            dfs(root, 1);

            return max;
        }

        public int dfs(Node node, int depth) {
            if (node == null ||node.children.size() == 0) {
                // 处理一层的情况
                max = Math.max(max, depth);
                return depth;
            }
            for (Node child : node.children) {
                dfs(child, depth + 1);
            }
            max = Math.max(max, depth + 1);
            return depth;
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
