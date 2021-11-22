package string;

import java.util.HashSet;
import java.util.Set;

public class LC929 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strings = new String[] {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        int ans = s.numUniqueEmails(strings);
        System.out.println(ans);
    }
}

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        int ans = 0;
        for (String email : emails) {
            String[] strings = email.split("@");
            String leftHalf = strings[0];
            String rightHalf = strings[1];
            leftHalf = leftHalf.replaceAll("\\.","");
            if (leftHalf.contains("+")) {
                leftHalf = leftHalf.substring(0, leftHalf.indexOf("+"));
            }
            String tmp = leftHalf + "@" + rightHalf;
            set.add(tmp);
        }
        return set.size();
    }
}
