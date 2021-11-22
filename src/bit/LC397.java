package bit;

public class LC397 {
    class SolutionBit {
        /**
         * 位运算的道理：
         * 如果最后一位是0， 那不用考虑，直接左移
         * 如果最后一位是1，要分情况考虑
         *  1. 如果倒数第二味是0， 那就 -1 ，这样不管倒数第三位如何，处理最后两位只要用一次操作
         *  2. 如果倒数第二位是1， 那就 + 1，这样不管倒数第三位如何，处理最后两位也只要用一次操作
         * @param n
         * @return
         */
        public int integerReplacement(int n) {
            long temp = n;
            int count = 0;

            while (temp != 1) {
                if ((temp & 1) != 1) {
                    temp = temp >> 1;
                } else {
                    if ((temp & 3)== 3 && temp != 3) {
                        temp++;
                    } else {
                        temp--;
                    }
                }
                count++;
            }
            return count;
        }
    }

    class SolutionRecursion {
        // 偶数的时候一定是直接除效率最高
        public int integerReplacement(int n) {
            return (int)find(n);
        }

        public long find (long n) {
            if (n == 1) {
                return 0;
            } else {
                if (n % 2 == 0) {
                    return 1 + find(n / 2);
                } else {
                    return 1 + Math.min(find(n - 1), find(n + 1));
                }
            }
        }
    }
}
