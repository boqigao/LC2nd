package design;

import java.util.HashMap;
import java.util.Map;

public class LC677 {

    class MapSumSimple {

        Map<String, Integer> map;

        public MapSumSimple() {
            this.map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.remove(key);
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (String key : map.keySet()) {
                if (key.indexOf(prefix) == 0) {
                    sum += map.get(key);
                }
            }
            return sum;
        }
    }

    class MapSum {
        private Node root;
        public MapSum() {
            this.root = new Node();
        }

        public void insert(String key, int val) {
            Node node = this.root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }
                // 找下一层儿子
                node = node.children[index];
            }
            node.val = val;
        }

        public int sum (String prefix) {
            Node node = this.root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                node = node.children[index];
                if (node == null) {
                    return 0;
                }
            }

            return dfs(node);
        }

        private int dfs (Node node) {
            if (node == null) {
                return 0;
            }
            int ans = 0;

            if (node.val > 0) {
                ans = node.val;
            }
            for(Node child: node.children) {
                ans += dfs(child);
            }

            return ans;
        }

        private class Node {
            // 每个node最多有26儿子
            Node[] children = new Node[26];
            // 题目约定了val值大于0，所以，这里用0作为默认值，表示不是key的节点
            int val = 0;
        }
    }
}
