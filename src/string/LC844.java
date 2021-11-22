package string;

public class LC844 {
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            s = reformat(s, sb1);
            t = reformat(t, sb2);
            if (s.equals(t)) {
                return true;
            } else {
                return false;
            }
        }

        private String reformat(String t, StringBuilder sb2) {
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) != '#') {
                    sb2.append(t.charAt(i));
                } else {
                    if (sb2.length() == 0) {
                        continue;
                    } else {
                        sb2.deleteCharAt(sb2.length()-1);
                    }
                }
            }
            return sb2.toString();
        }
    }
}
