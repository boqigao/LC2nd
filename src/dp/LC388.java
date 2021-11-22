package dp;

public class LC388 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        System.out.println(ans);
    }

}

/**
 * 类似动态规划
 */
class Solution {
    public int lengthLongestPath(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] sum = new int[input.length() + 1];    //从1开始，第0层就是0

        for (String s : input.split("\n")) {
            int level = s.lastIndexOf('\t') + 2;    // 计算当前在第几层（从第一层开始，没有\t就是第一层）
            int len = s.length() - (level - 1);     // 计算当前这一行的长度
            if (s.contains(".")) {
                res = Math.max(res, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;  //是目录，要+1，目录有个/的
            }
        }
        return res;
    }
}

class Solution2 {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        String[] words = input.split("\n");
        int[] pathLens = new int[words.length + 1];
        pathLens[0] = -1;
        int ans = 0;
        for (String word: words) {
            //没有 /t 就是返回1，最起码有1层
            int level = word.lastIndexOf('\t') + 1 + 1;
            // 计算除开 \t 以外的长度
            int nameLen = word.length() - (level - 1);
            // 更新当前level的高度: 为什么一定要更新？
            // 因为我只管我自己的子文件夹就好了! 别的子文件夹和我没关系！
            pathLens[level] = pathLens[level - 1] + nameLen + 1;
            // 如果是文件，就更新ans
            if (word.contains(".")) {
                ans = Math.max(ans, pathLens[level]);
            }
        }
        return ans;
    }
}

