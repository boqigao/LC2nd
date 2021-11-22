package dp;

/**
 * 滑动窗口的3指针方法，在必要的时候更新这三个指针
 *
 * i指针，j指针和tmp指针
 */
public class LC904 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] input = new int[] {0,1,2,2};
        System.out.println(s.totalFruit(input));
    }


    /**
     * 聪明方法
     */
    static class Solution2 {
        public int totalFruit(int[] fruits) {
            int ans = 0;
            if (fruits == null || fruits.length == 0) {
                return 0;
            }
            int tmpAns = 0;
            int fruitA = -1;
            int fruitB = -1;
            int curFruit = -1, curFruitLoc = 0;
            int j = 0;

            for (int i = 0; i < fruits.length; i++) {
                //如果当前水果是篮子里的水果种类
                if (fruits[i] == fruitA || fruits[i] == fruitB) {
                    // 记录当前水果种类和位置
                    // 当下两个篮子中最后出现的篮子从后往前连续相等最长的索引,即为未来的两个篮子中第一个篮子的起始索引
                    if (fruits[i] != curFruit) {
                        curFruit = fruits[i];
                        curFruitLoc = i;
                    }
                } else {
                    // 如果是新水果， 就要更新篮子
                    j = curFruitLoc;
                    curFruitLoc = i;
                    if (fruitA == curFruit) {
                        fruitB = fruits[i];
                    } else {
                        fruitA = fruits[i];
                        curFruit = fruitA;
                    }
                }
                tmpAns = i - j + 1;
                Math.max(ans, tmpAns);
            }
            return ans;
        }
    }
    /**
     * 笨方法
     */
    static class Solution {
        public int totalFruit(int[] fruits) {
            int ans = 0;
            if (fruits == null || fruits.length == 0) {
                return 0;
            }
            for (int i = 0; i < fruits.length; i++) {
                // 从 i 位置开始拿水果
                boolean full = false;
                int tmpAns = 0;
                int fruitA = fruits[i];
                int fruitB = -1;

                //遍历i之后的
                for (int j = i; j < fruits.length; j++) {
                    //如果碰到一个没见过的水果，而且还有一个篮子空的
                    if (fruits[j] != fruitA && !full
                            && fruitB == -1) {
                        fruitB = fruits[j];
                        full = true;
                        tmpAns++;
                        ans = Math.max(ans, tmpAns);
                    } else if (full && fruitA != fruits[j] && fruitB != fruits[j]) {
                        //如果两个篮子都有某种水果了
                        ans = Math.max(ans, tmpAns);
                        break;
                    } else {
                        tmpAns++;
                        ans = Math.max(ans, tmpAns);
                    }
                }
            }
            return ans;
        }
    }
}

//笨方法

