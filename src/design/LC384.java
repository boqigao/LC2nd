package design;

import java.util.*;


public class LC384 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Solution s = new Solution(arr);
        System.out.println(s.shuffle());
        System.out.println(s.reset());

    }
    static class Solution {
        int[] nums;
        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            if(nums.length == 0)
                return null;
            int[] res = nums.clone();
            for(int i = 0; i < nums.length; i++){
                int rand = (int)(Math.random() * (nums.length - i)) + i;
                swap(res, rand, i);
            }

            return res;
        }

        private void swap(int[] nums, int indexA, int indexB){
            int temp = nums[indexA];
            nums[indexA] = nums[indexB];
            nums[indexB] = temp;
        }
    }
}
