package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new ArrayList<>();
            if (intervals == null || intervals.length == 0) {
                return new int[0][0];
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            for (int i = 0; i < intervals.length; i++) {
                int left = intervals[i][0];
                int right = intervals[i][1];

                if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                    res.add(new int[]{left,right});
                } else {
                    res.get((res.size() - 1))[1] = Math.max(res.get(res.size()-1)[1], right);
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
