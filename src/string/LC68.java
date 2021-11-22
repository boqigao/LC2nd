package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 这道题目是一个纯粹的模拟方法
 * 根据题目要求的贪心算法，对于每一行，我们首先确定最多可以放置多少单词，这样可以得到该行的空格个数，从而确定该行单词之间的空格个数。
 * 根据题目的要求：
 *
 * 1. 当前行是最后一行：单词左对齐，且单词之间应该只有一个空格，在行末尾填充剩余空格
 * 2. 当前行不是最后一行，且只有一个单词，该单词左对齐，在行末尾填充空格。
 * 3. 当前行不是最后一行，且有且不只有一个单词：则我们假设当前行单词数为numWords, 空格数为numSpaces, 我们需要将空格均匀分配在单词之间，则单词之间应该至少有
 * avgSpace = numSpace / (numWords - 1)个空格，对于读出来的空格
 * extraSpaces = numSpaces % (numWords - 1)个空格，应该填在前面的extraSpaces之间。因此，前extraSpaces个单词之间填充的avgSpaces+1个空格，其余单词之间填充avgSpaces.
 * 个空格
 */
public class LC68 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        s.fullJustify(words, 16);
    }
    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
            int right = 0, n = words.length;
            while (true) {
                int left = right; // 当前行的第一个单词在word的位置，一开始在最左边
                int sumLen = 0; // 统计这一行单词长度之和
                // 循环确定当前行可以放多少个单词，注意单词之间应该至少有一个空格
                while (right < n && sumLen + words[right].length() + right - left < maxWidth) {
                    sumLen += words[right].length();
                    // right这边不仅仅是控制word的量，同时控制的是一个space,注意这个spaces是不放在sumLen里面
                    right++;
                }

                // 当前行是最后一行（因为right==n）：单词左对齐，且单词之间只有一个空格，在珩磨填充剩余空格
                if (right == n) {
                    StringBuffer sb = join(words, left, n, " ");
                    sb.append(blank(maxWidth - sb.length()));
                    ans.add(sb.toString());
                    return ans;
                }

                int numWords = right - left;
                int numSpaces = maxWidth - sumLen;

                // 当前行只有一个单词， ：该单词左对齐，在行末填充剩余空格
                if (numWords == 1) {
                    StringBuilder sb = new StringBuilder(words[left]);
                    sb.append(blank(numSpaces));
                    ans.add(sb.toString());
                    continue;
                }

                // 当前行不止一个单词


                int avgSpaces = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);
                StringBuffer sb = new StringBuffer();
                sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1)));
                sb.append(blank(avgSpaces));
                sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces)));
                ans.add(sb.toString());
            }

        }

        // 返回长度为n的由空格组成的字符串
        public String blank(int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        // join 返回用sep拼接的[left, right)范围内的word组成的字符串
        public StringBuffer join(String[] words, int left, int right, String sep) {
            StringBuffer sb = new StringBuffer(words[left]);
            for (int i = left + 1; i < right; i++) {
                sb.append(sep);
                sb.append(words[i]);
            }
            return sb;
        }
    }
}
