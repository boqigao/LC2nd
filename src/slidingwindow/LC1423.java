package slidingwindow;

import java.util.Arrays;

public class LC1423 {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int len = cardPoints.length;
            int except = len - k;
            int sum = 0;
            for (int i = 0; i < except; i++) {
                sum += cardPoints[i];
            }
            int minSum = sum;
            for (int i = except; i < len; i++) {
                sum += cardPoints[i];
                sum -= cardPoints[i-except];
                minSum = Math.min(minSum, sum);
            }

            return Arrays.stream(cardPoints).sum() - minSum;
        }
    }
}
