package design;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC146 {
    public static void main(String[] args) {

    }
    class LRUCache {

        int capacity;
        Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if (map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
            }else {
            return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
            } else {
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }
            map.put(key, value);

        }
    }
}
