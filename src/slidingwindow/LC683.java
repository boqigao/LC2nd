package slidingwindow;

public class LC683 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.kEmptySlots(new int[] {1,2, 3}, 1));
    }
    static class Solution {
        public int kEmptySlots(int[] bulbs, int k) {
            if (bulbs == null || bulbs.length == 0 || k < 0) {
                return -1;
            }

            int[] bulbSeq = new int[bulbs.length];

            for (int i = 0; i < bulbs.length; i++) {
                bulbSeq[bulbs[i] - 1] = i + 1;
            }

            int left = 0, right = k + 1;
            int ans = Integer.MAX_VALUE;

            while (right < bulbSeq.length) {
                int newLeft = left;
                for (int i = left + 1; i < right; i++) {
                    if (bulbSeq[i] < bulbSeq[left] || bulbSeq[i] < bulbSeq[right]) {
                        newLeft = i;
                        break;
                    }
                }
                //相当于找一个波峰
                if(newLeft == left) {
                    ans = Math.min(ans, Math.max(bulbSeq[left], bulbSeq[right]));
                    // 如果已经找到一个答案了，说名bulSeq[right]比中间所有都小了，就不必再从中间开始找了
                    newLeft = right;
                }
                left = newLeft;
                right = left + k + 1;
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
}
