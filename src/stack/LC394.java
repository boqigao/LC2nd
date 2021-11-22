package stack;

import java.util.Stack;

public class LC394 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("sd2[f2[e]g]i"));
    }
    static class Solution {
        public String decodeString(String s) {
            if (s == null || s.length() == 0) {
                return null;
            }
            char[] chars = s.toCharArray();
            Stack<Integer> numStack = new Stack<>();
            Stack<String> strStack = new Stack<>();
            int num = 0;
            StringBuilder cur = new StringBuilder();
            for (char c : chars) {
                if (isNumber(c)) {
                    num = 10 * num + c - '0';
                } else if (c == '[') {
                    numStack.push(num);
                    strStack.push(cur.toString());
                    num = 0;
                    cur = new StringBuilder();
                } else if (isAlpahbet(c)) {
                    cur.append(c);
                } else if (c == ']') {
                    int k = numStack.pop();
                    StringBuilder str = new StringBuilder(strStack.pop());
                    for (int j = 0; j < k; j++) {
                        str.append(cur);
                    }
                    cur = str;
                }
            }
            return cur.toString();
        }

        private boolean isNumber (char c) {
            if (c >= '0' && c <= '9') {
                return true;
            }
            return false;
        }

        private boolean isAlpahbet (char c) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                return true;
            }
            return false;
        }
    }
}
