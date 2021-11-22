package dp;

public class LC42 {
    class SolutionDP {
        public int trap(int[] height) {
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];

            leftMax[0] = 0;
            rightMax[height.length - 1] = 0;

            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            for (int i = height.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            int sum = 0;

            for (int i = 1; i < height.length - 1; i++) {
                sum += Math.min (leftMax[i], rightMax[i]) - height[i];
            }

            return sum;

        }
    }
}
