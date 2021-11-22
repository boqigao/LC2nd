package binarysearch;

public class LC4 {
    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 3, 5};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = len1;

        while (low < high) {
            // x 和 y 分别是数组1和2的分割线
            // 其中 x-1， x是数组1的中部值， y - 1, y 是数组2的中部值
            int x = (low + high) / 2;

            // 我们规定左边的数组要比右边的数组多一个值
            int y = (len1 + len2 + 1) / 2 - x;

            // 如果x为0，那么x的分割左边就什么都没有了，所以用-INF代替
            int maxLeftX, minRightX, maxLeftY, minRightY;
            if (x == 0) {
                maxLeftX = Integer.MIN_VALUE;
            } else {
                maxLeftX = nums1[x - 1];
            }

            // 如果x为num1的长度的话，说明这个边界已经移出去了，边界右边已经无法取到
            if (x == len1) {
                minRightX = Integer.MAX_VALUE;
            } else {
                minRightX = nums1[x];
            }

            if (y == 0) {
                maxLeftY = Integer.MIN_VALUE;
            } else {
                maxLeftY = nums2[y - 1];
            }

            if (y == len2) {
                minRightY = Integer.MAX_VALUE;
            } else {
                minRightY = nums2[y];
            }

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = x - 1;
            } else {
                low = x + 1;
            }


        }
        return  0.0;
    }
}
