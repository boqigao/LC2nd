package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC1088 {

    /**
     * 确保需要验证的数字是 0 1 6 8 9 组成
     * 并且末尾为0切 0 1 6 8 9组成的数字一定是易混淆数
     */
    class Solution {
        int[] add = {0, 1,6, 8,9};
        public int confusingNumberII(int n) {
            if (n < 6) {
                return 0;
            } else if (n < 9) {
                return 1;
            } else if (n < 10) {
                return 2;
            }

            Queue<Integer> queue = new LinkedList<>();
            int count = 2;
            queue.offer(1);
            queue.offer(6);
            queue.offer(8);
            queue.offer(9);


            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int i = 0; i < 5; i++) {
                    int newNum = cur * 10 + add[i];
                    if (newNum > n) {
                        return count;
                    }
                    queue.offer(newNum);
                    if (i == 0 || checkConfusing(newNum)) count++;
                }
            }

            return count;
        }

        private boolean checkConfusing(int num) {
            int r = 0;
            int n = num;

            // 计算是否是confusing数字，类似于回文数？
            do {
                switch (n % 10){
                    case 0 : r = r * 10; break;
                    case 1 : r = r * 10 + 1; break;
                    case 6 : r = r * 10 + 9; break;
                    case 9 : r = r * 10 + 6; break;
                    case 8 : r = r * 10 + 8; break;
                }
                n = n / 10;
            }while (n > 0);
            return num != r;
        }
    }
}
