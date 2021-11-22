package bit;

public class LC318 {
    class Solution {
        public int maxProduct(String[] words) {
            if (words.length < 2) {
                return 0;
            }

            int[] arr = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                int sum = 0;
                for(int j = 0; j < words[i].length(); j++) {
                    sum = sum | (1 << (words[i].charAt(j) - 'a'));
                }
                arr[i] = sum;
            }

            int ans = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if ((arr[i] & arr[j]) == 0) {
                        ans = Math.max(words[i].length() * words[j].length(), ans);
                    }
                }
            }

            return ans;
        }
    }
}
