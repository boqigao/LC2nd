package string;

public class LC482 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.licenseKeyFormatting("2-5g-3-J", 2));
    }

    static class Solution {
        public String licenseKeyFormatting(String s, int k) {
            String[] strs = s.split("-");
            int len = 0;
            StringBuilder converStr = new StringBuilder();
            for (String str : strs) {
                len += str.length();
                converStr.append(str);
            }
            converStr = new StringBuilder(converStr.toString().toUpperCase());

            int reminder = len % k;
            int dev = len / k;
            char[] chars = converStr.toString().toCharArray();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < reminder; i++) {
                sb.append(chars[i]);
            }
            if (reminder > 0) {
                sb.append('-');
            }

            int count = reminder;
            for (int i = 0; i < dev; i++) {
                for (int j = 0; j < k; j++) {
                    sb.append(chars[count]);
                    count++;
                }
                sb.append('-');
            }

            return sb.substring(0, sb.length()-1);
        }
    }
}
