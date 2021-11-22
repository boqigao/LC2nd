package trick;

public class LC418 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"a", "bcd", "e"};
        int row = 30;
        int col = 6;
        System.out.println(s.wordsTyping(strs,row,col));
    }

    static class Solution {
        public int wordsTyping(String[] sentence, int rows, int cols) {
            StringBuilder sb = new StringBuilder();
            for (String word : sentence) {
                sb.append(word);
                sb.append(" ");
            }

            String sentenceStr = sb.toString();
            int len = sentenceStr.length();

            int counter = 0;
            for(int row = 0; row < rows; row++) {
                // 这个counter是用来计算现在把整个屏幕拉直了，他能计算到第几位
                counter += cols;
                // 如果counter除长度，取到的那一位正好是一个空格
                // 那我们正好可以从这里换行
                if (sentenceStr.charAt(counter % len) == ' ') {
                    counter++;
                } else {
                    // 如果取到的那一位不是一个空格
                    // 那说明当前这行放不下了，我们得回退到一个空格
                    while (counter >= 0 && sentenceStr.charAt(counter % len) != ' ') {
                        counter--;
                    }

                    //退到那个空格以后，再把counter++换一行新的
                    counter++;
                }
            }
            return counter / len;
        }
    }
}
