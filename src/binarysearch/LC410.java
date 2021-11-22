package binarysearch;

import javax.swing.plaf.IconUIResource;

public class LC410 {
    public int splitArray(int[] nums, int m) {
        long left = 0, right = 0;
        for (int num : nums) {
            right += num;
            left = Math.max(left, num);
        }

        while (left < right) {
            long mid = (left + right) / 2;
            int numGroup = 0;
            long tmp = 0;

            for (int num : nums) {
                if (tmp + num > mid) {
                    // 分隔一个新数组出来
                    numGroup++;
                    tmp = 0;
                }
                tmp += num;
            }
            // 上面的操作没有加最后一个数组
            numGroup++;
            // 如果划分出来的数组太多，那么说明每个数组的和过小，要在大的半边寻找
            if (numGroup > m) {
                left = mid + 1;
            } else {
                // 如果划分出的数组太少，那么说明每个数组的和过大了，要在小的半边寻找。
                right = mid;
            }
        }
        return (int)left;
    }
}
