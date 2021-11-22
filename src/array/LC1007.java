package array;

public class LC1007 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tops = new int[]{1,2,1,1,1,2,2,2};
        int[] bottoms = new int[]{2,1,2,2,2,2,2,2};
        System.out.println(s.minDominoRotations(tops, bottoms));
    }
    static class Solution {
        public int minDominoRotations(int[] tops, int[] bottoms) {

            int ans = Integer.MAX_VALUE;
            int len = tops.length;
            int[] topCopy = new int[tops.length];
            int[] bottomCopy = new int[bottoms.length];

            for (int i = 1; i <= 6; i++) {

                boolean topOk = true;
                boolean bottomOk = true;
                int ansTop=0, ansBottom = 0;
                System.arraycopy(tops, 0, topCopy, 0, len);
                System.arraycopy(bottoms, 0, bottomCopy, 0, len);

                for (int j = 0; j < tops.length; j++) {
                    if (bottoms[j] == i || topCopy[j] == i) {
                        if (topCopy[j] != i) {
                            topCopy[j] = i;
                            ansTop++;
                        }
                    } else {
                        topOk = false;
                    }

                    if (tops[j] == i || bottomCopy[j] == i) {
                        if (bottomCopy[j] != i) {
                            bottomCopy[j] = i;
                            ansBottom++;
                        }
                    } else {
                        bottomOk = false;
                    }

                    if ((!bottomOk) && (!topOk)) {
                        break;
                    }

                    if (j == tops.length - 1 && topOk) {
                        ans = Math.min(ans, ansTop);
                    }

                    if (j == tops.length - 1 && bottomOk) {
                        ans = Math.min(ans, ansBottom);
                    }
                }


            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
}


