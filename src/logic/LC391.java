package logic;

import java.util.HashSet;
import java.util.Set;

public class LC391 {

    /**
     * idea:
     * 如果是完美矩形，那么一定要满足两点：
     * 1. 最左下，最左上，最右下，最右上的的四个点只出现过一次，其他点成对出现
     * 2. 四个点围成的矩形面积 = 所有矩形的和
     */
    class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MIN_VALUE;
            int top = Integer.MIN_VALUE;
            int bottom = Integer.MAX_VALUE;
            int n = rectangles.length;

            Set<String> set = new HashSet<>();

            int sumArea = 0;

            for (int i = 0; i < n; i++) {
                //更新大矩形四个点坐标
                left = Math.min(left, rectangles[i][0]);
                bottom = Math.min(bottom, rectangles[i][1]);
                right = Math.max(right, rectangles[i][2]);
                top = Math.max(top, rectangles[i][3]);

                // 宽 * 高 = （右 - 左）*（上 - 下）添加上小长方形面积
                sumArea += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);

                // 记录小矩形的四个坐标
                String lb = rectangles[i][0] + "," + rectangles[i][1];
                String lt = rectangles[i][0] + "," + rectangles[i][3];
                String rb = rectangles[i][2] + "," + rectangles[i][1];
                String rt = rectangles[i][2] + "," + rectangles[i][3];

                // 有就移除，没有就加入
                if (!set.contains(lt)) set.add(lt);
                else set.remove(lt);
                if (!set.contains(lb)) set.add(lb);
                else set.remove(lb);
                if (!set.contains(rb)) set.add(rb);
                else set.remove(rb);
                if (!set.contains(rt)) set.add(rt);
                else set.remove(rt);
            }

            // 最后只有最后四个坐标，就是说明坐标没问题，面积相等就是完美矩形
            return set.size() == 4 && set.contains(left + "," + top) && set.contains(left + "," + bottom) &&
                    set.contains(right + "," + top) && set.contains(right + "," + bottom) &&
                    sumArea == (right - left) * (top - bottom);
        }
    }
}

